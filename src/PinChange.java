import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PinChange extends JFrame implements ActionListener{
    String pinNumber;
    JButton change,back;
    JPasswordField pin,rePin;

    PinChange(String pinNumber){
        this.pinNumber=pinNumber;
        setLayout(null);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900,750, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,900,750);
        add(image);

        JLabel text=new JLabel("Change your pin");
        text.setBounds(270,250,700,35);
        text.setForeground(Color.white);
        text.setFont(new Font("System",Font.BOLD,16));
        image.add(text);

        JLabel pinText=new JLabel("New Pin");
        pinText.setForeground(Color.white);
        pinText.setBounds(165,300,180,25);
        pinText.setFont(new Font("System",Font.BOLD,16));
        image.add(pinText);
        
        pin=new JPasswordField();
        pin.setFont(new Font("System",Font.BOLD,16));
        pin.setBounds(355,300,150,30);
        image.add(pin);
        
        JLabel rePinText=new JLabel("Re-enter Pin");
        rePinText.setForeground(Color.white);
        rePinText.setBounds(165,340,150,25);
        rePinText.setFont(new Font("System",Font.BOLD,16));
        image.add(rePinText);

        rePin=new JPasswordField();
        rePin.setFont(new Font("System",Font.BOLD,16));
        rePin.setBounds(355,340,150,30);
        image.add(rePin);

        change=new JButton("Change");
        change.setBounds(355,380,150,30);
        change.addActionListener(this);
        image.add(change);

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
        if(e.getSource()==change){
            String npin=pin.getText();
            String rpin=rePin.getText();
            if(!npin.equals(rpin)){
                JOptionPane.showMessageDialog(null, "Entered pin does not match");
                return;
            }
            if(npin.equals("")){
                JOptionPane.showMessageDialog(null, "Please enter new pin");
            }else if(rpin.equals("")){
                JOptionPane.showMessageDialog(null, "Please re-enter new pin");
            }else{
                try{
                    Conn c=new Conn();
                    String query1="update bank set pin='"+rpin+"' where pin='"+pinNumber+"';";
                    String query2="update signup3 set pin='"+rpin+"' where pin='"+pinNumber+"';";
                    String query3="update login set pin='"+rpin+"' where pin='"+pinNumber+"';";
                    
                    c.s.executeUpdate(query1);
                    c.s.executeUpdate(query2);
                    c.s.executeUpdate(query3);

                    JOptionPane.showMessageDialog(null, "Pin changed successfully");
                    setVisible(false);

                    new Transactions(rpin).setVisible(true);
                }catch(Exception e1){
                    System.out.println(e1);
                }
            }
        }else{
            setVisible(false);
            new Transactions(pinNumber).setVisible(true);
        }
    } 
    public static void main(String args[])
    {
        new PinChange("");
    }
   
}
