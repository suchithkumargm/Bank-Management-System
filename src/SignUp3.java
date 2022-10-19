import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class SignUp3 extends JFrame implements ActionListener{

    JRadioButton r1,r2,r3,r4;
    JCheckBox c1,c2,c3,c4,c5,c6,c7;
    JButton submit,cancel;
    String formno;

    SignUp3(String formno){
        this.formno=formno;
        setLayout(null);
        JLabel l1=new JLabel("Page 3 : Account Details");
        l1.setFont(new Font("Raleway",Font.BOLD,22));
        l1.setBounds(280,10,400,40);
        add(l1);

        JLabel type=new JLabel("Account type:");
        type.setFont(new Font("Raleway",Font.BOLD,22));
        type.setBounds(100,80,200,30);
        add(type);

        r1=new JRadioButton("Saving Account");
        r1.setFont(new Font("Raleway",Font.BOLD,16));
        r1.setBackground(Color.white);
        r1.setBounds(350,120,250,20);
        add(r1);

        r2=new JRadioButton("Fixed Deposit Account");
        r2.setFont(new Font("Raleway",Font.BOLD,16));
        r2.setBackground(Color.white);
        r2.setBounds(100,120,250,20);
        add(r2);

        r3=new JRadioButton("Current Account");
        r3.setFont(new Font("Raleway",Font.BOLD,16));
        r3.setBackground(Color.white);
        r3.setBounds(350,160,250,20);
        add(r3);

        r4=new JRadioButton("Recurring Deposit Account");
        r4.setFont(new Font("Raleway",Font.BOLD,16));
        r4.setBackground(Color.white);
        r4.setBounds(100,160,250,20);
        add(r4);

        ButtonGroup account=new ButtonGroup();
        account.add(r1);
        account.add(r2);
        account.add(r3);
        account.add(r4);

        JLabel card=new JLabel("Card Number:");
        card.setFont(new Font("Raleway",Font.BOLD,22));
        card.setBounds(100,240,200,30);
        add(card);

        JLabel number=new JLabel("XXXX-XXXX-XXXX-1711");
        number.setFont(new Font("Raleway",Font.BOLD,22));
        number.setBounds(330,240,300,30);
        add(number);
        
        JLabel l=new JLabel("Your 16 Digit Card Number");
        l.setFont(new Font("Raleway",Font.BOLD,12));
        l.setBounds(100,260,300,20);
        add(l);

        JLabel pin=new JLabel("PIN Number:");
        pin.setFont(new Font("Raleway",Font.BOLD,22));
        pin.setBounds(100,310,200,30);
        add(pin);

        JLabel pnumber=new JLabel("XXXX");
        pnumber.setFont(new Font("Raleway",Font.BOLD,22));
        pnumber.setBounds(330,310,300,30);
        add(pnumber);

        JLabel l2=new JLabel("Your 4 Digit Pin");
        l2.setFont(new Font("Raleway",Font.BOLD,12));
        l2.setBounds(100,340,300,20);
        add(l2);

        JLabel services=new JLabel("Services required:");
        services.setFont(new Font("Raleway",Font.BOLD,22));
        services.setBounds(100,390,200,30);
        add(services);

        c1=new JCheckBox("ATM Card");
        c1.setBackground(Color.white);
        c1.setFont(new Font("Raleway",Font.BOLD,16));
        c1.setBounds(100,440,230,30);
        add(c1);

        c2=new JCheckBox("Internet Banking");
        c2.setBackground(Color.white);
        c2.setFont(new Font("Raleway",Font.BOLD,16));
        c2.setBounds(350,440,230,30);
        add(c2);

        c3=new JCheckBox("Mobile Bankin4");
        c3.setBackground(Color.white);
        c3.setFont(new Font("Raleway",Font.BOLD,16));
        c3.setBounds(100,490,230,30);
        add(c3);

        c4=new JCheckBox("Email and SMS Alerts");
        c4.setBackground(Color.white);
        c4.setFont(new Font("Raleway",Font.BOLD,16));
        c4.setBounds(350,490,230,30);
        add(c4);

        c5=new JCheckBox("Cheque Book");
        c5.setBackground(Color.white);
        c5.setFont(new Font("Raleway",Font.BOLD,16));
        c5.setBounds(100,540,230,30);
        add(c5);

        c6=new JCheckBox("E-statement");
        c6.setBackground(Color.white);
        c6.setFont(new Font("Raleway",Font.BOLD,16));
        c6.setBounds(350,440,230,30);
        add(c6);

        c7=new JCheckBox("I hereby declare that the above entered details are correct to the best of my knowledge");
        c7.setBackground(Color.white);
        c7.setFont(new Font("Raleway",Font.BOLD,12));
        c7.setBounds(100,590,600,30);
        add(c7);

        submit = new JButton("Submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.white);
        submit.setFont(new Font("Raleway",Font.BOLD,14));
        submit.setBounds(250,630,100,30);
        submit.addActionListener(this);
        add(submit);
        
        cancel = new JButton("Cancel");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.white);
        cancel.setFont(new Font("Raleway",Font.BOLD,14));
        cancel.setBounds(420,630,100,30);
        cancel.addActionListener(this);
        add(cancel);

        setSize(850,750);
        setLocation(230,20);
        getContentPane().setBackground(Color.white);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == submit){
            String accountType=null;
            if(r1.isSelected()){
                accountType="Saving account";
            }else if(r2.isSelected()){
                accountType="Fized Deposit account";
            }else if(r3.isSelected()){
                accountType="Current account";
            }else if(r4.isSelected()){
                accountType="Reccuring Deposit account";
            }
            
            Random rd= new Random();
            String cardNumber=""+Math.abs(rd.nextLong()%9000000L + 5040936000000000L);
            String pinNumber=""+Math.abs(rd.nextLong()%9000L + 1000L);
            String facility="";
            if(c1.isSelected()){
                facility+="ATM card  ";
            }
            if(c2.isSelected()){
                facility+="Internet banking  ";
            }
            if(c3.isSelected()){
                facility+="mobile banking  ";
            }
            if(c4.isSelected()){
                facility+="email and sms alerts  ";
            }
            if(c5.isSelected()){
                facility+="cheque book  ";
            }
            if(c5.isSelected()){
                facility+="e-statement  ";
            }
            try{
                if(accountType.equals(""))
                    JOptionPane.showMessageDialog(null, "Account type is required");
                else{
                    Conn c=new Conn();
                    String query1="insert into signup3 values( '"+formno+"','"+accountType+"','"+cardNumber+"','"+pinNumber+"','"+facility+"');";
                    String query2="insert into login values( '"+formno+"','"+cardNumber+"','"+pinNumber+"');";
                    c.s.executeUpdate(query1);
                    c.s.executeUpdate(query2);

                    JOptionPane.showMessageDialog(null,"Card number "+cardNumber+"\npin : "+pinNumber);
                }
            }catch(Exception ex){
                System.out.println(ex);
            }
        }else if(e.getSource() == cancel){

        }
    }
    public static void main(String args[])
    {
        new SignUp3("");
    }
}
