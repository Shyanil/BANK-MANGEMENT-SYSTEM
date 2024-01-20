
package bank.mangement.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login  extends JFrame implements ActionListener{
    JButton login,clear,signup;
     JTextField cardTextField;
     JPasswordField pinTextField;
    
    Login(){
        setLayout(null);
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icon/bank.png"));
        Image i2=i1.getImage().getScaledInstance(64, 64, Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel lebel= new JLabel(i3);
        add(lebel);
        getContentPane().setBackground(Color.ORANGE);
        
        //text
        
        JLabel text= new JLabel("Welcome to RapidTrust's Bank ATM");
        text.setFont(new Font("Berlin Sans FB Demi",Font.BOLD,38));
        text.setBounds(120,40,700,80);
        add(text);
        
        //cardno
        
        JLabel cardno= new JLabel("CARD NO:");
        cardno.setFont(new Font("Algerian",Font.BOLD,22));
        cardno.setBounds(120,160,150,80);
        add(cardno);
        
        //cardno textfield
        
        cardTextField = new JTextField();
        cardTextField.setFont(new Font("Arial Black",Font.BOLD,14));
        cardTextField.setBounds(250,185,200,30);
        add(cardTextField);
        
        //pin
        
        JLabel pin= new JLabel("PIN:");
        pin.setFont(new Font("Algerian",Font.BOLD,22));
        pin.setBounds(120,240,150,80);
        add(pin);
        
        //pin textfield
         
        pinTextField = new JPasswordField();
        pinTextField.setFont(new Font("Arial Black",Font.BOLD,14));
        pinTextField.setBounds(250,265,200,30);
        add(pinTextField);
        
        // Buttons
        login=new JButton("SIGN IN");
        login.setFont(new Font("Bookman Old Style",Font.BOLD,10));
        login.setBounds(250,340,90,20);
        login.addActionListener(this);
        login.setBackground(Color.CYAN);
        add(login);
        
        clear=new JButton("CLEAR");
        clear.setBounds(360,340,90,19);
        clear.setFont(new Font("Bookman Old Style",Font.BOLD,10));
        clear.setBackground(Color.CYAN);
        clear.addActionListener(this);
        add(clear);
        
        signup =new JButton("SIGN UP");
        signup.setFont(new Font("Bookman Old Style",Font.BOLD,12));
        signup.setBounds(250,400,200,20);
        signup.addActionListener(this);
        add(signup);
        
        
        lebel.setBounds(40, 50, 64, 64);
        setTitle("RapidTrust ATM");
        setSize(700,600);
        setVisible(true);
        setLocation(350,200);
    }
    
 public void actionPerformed (ActionEvent ae){
     if(ae.getSource()==clear){
         cardTextField.setText("");
         pinTextField.setText("");
     }else if(ae.getSource()==login){
         Conn conn=new Conn();
         String cardno=cardTextField.getText();
         String pin=pinTextField.getText();
         String query="select * from Login where cardnumber='"+cardno+"' and pinnumber='"+pin+"'";
         try{
           ResultSet rs= conn.s.executeQuery(query);
           if(rs.next()){
               setVisible(false);
               new Transaction(pin).setVisible(true);
           }
           else{
               JOptionPane.showMessageDialog(null, "Incorrect Pin Or Card No");
           }
         }catch (Exception e){
             System.out.println(e);
         }
     }else if(ae.getSource()==signup){
         setVisible(false);
         new SignupOne().setVisible(true);
         
     }
      
  }  
    public static void main(String args[]){
         
        new Login();
    }
    
}
