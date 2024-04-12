package bank.management.system;
import com.mysql.cj.exceptions.DataReadException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Date;
import java.sql.*;

public class Deposit extends JFrame implements ActionListener {
    JButton deposit,back;
    JTextField amount;
    String pinnumber;
    public Deposit(String pinnumber){
        this.pinnumber=pinnumber;

        setLayout(null);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("image/atm.jpg"));
        Image i2= i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        JLabel text=new JLabel("Enter the amount you want to deposit");
        text.setForeground(Color.white);
        text.setFont(new Font("system", Font.BOLD,16));
        text.setBounds(170,300,400,20);
        image.add(text);

        amount =new JTextField();
        amount.setBounds(170,330,200,30);
        amount.setFont(new Font("system",Font.BOLD,16));
        image.add(amount);

        deposit =new JButton("Deposit");
        deposit.setBounds(320,480,190,30);
        deposit.addActionListener(this);
        image.add(deposit);

        back=new JButton("Back");
        back.setBounds(320,515,190,30);
        back.addActionListener(this);
        image.add(back);

        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);

    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==deposit){
            String number=amount.getText();
            Date date =new Date();
            if(number==" "){
                JOptionPane.showMessageDialog(null,"Please Enter amount you want to deposit");
            }else {
                try {
                    conn c = new conn();
                    String query = "insert into bank values('" + pinnumber + "','" + date + "','Deposit','" + number + "')";
                    c.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null,"RS "+number +" Deposited successfully");
                    setVisible(false);
                    new Transactions(pinnumber).setVisible(true);

                } catch (Exception e) {
                    System.out.println(e);
                }
            }

        } else if (ae.getSource()==back) {
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);

        }


    }


    public static void main(String[] args) {
        new Deposit("");
    }
}
