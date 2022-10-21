import java.util.Date;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class FastCash extends JFrame implements ActionListener{

    JButton a1,a2,a3,a4,a5,a6,back;
    String pinNumber;

    FastCash(String pinNumber){

        this.pinNumber=pinNumber;
        setLayout(null);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900,750, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,900,750);
        add(image);

        JLabel text=new JLabel("Select withdrawal amount");
        text.setBounds(220,250,700,35);
        text.setForeground(Color.white);
        text.setFont(new Font("System",Font.BOLD,16));
        image.add(text);

        a1=new JButton("Rs. 100");
        a1.setBounds(170,342,120,25);
        a1.addActionListener(this);
        image.add(a1);

        a2=new JButton("Rs. 500");
        a2.setBounds(380,342,120,25);
        a2.addActionListener(this);
        image.add(a2);

        a3=new JButton("Rs. 1000");
        a3.setBounds(170,373,120,25);
        a3.addActionListener(this);
        image.add(a3);

        a4=new JButton("Rs. 2000");
        a4.setBounds(380,373,120,25);
        a4.addActionListener(this);
        image.add(a4);

        a5=new JButton("Rs. 5000");
        a5.setBounds(170,405,120,25);
        a5.addActionListener(this);
        image.add(a5);

        a6=new JButton("Rs. 10000");
        a6.setBounds(380,405,120,25);
        a6.addActionListener(this);
        image.add(a6);

        back=new JButton("Back");
        back.setBounds(380,434,120,25);
        back.addActionListener(this);
        image.add(back);

        setSize(900,750);
        setLocation(230,20);
        getContentPane().setBackground(Color.white);
        setUndecorated(true);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == back){
            setVisible(false);
            new Transactions(pinNumber).setVisible(true);
        }else {
            String amount=((JButton)e.getSource()).getText().substring(4);
            try{
                Conn c= new Conn();
                ResultSet rs=c.s.executeQuery("select * from bank where pin='"+pinNumber+"';");
                int balance =0;
                while(rs.next()){
                    if(rs.getString("type").equals("Deposit")){
                        balance+=Integer.parseInt(rs.getString("amount"));
                    }else{
                        balance-=Integer.parseInt(rs.getString("amount"));
                    }
                    if(e.getSource()!=back && balance>Integer.parseInt(amount)){
                        JOptionPane.showMessageDialog(null, "Insufficient balance");
                        return;
                    }
                    Date d=new Date();
                    String query="insert into bank values('"+pinNumber+"','"+d+"','Withdrawal','"+amount+"');";
                    c.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Rs."+amount+" debited successfully");
                    setVisible(false);
                    new Transactions(pinNumber).setVisible(true);
                }
            }catch(Exception e1){
                System.out.println(e1);
            }
        }
        
    }
    public static void main(String args[])
    {
        new FastCash("");
    }
}
