package bank.management.system;
import com.mysql.cj.exceptions.DataReadException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Date;
import java.sql.*;

public class Withdrawl extends JFrame implements ActionListener {
    JButton Withdraw, back;
    JTextField amount;
    String pinnumber;

    public Withdrawl(String pinnumber) {
        this.pinnumber = pinnumber;

        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("image/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);

        JLabel text = new JLabel("Enter the amount you want to deposit");
        text.setForeground(Color.white);
        text.setFont(new Font("system", Font.BOLD, 16));
        text.setBounds(170, 300, 400, 20);
        image.add(text);

        amount = new JTextField();
        amount.setBounds(170, 330, 200, 30);
        amount.setFont(new Font("system", Font.BOLD, 16));
        image.add(amount);

        Withdraw = new JButton("Withdraw");
        Withdraw.setBounds(320, 480, 190, 30);
        Withdraw.addActionListener(this);
        image.add(Withdraw);

        back = new JButton("Back");
        back.setBounds(320, 515, 190, 30);
        back.addActionListener(this);
        image.add(back);

        setSize(900, 900);
        setLocation(300, 0);
        //    setUndecorated(true);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == Withdraw) {
            String number = amount.getText();
            Date date = new Date();
            if (number == " ") {
                JOptionPane.showMessageDialog(null, "Please Enter amount you want to Withdraw");
            } else if (ae.getSource() == back) {
                setVisible(false);
                new Transactions(pinnumber).setVisible(true);
            } else {
                try {
                    conn c = new conn();

                    ResultSet rs = c.s.executeQuery("select * from bank where pinnumber='" + pinnumber + "'");
                    int balance = 0;
                    while (rs.next()) {
                        if (rs.getString("type").equals("Deposit")) {
                            balance += Integer.parseInt(rs.getString("amount"));
                        } else {
                            balance -= Integer.parseInt(rs.getString("amount"));
                        }
                    }
                    if (ae.getSource() != back && balance < Integer.parseInt(number)) {
                        JOptionPane.showMessageDialog(null, "Insufficient Balance");
                        setVisible(false);
                        new Transactions(pinnumber).setVisible(true);
                        return;
                    }else{

                        String query = "insert into bank values('" + pinnumber + "','" + date + "','Withdraw','" + number + "')";
                        c.s.executeUpdate(query);
                        JOptionPane.showMessageDialog(null, "RS " + number + " Withdrawl successfully");
                        setVisible(false);
                        new Transactions(pinnumber).setVisible(true);

                    }
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }

            }
        }
    }

        public static void main (String[] args){
            new Deposit("");
        }

}
