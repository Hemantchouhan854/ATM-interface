package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.*;

public class Transactions extends JFrame implements ActionListener {
    JButton withdrawl,fastcash,minis,pinchange,balance,exit,deposit;
    String pinnumber;
    public Transactions(String pinnumber){
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

        deposit =new JButton("Deposit");
        deposit.setBounds(170,383,150,25);
        deposit.addActionListener(this);
        image.add(deposit);


        withdrawl =new JButton("Cash Withdrawl");
        withdrawl.setBounds(350,383,150,25);
        withdrawl.addActionListener(this);
        image.add(withdrawl);

        fastcash =new JButton("Fast Cash");
        fastcash.setBounds(170,423,150,25);
        fastcash.addActionListener(this);
        image.add(fastcash);

        minis =new JButton("Mini Statement");
        minis.setBounds(350,423,150,25);
        minis.addActionListener(this);
        image.add(minis);

        pinchange =new JButton("Pin Change");
        pinchange.setBounds(170,463,150,25);
        pinchange.addActionListener(this);
        image.add(pinchange);

        balance =new JButton("Balance Enquiry");
        balance.setBounds(350,463,150,25);
        balance.addActionListener(this);
        image.add(balance);

        exit =new JButton("EXIT");
        exit.setBounds(350,500,150,25);
        exit.addActionListener(this);
        image.add(exit);


        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);

    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==exit){
            System.exit(0);
        } else if (ae.getSource()==deposit) {
            setVisible(false);
            new Deposit(pinnumber).setVisible(true);
        }else if(ae.getSource()==withdrawl){
            setVisible(false);
            new Withdrawl(pinnumber).setVisible(true);
        }else if(ae.getSource()==fastcash){
            setVisible(false);
            new Fastcash(pinnumber).setVisible(true);
        }else if(ae.getSource()==pinchange){
            setVisible(false);
            new pinChange(pinnumber).setVisible(true);
        }else if(ae.getSource()==balance){
            setVisible(false);
            new BalanceEnquiry(pinnumber).setVisible(true);
        }else if(ae.getSource()==minis){
            new MiniStatement(pinnumber).setVisible(true);
        }
    }


    public static void main(String[] args) {
        new Transactions("");
    }
}
