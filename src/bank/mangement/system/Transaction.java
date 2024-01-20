
package bank.mangement.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Transaction extends JFrame implements ActionListener{
    JButton deposit,withdrwal,fastcash,ministatement,pinchnage,balanceenquiry,exit;
    String pinnumber;
    Transaction(String pinnumber){
    this.pinnumber=pinnumber;
    //setLayout(null);
    ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/ATM.jpg"));
    Image i2=i1.getImage().getScaledInstance(800,800, Image.SCALE_DEFAULT);
    ImageIcon i3=new ImageIcon(i2);
    JLabel i4=new JLabel(i3);
    i4.setBounds(0,0,800,800);
    add(i4);
    
    JLabel text=new JLabel("Select Your Transction");
    text.setBounds(240,300,600,35);
    text.setForeground(Color.black);
    text.setFont(new Font("Algerian",Font.BOLD,14));
    i4.add(text);
    
    deposit=new JButton("Deposit");
    deposit.setBounds(185, 374, 150, 30);
    deposit.addActionListener(this);
    i4.add(deposit);
    
    withdrwal=new JButton("Withdrawal");
    withdrwal.setBounds(341, 374, 150, 30);
    withdrwal.addActionListener(this);
    i4.add(withdrwal);
    
    fastcash=new JButton("Fast Cash");
    fastcash.setBounds(185, 409, 150, 30);
    fastcash.addActionListener(this);
    i4.add(fastcash);
    
    ministatement=new JButton("Mini statement");
    ministatement.setBounds(341, 409, 150, 30);
    ministatement.addActionListener(this);
    i4.add(ministatement);
    
    pinchnage=new JButton("Pin Change");
    pinchnage.setBounds(185, 444, 150, 30);
    pinchnage.addActionListener(this);
    i4.add(pinchnage);
    
    balanceenquiry=new JButton("Balance Enquiry");
    balanceenquiry.setBounds(341, 444, 150, 30);
    balanceenquiry.addActionListener(this);
    i4.add(balanceenquiry);
    
    exit=new JButton("Exit");
    exit.setBounds(255, 480, 150, 30);
    exit.addActionListener(this);
    exit.setBackground(Color.yellow);
    i4.add(exit);
    
    setSize(800,800);
    setLocation(350,10);
    setUndecorated(true);
    setVisible(true);
    
    }
    
     public void actionPerformed(ActionEvent ae){
         if(ae.getSource()==exit){
             System.exit(0);
         }else if(ae.getSource()==deposit){
             setVisible(false);
             new Deposit(pinnumber).setVisible(true);
         } else if(ae.getSource()==withdrwal){
             setVisible(false);
             new Withdrawl(pinnumber).setVisible(true);
         } else if(ae.getSource()==fastcash){
             setVisible(false);
             new FastCash(pinnumber).setVisible(true);
         } else if(ae.getSource()==pinchnage){
             setVisible(false);
             new PinChange(pinnumber).setVisible(true);
         } else if(ae.getSource()==balanceenquiry){
             setVisible(false);
             new BalanceEnquey(pinnumber).setVisible(true);
         } else if(ae.getSource()==ministatement){
           
             new MiniStatement(pinnumber).setVisible(true);
         }
         
     }
    public static void main(String args[]){
      new  Transaction(""); 
    }
}
