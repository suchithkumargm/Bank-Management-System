import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class BalanceEnquiry extends JFrame implements ActionListener{
    JButton back;
    String pinNumber;

    BalanceEnquiry(String pinNumber){
        this.pinNumber=pinNumber;
        setLayout(null);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900,750, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,900,750);
        add(image);

        back=new JButton("Back");
        back.setBounds(355,415,150,30);
        back.addActionListener(this);
        image.add(back);
        
        int balance =0;
        try{
            Conn c= new Conn();
            ResultSet rs=c.s.executeQuery("select * from bank where pin='"+pinNumber+"';");
            while(rs.next()){
                if(rs.getString("type").equals("Deposit")){
                    balance+=Integer.parseInt(rs.getString("amount"));
                }else{
                    balance-=Integer.parseInt(rs.getString("amount"));
                }
            }
        }catch(Exception e1){
            System.out.println(e1);
        }
        JLabel text=new JLabel("Your current account balance is Rs. "+balance);
        text.setForeground(Color.WHITE);
        text.setBounds(170,300,400,30);
        image.add(text);
        
        setSize(900,750);
        setLocation(230,20);
        getContentPane().setBackground(Color.white);
        setUndecorated(true);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
        new Transactions(pinNumber).setVisible(true);
    }
    public static void main(String args[])
    {
        new BalanceEnquiry("");
    }

}
