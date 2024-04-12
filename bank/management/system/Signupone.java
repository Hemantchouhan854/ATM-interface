package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;

public class Signupone extends JFrame implements ActionListener {

    long random;
    JTextField nametextfield,fnametextfield,addresstextfield,statetextfield,citytextfield,pintextfield,emailtextfield;
    JButton next;
    JRadioButton male,female,other,married,unmarried,divorce;
    JDateChooser   datechooser ;
    public Signupone(){

        Random ran=new Random();
        random=Math.abs((ran.nextLong() % 9000L)+1000L);


        JLabel formno =new JLabel("APPLICATION FORM NO."+random);
        formno.setFont(new Font("Raleway", Font.BOLD,39));
        formno.setBounds(140,20,600,40);
        add(formno);

        JLabel personaldetails =new JLabel("Page 1: Personal Details");
        personaldetails.setFont(new Font("Raleway", Font.BOLD,22));
        personaldetails.setBounds(290,80,400,30);
        add(personaldetails);

        JLabel name=new JLabel("Name:");
        name.setFont(new Font("Raleway", Font.BOLD,20));
        name.setBounds(100,140,100,30);
        add(name);

        nametextfield=new JTextField();
        nametextfield.setFont(new Font("Raleway", Font.BOLD,14));
        nametextfield.setBounds(300,140,400,30);
        add(nametextfield);

        JLabel fname=new JLabel("Father's Name:");
        fname.setFont(new Font("Raleway", Font.BOLD,20));
        fname.setBounds(100,190,200,30);
        add(fname);

        fnametextfield=new JTextField();
        fnametextfield.setFont(new Font("Raleway", Font.BOLD,14));
        fnametextfield.setBounds(300,190,400,30);
        add(fnametextfield);

        JLabel dob=new JLabel("Date of Birth:");
        dob.setFont(new Font("Raleway", Font.BOLD,20));
        dob.setBounds(100,240,200,30);
        add(dob);

        datechooser =new JDateChooser();
        datechooser.setBounds(300,240,400,30);
        datechooser.setForeground(new Color(105,105,105));
        add(datechooser);

        JLabel gender=new JLabel("Gender:");
        gender.setFont(new Font("Raleway", Font.BOLD,20));
        gender.setBounds(100,290,200,30);
        add(gender);

        male =new JRadioButton("Male");
        male.setBounds(300,290,60,30);
        male.setBackground(Color.WHITE);
        add(male);

        female =new JRadioButton("Female");
        female.setBounds(430,290,80,30);
        female.setBackground(Color.WHITE);
        add(female);

        other =new JRadioButton("Other");
        other.setBounds(570,290,60,30);
        other.setBackground(Color.WHITE);
        add(other);


        ButtonGroup buttongroup=new ButtonGroup();
        buttongroup.add(male);
        buttongroup.add(female);
        buttongroup.add(other);

        JLabel email=new JLabel("Email Address:");
        email.setFont(new Font("Raleway", Font.BOLD,20));
        email.setBounds(100,340,200,30);
        add(email);

        emailtextfield=new JTextField();
        emailtextfield.setFont(new Font("Raleway", Font.BOLD,14));
        emailtextfield.setBounds(300,340,400,30);
        add(emailtextfield);

        JLabel marital=new JLabel("Marital Status:");
        marital.setFont(new Font("Raleway", Font.BOLD,20));
        marital.setBounds(100,390,200,30);
        add(marital);

        married =new JRadioButton("Married");
        married.setBounds(300,390,100,30);
        married.setBackground(Color.WHITE);
        add(married);

        unmarried =new JRadioButton("Unmarried");
        unmarried.setBounds(430,390,100,30);
        unmarried.setBackground(Color.WHITE);
        add(unmarried);

        divorce =new JRadioButton("Divorced");
        divorce.setBounds(570,390,100,30);
        divorce.setBackground(Color.WHITE);
        add(divorce);


        ButtonGroup maritalgroup=new ButtonGroup();
        maritalgroup.add(married);
        maritalgroup.add(unmarried);
        maritalgroup.add(divorce);

        JLabel address=new JLabel("Address:");
        address.setFont(new Font("Raleway", Font.BOLD,20));
        address.setBounds(100,440,200,30);
        add(address);

        addresstextfield=new JTextField();
        addresstextfield.setFont(new Font("Raleway", Font.BOLD,14));
        addresstextfield.setBounds(300,440,400,30);
        add(addresstextfield);

        JLabel city=new JLabel("City:");
        city.setFont(new Font("Raleway", Font.BOLD,20));
        city.setBounds(100,490,200,30);
        add(city);

        citytextfield=new JTextField();
        citytextfield.setFont(new Font("Raleway", Font.BOLD,14));
        citytextfield.setBounds(300,490,400,30);
        add(citytextfield);

        JLabel state=new JLabel("State:");
        state.setFont(new Font("Raleway", Font.BOLD,20));
        state.setBounds(100,540,200,30);
        add(state);

        statetextfield=new JTextField();
        statetextfield.setFont(new Font("Raleway", Font.BOLD,14));
        statetextfield.setBounds(300,540,400,30);
        add(statetextfield);

        JLabel pincode=new JLabel("Pincode:");
        pincode.setFont(new Font("Raleway", Font.BOLD,20));
        pincode.setBounds(100,590,200,30);
        add(pincode);

        pintextfield=new JTextField();
        pintextfield.setFont(new Font("Raleway", Font.BOLD,14));
        pintextfield.setBounds(300,590,400,30);
        add(pintextfield);

        next=new JButton("NEXT");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setBounds(620,660,80,30);
        next.addActionListener(this);
        add(next);

        getContentPane().setBackground(Color.WHITE);

        setLayout(null);
        setSize(850,800);
        setLocation(350,10);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        String formno = "" + random;
        String name= nametextfield.getText();// use settext in login in
        String fname=fnametextfield.getText();
        String dob=((JTextField) datechooser.getDateEditor().getUiComponent()).getText();
        String gender=null;
        if(male.isSelected()){
            gender="Male";
        }else if(female.isSelected()){
            gender="Female";
        }else if(other.isSelected()){
            gender="Other";
        }
        String email=emailtextfield.getText();
        String marital=null;
        if(married.isSelected()){
            marital="Married";
        }else if(unmarried.isSelected()){
            marital="Unmarried";
        }else if(divorce.isSelected()){
            marital="Divorced";
        }
        String address=addresstextfield.getText();
        String state =statetextfield.getText();
        String city =citytextfield.getText();
        String pin =pintextfield.getText();

        try{
            if(name.equals("")){
                JOptionPane.showMessageDialog(null,"Name is Required");
            }else{
                conn c=new conn();
                String query="insert into signup values('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+marital+"','"+address+"','"+city+"','"+pin+"','"+state+"')";
                c.s.executeUpdate(query);
                setVisible(false);
                new SignupTwo(formno).setVisible(true);
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        new Signupone();

    }

}
