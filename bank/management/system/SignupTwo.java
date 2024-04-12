package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;

public class SignupTwo extends JFrame implements ActionListener {

    JTextField statetextfield,aadhartextfield,pantextfield;
    JButton next;
    JRadioButton eyes,eno,syes,sno,divorce,sno1;
    JComboBox religion,category,income,education,occuption;
    String formno;

    public SignupTwo(String formno){

        this.formno=formno;

        JLabel personaldetails =new JLabel("Page 2: Additionnal Details");
        personaldetails.setFont(new Font("Raleway", Font.BOLD,22));
        personaldetails.setBounds(290,80,400,30);
        add(personaldetails);

        JLabel name=new JLabel("Religion:");
        name.setFont(new Font("Raleway", Font.BOLD,20));
        name.setBounds(100,140,100,30);
        add(name);

        String valreligion[]={"Hindu","sikh","Muslim","Other"};
        religion =new JComboBox(valreligion);
        religion.setBounds(300,140,400,30);
        religion.setBackground(Color.WHITE);
        add(religion);


        JLabel fname=new JLabel("Category:");
        fname.setFont(new Font("Raleway", Font.BOLD,20));
        fname.setBounds(100,190,200,30);
        add(fname);

        String valcategory[]={"General","OBC","SC","ST","Other"};
        category=new JComboBox(valcategory);
        category.setBounds(300,190,400,30);
        category.setBackground(Color.WHITE);
        add(category);

        JLabel dob=new JLabel("Income:");
        dob.setFont(new Font("Raleway", Font.BOLD,20));
        dob.setBounds(100,240,200,30);
        add(dob);

        String valincome[]={"Null","< 1,50,000","< 2,50,000 ","< 5,00,000","Upto < 10,00,000"};
        income=new JComboBox(valincome);
        income.setBounds(300,240,400,30);
        income.setBackground(Color.WHITE);
        add(income);

        JLabel gender=new JLabel("Educational:");
        gender.setFont(new Font("Raleway", Font.BOLD,20));
        gender.setBounds(100,290,200,30);
        add(gender);

        JLabel email=new JLabel("Qualification:");
        email.setFont(new Font("Raleway", Font.BOLD,20));
        email.setBounds(100,315,200,30);
        add(email);

        String valqualification[]={"Non-Graduation","Graduate","Post-Graduation","Other"};
        education=new JComboBox(valqualification);
        education.setBounds(300,315,400,30);
        education.setBackground(Color.WHITE);
        add(education);

        JLabel marital=new JLabel("Occupation:");
        marital.setFont(new Font("Raleway", Font.BOLD,20));
        marital.setBounds(100,390,200,30);
        add(marital);


        String valocuupation[]={"Salaried","Self-Employed","Business","Retired","Other"};
        occuption=new JComboBox(valocuupation);
        occuption.setBounds(300,390,400,30);
        occuption.setBackground(Color.WHITE);
        add(occuption);

        divorce =new JRadioButton("Divorced");
        divorce.setBounds(570,390,100,30);
        divorce.setBackground(Color.WHITE);
        add(divorce);

        JLabel panlabel=new JLabel("PAN Number:");
        panlabel.setFont(new Font("Raleway", Font.BOLD,20));
        panlabel.setBounds(100,440,200,30);
        add(panlabel);

        pantextfield=new JTextField();
        pantextfield.setFont(new Font("Raleway", Font.BOLD,14));
        pantextfield.setBounds(300,440,400,30);
        add(pantextfield);

        JLabel aaharlabel=new JLabel("Aadhar Number:");
        aaharlabel.setFont(new Font("Raleway", Font.BOLD,20));
        aaharlabel.setBounds(100,490,200,30);
        add(aaharlabel);

        aadhartextfield=new JTextField();
        aadhartextfield.setFont(new Font("Raleway", Font.BOLD,14));
        aadhartextfield.setBounds(300,490,400,30);
        add(aadhartextfield);

        JLabel seniorClabel=new JLabel("Senior Citizen:");
        seniorClabel.setFont(new Font("Raleway", Font.BOLD,20));
        seniorClabel.setBounds(100,540,200,30);
        add(seniorClabel);

        syes =new JRadioButton("YES");
        syes.setBounds(300,540,90,30);
        syes.setBackground(Color.WHITE);
        add(syes);

        sno =new JRadioButton("NO");
        sno.setBounds(400,540,90,30);
        sno.setBackground(Color.WHITE);
        add(sno);

        ButtonGroup sgroup=new ButtonGroup();
        sgroup.add(syes);
        sgroup.add(sno);

        JLabel exisitinglabel=new JLabel("Exisiting Account:");
        exisitinglabel.setFont(new Font("Raleway", Font.BOLD,20));
        exisitinglabel.setBounds(100,590,200,30);
        add(exisitinglabel);

        eyes =new JRadioButton("YES");
        eyes.setBounds(300,590,90,30);
        eyes.setBackground(Color.WHITE);
        add(eyes);

        eno =new JRadioButton("NO");
        eno.setBounds(400,590,90,30);
        eno.setBackground(Color.WHITE);
        add(eno);

        ButtonGroup egroup=new ButtonGroup();
        egroup.add(eyes);
        egroup.add(eno);


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
    //religion,category,income,education,occuption;
    public void actionPerformed(ActionEvent ae) {
        String srelegion= (String)religion.getSelectedItem();
        String scategory=(String) category.getSelectedItem();
        String sincome=(String) income.getSelectedItem();
        String seducation=(String) education.getSelectedItem();
        String soccuption=(String) occuption.getSelectedItem();
        String seniorcitizin=null;
        if(syes.isSelected()){
            seniorcitizin="Yes";
        }else if(sno.isSelected()){
            seniorcitizin="No";
        }
        String exisitingaccount=null;
        if(eyes.isSelected()){
            exisitingaccount="Yes";
        }else if(eno.isSelected()){
            exisitingaccount="No";
        }
        String span=pantextfield.getText();
        String saadhar =aadhartextfield.getText();

        try{
            conn c=new conn();
            String query="insert into signuptwo values('"+formno+"','"+srelegion+"','"+scategory+"','"+sincome+"','"+seducation+"','"+soccuption+"','"+span+"','"+saadhar+"','"+seniorcitizin+"','"+exisitingaccount+"')";
            c.s.executeUpdate(query);

            setVisible(false);
            new SignupThree(formno).setVisible(true);

        }catch(Exception e){
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        new SignupTwo("");

    }

}
