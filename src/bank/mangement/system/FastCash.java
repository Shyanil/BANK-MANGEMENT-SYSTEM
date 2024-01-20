
package bank.mangement.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener{
    JButton rs1,rs2,rs3,rs4,rs5,rs6,back;
    String pin;
    FastCash(String pin){
    this.pin=pin;
    //setLayout(null);
    ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/ATM.jpg"));
    Image i2=i1.getImage().getScaledInstance(800,800, Image.SCALE_DEFAULT);
    ImageIcon i3=new ImageIcon(i2);
    JLabel i4=new JLabel(i3);
    i4.setBounds(0,0,800,800);
    add(i4);
    
    JLabel text=new JLabel("Fash Cash: Select Withdraw Amount");
    text.setBounds(200,300,600,35);
    text.setForeground(Color.black);
    text.setFont(new Font("Algerian",Font.BOLD,14));
    i4.add(text);
    
    rs1=new JButton("Rs 100");
    rs1.setBounds(185, 374, 150, 30);
    rs1.addActionListener(this);
    i4.add(rs1);
    
    rs2=new JButton("Rs 500");
    rs2.setBounds(341, 374, 150, 30);
    rs2.addActionListener(this);
    i4.add(rs2);
    
    rs3=new JButton("Rs 1000");
    rs3.setBounds(185, 409, 150, 30);
    rs3.addActionListener(this);
    i4.add(rs3);
    
    rs4=new JButton("Rs 2000");
    rs4.setBounds(341, 409, 150, 30);
    rs4.addActionListener(this);
    i4.add(rs4);
    
    rs5=new JButton("Rs 5000");
    rs5.setBounds(185, 444, 150, 30);
    rs5.addActionListener(this);
    i4.add(rs5);
    
    rs6=new JButton("Rs 10000");
    rs6.setBounds(341, 444, 150, 30);
    rs6.addActionListener(this);
    i4.add(rs6);
    
    back=new JButton("Back");
    back.setBounds(255, 480, 150, 30);
    back.addActionListener(this);
    back.setBackground(Color.yellow);
    i4.add(back);
    
    setSize(800,800);
    setLocation(350,10);
    setUndecorated(true);
    setVisible(true);
    
    }
    
     public void actionPerformed(ActionEvent ae){
         if(ae.getSource()==back){
             setVisible(false);
             new Transaction(pin).setVisible(true);
         }else {
             String amount=((JButton)ae.getSource()).getText().substring(3); //means RS 500 R(index)1 ...
             Conn c=new Conn();
             try{
                 
               ResultSet rs=c.s.executeQuery("Select * from bank where pin='"+pin+"'");
               int balance=0;
               while(rs.next()){
                   if(rs.getString("type").equals("Deposit")){
                       balance+=Integer.parseInt(rs.getString("amount"));
                   } else{
                       balance-=Integer.parseInt(rs.getString("amount"));
                   }
               }
               if(ae.getSource()!=back && balance<Integer.parseInt(amount)){
                   JOptionPane.showMessageDialog(null,"Insufficient Funds");
                   return;
               }
               Date date=new Date();
               String query="Insert into bank values('"+pin+"','"+date+"','Withdrawl','"+amount+"')";
               c.s.executeUpdate(query);
               JOptionPane.showMessageDialog(null,"Rs"+amount+"successfully debited");
               
               setVisible(false);
               new Transaction(pin).setVisible(true);
               
             }catch(Exception e) {
                 System.out.println(e);
             }
         }
         
     }
    public static void main(String args[]){
      new  FastCash(""); 
    }
}
