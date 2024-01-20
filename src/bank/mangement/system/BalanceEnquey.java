
package bank.mangement.system;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.sql.*;
public class BalanceEnquey extends JFrame implements ActionListener{
     JButton  back;
     String pinnumber;
    BalanceEnquey(String pinnumber){
        this.pinnumber=pinnumber;
    ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/ATM.jpg"));
    Image i2=i1.getImage().getScaledInstance(800,800, Image.SCALE_DEFAULT);
    ImageIcon i3=new ImageIcon(i2);
    JLabel i4=new JLabel(i3);
    i4.setBounds(0,0,800,800);
    add(i4);
    
    back=new JButton("Back");
    back.setBounds(330,460,150,35);
    back.setFont(new Font("",Font.BOLD,14));
    back.addActionListener(this);
    i4.add(back);
    
     Conn c=new Conn();
     int balance=0;
             try{
                 
               ResultSet rs=c.s.executeQuery("Select * from bank where pin='"+pinnumber+"'");
               
               while(rs.next()){
                   if(rs.getString("type").equals("Deposit")){
                       balance+=Integer.parseInt(rs.getString("amount"));
                   } else{
                       balance-=Integer.parseInt(rs.getString("amount"));
                   }
               }
             } catch(Exception e){
                 System.out.print(e);
             }
             
     JLabel text=new JLabel("Your Account balance is "+ balance);
    text.setBounds(200,300,600,35);
    text.setForeground(Color.black);
    text.setFont(new Font("Algerian",Font.BOLD,12));
    i4.add(text);
    
    setSize(800,800);
    setLocation(300,0);
    setUndecorated(true);
    setVisible(true);
    
}
     public void actionPerformed(ActionEvent ae){
    setVisible(false);
    new Transaction(pinnumber).setVisible(true);
    }
   public static void main(String args[]){
       new BalanceEnquey("");
   } 
}
