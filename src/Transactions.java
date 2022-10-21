import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Transactions extends JFrame implements ActionListener{

    JButton deposit,withdrawal,miniStatement,pinChange,fastCash,balanceEnquiry,exit;
    String pinNumber;

    Transactions(String pinNumber){

        this.pinNumber=pinNumber;
        setLayout(null);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900,750, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,900,750);
        add(image);

        JLabel text=new JLabel("Please select your transaction");
        text.setBounds(220,250,700,35);
        text.setForeground(Color.white);
        text.setFont(new Font("System",Font.BOLD,16));
        image.add(text);

        deposit=new JButton("Deposit");
        deposit.setBounds(170,342,120,25);
        deposit.addActionListener(this);
        image.add(deposit);

        withdrawal=new JButton("Withdrawal");
        withdrawal.setBounds(380,342,120,25);
        withdrawal.addActionListener(this);
        image.add(withdrawal);

        fastCash=new JButton("Fast Cash");
        fastCash.setBounds(170,373,120,25);
        fastCash.addActionListener(this);
        image.add(fastCash);

        miniStatement=new JButton("Mini Statement");
        miniStatement.setBounds(380,373,120,25);
        miniStatement.addActionListener(this);
        image.add(miniStatement);

        pinChange=new JButton("Pin Change");
        pinChange.setBounds(170,405,120,25);
        pinChange.addActionListener(this);
        image.add(pinChange);

        balanceEnquiry=new JButton("Balance Enquiry");
        balanceEnquiry.setBounds(380,405,120,25);
        balanceEnquiry.addActionListener(this);
        image.add(balanceEnquiry);

        exit=new JButton("Exit");
        exit.setBounds(380,434,120,25);
        exit.addActionListener(this);
        image.add(exit);

        setSize(900,750);
        setLocation(230,20);
        getContentPane().setBackground(Color.white);
        setUndecorated(true);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == exit){
            System.exit(0);
        }else if(e.getSource()==deposit){
            setVisible(false);
            new Deposit(pinNumber).setVisible(true);
        }else if(e.getSource()==withdrawal){
            setVisible(false);
            new Withdrawal(pinNumber).setVisible(true);
        }else if(e.getSource()==fastCash){
            setVisible(false);
            new FastCash(pinNumber).setVisible(true);
        }else if(e.getSource()==pinChange){
            setVisible(false);
            new PinChange(pinNumber).setVisible(true);
        }else if(e.getSource()==balanceEnquiry){
            setVisible(false);
            new BalanceEnquiry(pinNumber).setVisible(true);
        }else if(e.getSource()==miniStatement){
            new MiniStatement(pinNumber).setVisible(true);
        }
        
    }
    public static void main(String args[])
    {
        new Transactions("");
    }
}
