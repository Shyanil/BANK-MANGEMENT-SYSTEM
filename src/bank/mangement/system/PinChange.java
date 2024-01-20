
package bank.mangement.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;

public class PinChange extends JFrame implements ActionListener{
    JTextField pind,rpin;
    JButton change,back;
    String pinnumber;
    PinChange(String  pinnumber){
        this.pinnumber=pinnumber;
    ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/ATM.jpg"));
    Image i2=i1.getImage().getScaledInstance(800,800, Image.SCALE_DEFAULT);
    ImageIcon i3=new ImageIcon(i2);
    JLabel i4=new JLabel(i3);
    i4.setBounds(0,0,800,800);
    add(i4);
    
    JLabel text=new JLabel("Change your Pin");
    text.setForeground(Color.black);
    text.setBounds(250,300,600,35);
    text.setFont(new Font("Algerian",Font.BOLD,14));
    i4.add(text);
    
    JLabel pintext=new JLabel("Write Your New Pin");
    pintext.setForeground(Color.black);
    pintext.setBounds(185, 354, 150, 30);
    pintext.setFont(new Font("Algerian",Font.BOLD,14));
    i4.add(pintext);
    
    pind=new JTextField();
    pind.setBounds(185, 380, 150, 30);
    pind.setFont(new Font("Algerian",Font.BOLD,14));
    i4.add(pind);
    
    JLabel repintext=new JLabel("Write Pin Again");
    repintext.setForeground(Color.black);
    repintext.setBounds(185, 406, 150, 30);
    repintext.setFont(new Font("Algerian",Font.BOLD,14));
    i4.add(repintext);
    
    rpin=new JTextField();
    rpin.setBounds(185, 432, 150, 30);
    rpin.setFont(new Font("Algerian",Font.BOLD,14));
    i4.add(rpin);
    
    
    change=new JButton("CHANGE");
    change.setBounds(383, 380, 100, 30);
    change.addActionListener(this);
    i4.add(change);
    
    back=new JButton("BACK");
    back.setBounds(383, 432, 100, 30);
    back.addActionListener(this);
    i4.add(back);
    
    setSize(800,800);
    setLocation(300,0);
    setUndecorated(true);
    setVisible(true);
    }
        public void actionPerformed(ActionEvent ae){
            if(ae.getSource()==change){
            try{
                String npin=pind.getText();
                String repin=rpin.getText();
                
                if(npin.equals(repin)){
                    JOptionPane.showMessageDialog(null,"Entered pin doesn't match");
                    return;
                }
                if(npin.equals("")){
                    JOptionPane.showMessageDialog(null,"pin Required");
                    return;
                    
                }
                if(rpin.equals("")){
                    JOptionPane.showMessageDialog(null,"Again pin Required");
                    return;
                    
                }
                Conn conn=new Conn();
                String query="Update bank set pin '"+repin+"' where pin='"+pinnumber+"";
                 String query1="Update Login set pin '"+repin+"' where pin='"+pinnumber+"";
                  String query2="Update signupThree set pin '"+repin+"' where pin='"+pinnumber+"";
                conn.s.executeUpdate(query);
                conn.s.executeUpdate(query1);
                conn.s.executeUpdate(query2);
                
                JOptionPane.showMessageDialog(null,"Pin is successfully changed");
                setVisible(false);
                new Transaction(repin).setVisible(true);
                
            }catch(Exception e){
                System.out.println(e);
            }
        } else{
                setVisible(false);
                setVisible(false);
               new Transaction(pinnumber).setVisible(true);
            }
            
        } 
     
    public static void main(String args[]){
     new  PinChange("").setVisible(true); 
          
}
}

