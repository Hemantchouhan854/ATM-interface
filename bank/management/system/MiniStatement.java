package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;

public class MiniStatement extends JFrame{
    String pinnumber;
    public MiniStatement(String pinnumber){
        this.pinnumber=pinnumber;

        setLayout(null);

        JLabel mini=new JLabel();
        mini.setBounds(20,140,400,200);
        add(mini);

        JLabel bank=new JLabel("INDIAN BANK");
        bank.setBounds(150,20,100,20);
        add(bank);

        JLabel card =new JLabel();
        card.setBounds(20,80,300,20);
        add(card);

        JLabel balance=new JLabel();
        balance.setBounds(20,400,300,20);
        add(balance);

        try{
            conn c=new conn();
            ResultSet rs=c.s.executeQuery("select * from login where pin='"+pinnumber+"'");
            while (rs.next()){
                card.setText("Card Number:"+rs.getString("cardNumber").substring(0,4)+"XXXXXXXX"+
                        rs.getString("cardNumber").substring(12));
            }

        }catch (Exception e){
            System.out.println(e);
        }
        try{
            conn c =new conn();
            int bal=0;
            ResultSet rs=c.s.executeQuery("select * from bank where pinnumber='"+pinnumber+"'");
            while (rs.next()){
                mini.setText(mini.getText()+"<html>"+rs.getString("date")+"&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("type")
                    +"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("amount")+"<br><br><html>");

                if(rs.getString("type").equals("Deposit")){
                    bal+=Integer.parseInt(rs.getString("amount"));
                }else{
                    bal-=Integer.parseInt(rs.getString("amount"));
                }
            }
            balance.setText("Your Current Account Balance is RS: "+bal);

        }catch (Exception e){
            System.out.println(e);
        }


        setSize(400,600);
        setLocation(20,20);
        getContentPane().setBackground(Color.white);
        setVisible(true);


    }


    public static void main(String[] args) {
        new MiniStatement("");

    }
}
