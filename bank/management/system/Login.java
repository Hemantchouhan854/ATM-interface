package bank.management.system;
import bank.management.system.Signupone;
import bank.management.system.Transactions;
import bank.management.system.conn;
import com.mysql.cj.protocol.Resultset;

import javax.swing.*;
import javax.xml.transform.Result;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {
    JButton login,signup,clear;
    JTextField cardtextfiled;
    JPasswordField pintextfiled;
    public Login(){
        setTitle("Automated Teller Machine");

        setLayout(null);

        ImageIcon i1 =new ImageIcon(ClassLoader.getSystemResource("image/logo.jpg"));
        Image i2 =i1.getImage().getScaledInstance(100,100, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel label =new JLabel(i3);
        label.setBounds(70,10,100,100);
        add(label);

        JLabel text=new JLabel("Welcome to ATM");
        text.setFont(new Font("osward",Font.BOLD,38));
        text.setBounds(200,40,400,40);
        add(text);

        JLabel cardno=new JLabel("Card No:");
        cardno.setFont(new Font("Raleway",Font.BOLD,28));
        cardno.setBounds(120,150,150,30);
        add(cardno);

        cardtextfiled =new JTextField();
        cardtextfiled.setBounds(300,150,230,30);
        cardtextfiled.setFont(new Font("arial",Font.BOLD,14));
        add(cardtextfiled);

        JLabel pin=new JLabel("PIN:");
        pin.setFont(new Font("Raleway",Font.BOLD,28));
        pin.setBounds(120,220,250,30);
        add(pin);

        pintextfiled =new JPasswordField();
        pintextfiled.setBounds(300,220,230,30);
        pintextfiled.setFont(new Font("arial",Font.BOLD,14));
        add(pintextfiled);

        login =new JButton("SIGN IN");
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.setBounds(300,300,100,30);
        login.addActionListener(this);
        add(login);

        clear =new JButton("CLEAR");
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.setBounds(430,300,100,30);
        clear.addActionListener(this);
        add(clear);

        signup =new JButton("SIGN UP");
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.WHITE);
        signup.setBounds(300,350,230,30);
        signup.addActionListener(this);
        add(signup);


        getContentPane().setBackground(Color.WHITE);
        setSize(800,500);
        setVisible(true);
        setLocation(350,200);
    }
@Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()== clear){
            cardtextfiled.setText("");
            pintextfiled.setText("");

        }else if(ae.getSource()== login){
            conn c=new conn();
            String cardnumber =cardtextfiled.getText();
            String pinnumber= pintextfiled.getText();
            String query ="select * from login where cardNumber ='"+cardnumber+"'and pin='"+pinnumber+"'";
            try {
                ResultSet rs=  c.s.executeQuery(query);
                if(rs.next()){
                    setVisible(false);
                    new Transactions(pinnumber).setVisible(true);
                    }else{
                    JOptionPane.showMessageDialog(null,"Incorrect Cardnumber Or Pin");

                }
            }catch(Exception e){
                System.out.println(e);
            }


        }else if(ae.getSource()== signup){
            setVisible(false);
            new Signupone().setVisible(true);

        }

    }

    public static void main(String[] args) {
        new Login();
    }


}
