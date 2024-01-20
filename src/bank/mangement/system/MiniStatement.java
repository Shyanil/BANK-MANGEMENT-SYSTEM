
package bank.mangement.system;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class MiniStatement extends JFrame {

    MiniStatement(String pinnumber){
       
     setLayout(null);
     JLabel mini=new JLabel();
     mini.setBounds(20,140,400,200);
     add(mini);
     
     JLabel bank=new JLabel("RapidTrust Bank");
     bank.setBounds(150,40,100,20);
     add(bank);
     
     JLabel balance =new JLabel();
     balance.setBounds(20,400,300,20);
     add(balance);
     
     
     JLabel card=new JLabel();
     card.setBounds(20,80,300,20);
     add(card);
        
     try{
         Conn conn=new Conn();
       ResultSet ts=  conn.s.executeQuery("select * from Login where pinnumber='"+pinnumber+"'");
       while(ts.next()){
           card.setText("Card Number is "+ts.getString("cardnumber").substring(0,4)+"XXXXXXXX"+ts.getString("cardnumber").substring(12));
       }
     } catch(Exception e){
         System.out.print(e);
     }
     
     try{
         Conn conn=new Conn();
         int bal=0;
       ResultSet ts=  conn.s.executeQuery("select * from bank where pin='"+pinnumber+"'");
       while(ts.next()){
           mini.setText(mini.getText()+"<html>"+ts.getString("date")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+ts.getString("type")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+ts.getString("amount")+"<br><br><html>");
        if(ts.getString("type").equals("Deposit")){
                       bal+=Integer.parseInt(ts.getString("amount"));
                   } else{
                       bal-=Integer.parseInt(ts.getString("amount"));
                   }
           
       }
       balance.setText(" your current bank balance is RS= "+bal);
     } catch(Exception e){
         System.out.print(e);
     }
     
      setTitle("MiniStatement");
      setSize(400,600);
      setLocation(20,20);
      setUndecorated(true);
      setVisible(true);
      
    }
   
    public static void main(String args[]){
        new MiniStatement("");
    }
}
