
package bank.mangement.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Deposit extends JFrame implements ActionListener {
    JTextField amount;
    JButton deposit,back;
    String pin;
    Deposit(String pin){
    this.pin=pin;  
    setLayout(null);
    ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/ATM.jpg"));
    Image i2=i1.getImage().getScaledInstance(800,800, Image.SCALE_DEFAULT);
    ImageIcon i3=new ImageIcon(i2);
    JLabel i4=new JLabel(i3);
    i4.setBounds(0,0,800,800);
    add(i4);
    
    JLabel text=new JLabel("Enter The Amount You Want To Deposit");
    text.setForeground(Color.black);
    text.setFont(new Font("Algerian",Font.BOLD,14));
    text.setBounds(190,300,400,20);
    i4.add(text);
    
    amount=new JTextField();
    amount.setFont(new Font("Forte",Font.BOLD,20));
    amount.setBounds(190,340,300,25);
    i4.add(amount);
    
    deposit=new JButton("Deposit");
    deposit.setBounds(340,455,150,30);
    deposit.addActionListener(this);
    i4.add(deposit);
    
    back=new JButton("Back");
    back.setBounds(185,455,150,30);
    back.addActionListener(this);
    i4.add(back);
    // its all time write at last
    setSize(800,800);
    setLocation(350,10);
    setUndecorated(true);
    setVisible(true);
    }
     public void actionPerformed(ActionEvent ae){
         if(ae.getSource()==deposit){
            String number=amount.getText();
            Date date=new Date();
            if(number.equals("")){
                JOptionPane.showMessageDialog(null,"Please enter the amount you want to deposit");
            }else{
                try{
                Conn conn=new Conn();
                String query="insert into bank values('"+pin+"','"+date+"','Deposit','"+number+"')";
                conn.s.executeUpdate(query);
                 JOptionPane.showMessageDialog(null,"RS "+number+" Successfully deposit");
                  setVisible(false);
                  new Transaction(pin).setVisible(true);
                }
                catch(Exception e){
                    System.out.println(e);
                }
            }
         }else if(ae.getSource()==back){
             setVisible(false);
             new Transaction(pin).setVisible(true);
         }
     }
    public static void main(String args[]){
        new Deposit("");
    } 
}
