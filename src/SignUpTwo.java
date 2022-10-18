import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;

public class SignUpTwo extends JFrame implements ActionListener{
    JComboBox religion,cateogory,income,qualification,occupation;
    JTextField pan,aadhar;
    JButton next;
    JRadioButton syes,sno,eyes,eno;
    String formNo;

    SignUpTwo(String formNo){
        this.formNo=formNo;
        setLayout(null);
        setTitle("NEW ACCOUTN APPLICATION FORM - PAGE 2");

        JLabel additionalDetails=new JLabel("Page 2: Additional Details");
        additionalDetails.setFont(new Font("Raleway",Font.BOLD,22));
        additionalDetails.setBounds(290,50,400,50);
        add(additionalDetails);

        JLabel relLabel=new JLabel("Religion : ");
        relLabel.setFont(new Font("Raleway",Font.BOLD,20));
        relLabel.setBounds(100,120,100,30);
        add(relLabel);
        
        String valReligion[]={"Hindu","Muslim","Sikh","Christian","Other"};
        religion = new JComboBox<>(valReligion);
        religion.setBounds(300,120,400,30);
        religion.setBackground(Color.WHITE);
        add(religion);
        
        JLabel catLabel=new JLabel("Cateogory : ");
        catLabel.setFont(new Font("Raleway",Font.BOLD,20));
        catLabel.setBounds(100,170,200,30);
        add(catLabel);
        
        String valCateogory[]={"General","OBC","SC","ST","Other"};
        cateogory = new JComboBox<>(valCateogory);
        cateogory.setBounds(300,170,400,30);
        cateogory.setBackground(Color.WHITE);
        add(cateogory);
        
        JLabel incLabel=new JLabel("Income : ");
        incLabel.setFont(new Font("Raleway",Font.BOLD,20));
        incLabel.setBounds(100,220,200,30);
        add(incLabel);
        
        String valIncome[]={"null","<1,50,000","<2,50,000","<5,00,000","Upto 10,00,000"};
        income = new JComboBox<>(valIncome);
        income.setBounds(300,220,400,30);
        income.setBackground(Color.WHITE);
        add(income);
        
        JLabel eduLabel=new JLabel("Educational");
        eduLabel.setFont(new Font("Raleway",Font.BOLD,20));
        eduLabel.setBounds(100,290,200,30);
        add(eduLabel);
        
        JLabel qualiLabel=new JLabel("Qualification : ");
        qualiLabel.setFont(new Font("Raleway",Font.BOLD,20));
        qualiLabel.setBounds(100,320,200,30);
        add(qualiLabel);

        String eduValues[]={"Non-graduate","Graduate","Post-graduate","Doctrate","Others"};
        qualification = new JComboBox<>(eduValues);
        qualification.setBounds(300,320,400,30);
        qualification.setBackground(Color.WHITE);
        add(qualification);
       
        
        JLabel occuLabel=new JLabel("Occupation : ");
        occuLabel.setFont(new Font("Raleway",Font.BOLD,20));
        occuLabel.setBounds(100,370,200,30);
        add(occuLabel);

        String occuValues[]={"Salaried","Self-employed","Buisness","Student","Retired","Others"};
        occupation = new JComboBox<>(occuValues);
        occupation.setBounds(300,370,400,30);
        occupation.setBackground(Color.WHITE);
        add(occupation);
        
        JLabel panNo=new JLabel("PAN no : ");
        panNo.setFont(new Font("Raleway",Font.BOLD,20));
        panNo.setBounds(100,420,200,30);
        add(panNo);
        
        pan=new JTextField();
        pan.setFont(new Font("Raleway",Font.BOLD,14));
        pan.setBounds(300,420,400,30);
        add(pan);
        
        JLabel aadaharNo=new JLabel("Aadhar no : ");
        aadaharNo.setFont(new Font("Raleway",Font.BOLD,20));
        aadaharNo.setBounds(100,470,200,30);
        add(aadaharNo);
        
        aadhar=new JTextField();
        aadhar.setFont(new Font("Raleway",Font.BOLD,14));
        aadhar.setBounds(300,470,400,30);
        add(aadhar);
        
        JLabel citizenLabel=new JLabel("Senior citizen : ");
        citizenLabel.setFont(new Font("Raleway",Font.BOLD,20));
        citizenLabel.setBounds(100,520,200,30);
        add(citizenLabel);

        syes=new JRadioButton("Yes");
        syes.setBounds(300,520,60,30);
        syes.setBackground(Color.white);
        add(syes);
        
        sno=new JRadioButton("No");
        sno.setBounds(420,520,120,30);
        sno.setBackground(Color.white);
        add(sno);

        ButtonGroup citizen=new ButtonGroup();
        citizen.add(syes);
        citizen.add(sno);

        JLabel exisAcc=new JLabel("Existing account : ");
        exisAcc.setFont(new Font("Raleway",Font.BOLD,20));
        exisAcc.setBounds(100,570,200,30);
        add(exisAcc);

        eyes=new JRadioButton("Yes");
        eyes.setBounds(300,570,60,30);
        eyes.setBackground(Color.white);
        add(eyes);
        
        eno=new JRadioButton("No");
        eno.setBounds(420,570,120,30);
        eno.setBackground(Color.white);
        add(eno);

        ButtonGroup existing=new ButtonGroup();
        existing.add(eyes);
        existing.add(eno);

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
        String relText=(String)religion.getSelectedItem();
        String catText=(String)cateogory.getSelectedItem();
        String incText=(String)income.getSelectedItem();
        String qualiText=(String)qualification.getSelectedItem();
        String occuText=(String)occupation.getSelectedItem();
        String panNo=pan.getText();
        String aadharNo=aadhar.getText();

        String seniorCitizen=null;
        if(syes.isSelected())
        seniorCitizen="Yes";
        else if(sno.isSelected())
        seniorCitizen="No";
        
        String existingAccount=null;
        if(eyes.isSelected())
            existingAccount="Yes";
        else if(eno.isSelected())
            existingAccount="No";

        try{
            if(income.equals("")){
                JOptionPane.showMessageDialog(null, "Name is required");
            }else{
                Conn c=new Conn();
                String query="INSERT INTO signup2 values('"+formNo+"','"+relText+"','"+catText+"','"+incText+"','"+qualiText+"','"+occuText+"','"+panNo+"','"+aadharNo+"','"+seniorCitizen+"','"+existingAccount+"')";
                c.s.executeUpdate(query);

                //signup 3 object
            }
        }catch(Exception error){
            System.out.println(error);
        }

    }

    public static void main(String args[])
    {
        new SignUpTwo("");
    }

}
