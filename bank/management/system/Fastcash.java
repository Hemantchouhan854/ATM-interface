package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.*;
import java.sql.ResultSet;
import java.util.Date;

public class Fastcash extends JFrame implements ActionListener {
    JButton withdrawl,fastcash,minis,pinchange,balance,back,deposit;
    String pinnumber;
    public Fastcash(String pinnumber){
        this.pinnumber=pinnumber;

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("image/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        JLabel text =new JLabel("Please Select Your Transaction");
        text.setBounds(215,300,600,35);
        text.setFont(new Font("system",Font.BOLD,16));
        text.setForeground(Color.WHITE);
        image.add(text);

        deposit =new JButton("RS 100");
        deposit.setBounds(170,383,150,25);
        deposit.addActionListener(this);
        image.add(deposit);


        withdrawl =new JButton("RS 500");
        withdrawl.setBounds(350,383,150,25);
        withdrawl.addActionListener(this);
        image.add(withdrawl);

        fastcash =new JButton("RS 1000");
        fastcash.setBounds(170,423,150,25);
        fastcash.addActionListener(this);
        image.add(fastcash);

        minis =new JButton("RS 2000");
        minis.setBounds(350,423,150,25);
        minis.addActionListener(this);
        image.add(minis);

        pinchange =new JButton("RS 5000");
        pinchange.setBounds(170,463,150,25);
        pinchange.addActionListener(this);
        image.add(pinchange);

        balance =new JButton("RS 10000");
        balance.setBounds(350,463,150,25);
        balance.addActionListener(this);
        image.add(balance);

        back =new JButton("Back");
        back.setBounds(350,500,150,25);
        back.addActionListener(this);
        image.add(back);


        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);

    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==back){
           setVisible(false);
           new Transactions(pinnumber).setVisible(true);
        } else{
            String amount=((JButton)ae.getSource()).getText().substring(3);
            conn c =new conn();
            try {
                ResultSet rs = c.s.executeQuery("select * from bank where pinnumber='" + pinnumber + "'");
                int balance=0;
                while (rs.next()){
                    if(rs.getString("type").equals("Deposit")){
                        balance+=Integer.parseInt(rs.getString("amount"));
                    }else{
                        balance-=Integer.parseInt(rs.getString("amount"));
                    }
                }
                if(ae.getSource()!=back && balance<Integer.parseInt(amount)){
                    JOptionPane.showMessageDialog(null,"Insufficient Balance");
                    return;
                }
                java.util.Date date =new Date();
                String query ="insert into bank values('"+pinnumber+"','"+date+"','Withdraw','"+amount+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null ,"RS "+amount+" Withdraw Successfully");

                setVisible(false);
                new Transactions(pinnumber).setVisible(true);

            }catch (Exception e){
                System.out.println(e);
            }
        }
    }


    public static void main(String[] args) {
        new Fastcash("");
    }
}
