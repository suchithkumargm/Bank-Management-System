
import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;

public class SignUpOne extends JFrame implements ActionListener{
    long formNumber;
    JTextField nameText,fatherText,emailText,addressText,cityText,stateText,pinCodeText;
    JButton next;
    JRadioButton male,female,other,married,unmarried,noMention;
    JDateChooser dateChooser;

    SignUpOne(){
        setLayout(null);

        Random rand=new Random();
        long formNumber=Math.abs(rand.nextLong() % 9000L)+1000L;

        JLabel formNo=new JLabel("APPLICATION FORM NO. "+formNumber);
        formNo.setFont(new Font("Raleway",Font.BOLD,38));
        formNo.setBounds(140,20,600,40);
        add(formNo);

        JLabel personalDetails=new JLabel("Page 1: Personal Details");
        personalDetails.setFont(new Font("Raleway",Font.BOLD,22));
        personalDetails.setBounds(290,70,400,30);
        add(personalDetails);

        JLabel name=new JLabel("Name : ");
        name.setFont(new Font("Raleway",Font.BOLD,20));
        name.setBounds(100,120,100,30);
        add(name);
        
        nameText=new JTextField();
        nameText.setFont(new Font("Raleway",Font.BOLD,14));
        nameText.setBounds(300,120,400,30);
        add(nameText);
        
        JLabel fatherName=new JLabel("Father's Name : ");
        fatherName.setFont(new Font("Raleway",Font.BOLD,20));
        fatherName.setBounds(100,170,200,30);
        add(fatherName);
        
        fatherText=new JTextField();
        fatherText.setFont(new Font("Raleway",Font.BOLD,14));
        fatherText.setBounds(300,170,400,30);
        add(fatherText);
        
        JLabel dob=new JLabel("Date Of Birth : ");
        dob.setFont(new Font("Raleway",Font.BOLD,20));
        dob.setBounds(100,220,200,30);
        add(dob);
        
        dateChooser=new JDateChooser();
        dateChooser.setBounds(300,220,400,30);
        dateChooser.setForeground(new Color(105,105,105));
        add(dateChooser);
        
        JLabel gender=new JLabel("Gender : ");
        gender.setFont(new Font("Raleway",Font.BOLD,20));
        gender.setBounds(100,270,200,30);
        add(gender);
        
        male=new JRadioButton("Male");
        male.setBounds(300,270,60,30);
        male.setBackground(Color.white);
        add(male);
        
        female=new JRadioButton("Female");
        female.setBounds(420,270,120,30);
        female.setBackground(Color.white);
        add(female);

        other=new JRadioButton("Other");
        other.setBounds(540,270,120,30);
        other.setBackground(Color.white);
        add(other);

        ButtonGroup genderGroup=new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);
        genderGroup.add(other);
        
        JLabel email=new JLabel("Email Address : ");
        email.setFont(new Font("Raleway",Font.BOLD,20));
        email.setBounds(100,320,200,30);
        add(email);
        
        emailText=new JTextField();
        emailText.setFont(new Font("Raleway",Font.BOLD,14));
        emailText.setBounds(300,320,400,30);
        add(emailText);
        
        JLabel marital=new JLabel("Marital Status : ");
        marital.setFont(new Font("Raleway",Font.BOLD,20));
        marital.setBounds(100,370,200,30);
        add(marital);

        married=new JRadioButton("Married");
        married.setBounds(300,370,120,30);
        married.setBackground(Color.white);
        add(married);
        
        unmarried=new JRadioButton("Unmarried");
        unmarried.setBounds(420,370,120,30);
        unmarried.setBackground(Color.white);
        add(unmarried);

        noMention=new JRadioButton("Prefer not to mention");
        noMention.setBounds(540,370,200,30);
        noMention.setBackground(Color.white);
        add(noMention);

        ButtonGroup maritalGroup=new ButtonGroup();
        maritalGroup.add(married);
        maritalGroup.add(unmarried);
        maritalGroup.add(noMention);
        
        JLabel address=new JLabel("Address : ");
        address.setFont(new Font("Raleway",Font.BOLD,20));
        address.setBounds(100,420,200,30);
        add(address);
        
        addressText=new JTextField();
        addressText.setFont(new Font("Raleway",Font.BOLD,14));
        addressText.setBounds(300,420,400,30);
        add(addressText);
        
        JLabel city=new JLabel("City : ");
        city.setFont(new Font("Raleway",Font.BOLD,20));
        city.setBounds(100,470,200,30);
        add(city);
        
        cityText=new JTextField();
        cityText.setFont(new Font("Raleway",Font.BOLD,14));
        cityText.setBounds(300,470,400,30);
        add(cityText);
        
        JLabel state=new JLabel("State : ");
        state.setFont(new Font("Raleway",Font.BOLD,20));
        state.setBounds(100,520,200,30);
        add(state);

        stateText=new JTextField();
        stateText.setFont(new Font("Raleway",Font.BOLD,14));
        stateText.setBounds(300,520,400,30);
        add(stateText);

        JLabel pinCode=new JLabel("Pin Code : ");
        pinCode.setFont(new Font("Raleway",Font.BOLD,20));
        pinCode.setBounds(100,570,200,30);
        add(pinCode);

        pinCodeText=new JTextField();
        pinCodeText.setFont(new Font("Raleway",Font.BOLD,14));
        pinCodeText.setBounds(300,570,400,30);
        add(pinCodeText);

        JButton next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.white);
        next.setFont(new Font("Raleway",Font.BOLD,14));
        next.setBounds(620,620,80,30);
        next.addActionListener(this);
        add(next);

        getContentPane().setBackground(Color.white);

        setSize(900,700);
        setLocation(230,20);
        setVisible(true);
        
    }

    public void actionPerformed(ActionEvent e) {
        String formno=""+formNumber;    //long to string
        String name=nameText.getText();
        String father=fatherText.getText();
        String dob=((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();

        String gender=null;
        if(male.isSelected())
            gender="Male";
        else if(female.isSelected())
            gender="Female";
        else if(other.isSelected())
            gender="Other";

        String email=emailText.getText();
        
        String marital=null;
        if(married.isSelected())
            marital="Married";
        else if(unmarried.isSelected())
            marital="Unmarried";
        else if(noMention.isSelected())
            marital="Prefer not to mention";
            
        String address=addressText.getText();
        String city=cityText.getText();
        String state=stateText.getText();
        String pinCode=pinCodeText.getText();

        try{
            if(name.equals("")){
                JOptionPane.showMessageDialog(null, "Name is required");
            }else{
                Conn c=new Conn();
                String query="INSERT INTO signup values('"+formNumber+"','"+name+"','"+father+"','"+dob+"','"+gender+"','"+email+"','"+marital+"','"+address+"','"+city+"','"+state+"','"+pinCode+"');";
                c.s.executeUpdate(query);

                setVisible(false);
                new SignUpTwo(formNumber+"").setVisible(true);

            }
        }catch(Exception error){
            System.out.println(error);
        }

    }

    public static void main(String args[])
    {
        new SignUpOne();
    }

}
