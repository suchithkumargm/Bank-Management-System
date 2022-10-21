import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class MiniStatement extends JFrame{
    MiniStatement(String pinNumber){

        setTitle("Mini Statement");
        setLayout(null);

        JLabel text=new JLabel();
        add(text);

        JLabel bank=new JLabel("Demo Bank");
        bank.setBounds(150,20,100,20);
        add(bank);

        JLabel card=new JLabel();
        card.setBounds(20,80,300,20);
        add(card);
        JLabel balance =new JLabel();
        balance.setBounds(20,400,300,20);
        add(balance);

        JLabel mini=new JLabel();
        mini.setBounds(20,140,400,200);
        add(mini);

        try{
            Conn c=new Conn();
            ResultSet rs=c.s.executeQuery("select * from login where pin = '"+1234+"';");
            while(rs.next()){
                card.setText("Card Number : "+rs.getString("cardnumber").substring(0,4)+"XXXXXXXX"+rs.getString("cardnumber").substring(12));
            }
        }catch(Exception e){
            System.out.println(e);
        }
        try{
            Conn c=new Conn();
            ResultSet rs=c.s.executeQuery("select * from bank where pin='"+pinNumber+"';");
            while(rs.next()){
                mini.setText(mini.getText()+"\n"+rs.getString("date")+"     "+rs.getString("type")+"     "+rs.getString("amount")+"\n");
                System.out.println(mini.getText()+"\n"+rs.getString("date")+"     "+rs.getString("type")+"     "+rs.getString("amount")+"\n");
            }
        }catch(Exception e){
            System.out.println(e);
        }

        setSize(400,600);
        setLocation(20,20);
        getContentPane().setBackground(Color.white);
        setVisible(true);
    }
    public static void main(String args[])
    {
        new MiniStatement("");
    }
}
