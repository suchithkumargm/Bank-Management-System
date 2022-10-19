import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Date;

public class Withdrawal extends JFrame implements ActionListener{

    String pinNumber;
    JButton withdraw,back;
    JTextField amount;

    Withdrawal(String pinNumber){
        this.pinNumber=pinNumber;
        setLayout(null);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900,750, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,900,750);
        add(image);

        JLabel text=new JLabel("Enter the amount you want to withdraw");
        text.setBounds(220,250,400,35);
        text.setForeground(Color.white);
        text.setFont(new Font("System",Font.BOLD,16));
        image.add(text);

        amount=new JTextField();
        amount.setFont(new Font("Raleway",Font.BOLD,22));
        amount.setBounds(170,315,320,25);
        image.add(amount);

        withdraw=new JButton("Withdraw");
        withdraw.setBounds(355,380,150,30);
        withdraw.addActionListener(this);
        image.add(withdraw);

        back=new JButton("Back");
        back.setBounds(355,415,150,30);
        back.addActionListener(this);
        image.add(back);

        setSize(900,750);
        setLocation(230,20);
        getContentPane().setBackground(Color.white);
        setUndecorated(true);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==withdraw){
            String number=amount.getText();
            Date d=new Date();
            String date=d.toString();
            if(number.equals("")){
                JOptionPane.showMessageDialog(null, "Enter valid amount");
            }else{
                try {
                    Conn c=new Conn();
                    String query="insert into bank values('"+pinNumber+"','"+date+"','Withdraw','"+number+"');";
                    c.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Rs. "+number+" withdrawn successfully");
                    setVisible(false);
                    new Transactions(pinNumber).setVisible(true);
                } catch (Exception e1) {
                    System.out.println(e);
                }
                
            }
        }else if(e.getSource()==back) {
            setVisible(false);
            new Transactions(pinNumber).setVisible(true);
        }
        
    }
    public static void main(String args[])
    {
      new Deposit("");  
    }
  
}
