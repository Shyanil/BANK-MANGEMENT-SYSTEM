
package bank.mangement.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
public class SignupThree extends JFrame implements ActionListener{
      JRadioButton r1,r2,r3,r4;
      JCheckBox c1,c2,c3,c4,c5,c6,c7;
      JButton submit,cancel;
      String formno;
    SignupThree(String formno){
        this.formno=formno;
        setLayout(null);
        setTitle("NEW ACCOUNT APPLICATION FORM--- PAGE 3");
    
        JLabel l1=new JLabel("Page 3: Account Details");
        l1.setFont(new Font("Bell MT",Font.BOLD,25));
        l1.setBounds(310,80,400,30);
        add(l1);
        
        JLabel type=new JLabel("Account Type: ");
        type.setFont(new Font("Copperplate Gothic Bold",Font.BOLD,20));
        type.setBounds(100,140,340,30);
        add(type);
        
           r1 = new JRadioButton("Saving Account");
           r1.setBounds(100, 180, 160, 30);
           r1.setFont(new Font("", Font.BOLD, 12));
           r1.setBackground(Color.WHITE);
           add(r1);

           r2 = new JRadioButton("Fixed Deposit Account");
           r2.setBounds(280, 180, 180, 30);
           r2.setFont(new Font("", Font.BOLD, 12));
           r2.setBackground(Color.WHITE);
           add(r2);
            
           r3 = new JRadioButton("Current Account");
           r3.setBounds(470, 180, 160, 30);
           r3.setFont(new Font("", Font.BOLD, 12));
           r3.setBackground(Color.WHITE);
           add(r3);
            
          r4 = new JRadioButton("Recurring Deposit Account");
          r4.setBounds(640, 180, 250, 30);
          r4.setFont(new Font("", Font.BOLD, 12));
          r4.setBackground(Color.WHITE);
          add(r4);
           
          
        JLabel card=new JLabel("Card No:");
        card.setFont(new Font("Copperplate Gothic Bold",Font.BOLD,20));
        card.setBounds(100,240,400,30);
        add(card);   
        
        
        JLabel number=new JLabel("XXXX-XXXX-XXXX-4567");
        number.setFont(new Font("Copperplate Gothic Bold",Font.BOLD,14));
        number.setBounds(330,240,400,30);
        add(number);
        
        JLabel carddetail=new JLabel("Your 16 Digit Card No");
        carddetail.setFont(new Font("Copperplate Gothic Bold",Font.BOLD,10));
        carddetail.setBounds(100,270,400,20);
        add(carddetail); 
        
        JLabel pin=new JLabel("PIN:");
        pin.setFont(new Font("Copperplate Gothic Bold",Font.BOLD,20));
        pin.setBounds(100,310,400,30);
        add(pin);
        
        JLabel pnumber=new JLabel("XXXX");
        pnumber.setFont(new Font("Copperplate Gothic Bold",Font.BOLD,14));
        pnumber.setBounds(330,310,400,30);
        add(pnumber);
        
        JLabel pindetail=new JLabel("Your 4 Digit Pin No");
        pindetail.setFont(new Font("Copperplate Gothic Bold",Font.BOLD,10));
        pindetail.setBounds(100,340,400,20);
        add(pindetail); 
        
        JLabel Servics=new JLabel("Services Required");
        Servics.setFont(new Font("Copperplate Gothic Bold",Font.BOLD,20));
        Servics.setBounds(100,370,400,30);
        add(Servics);
        
        
        c1=new JCheckBox("ATM CARD");
        c1.setBackground(Color.white);
        c1.setFont(new Font("Calibri Light (Headings)",Font.BOLD,15));
        c1.setBounds(100, 410, 200, 30);
        add(c1);
        
        c2=new JCheckBox("Internet Banking");
        c2.setBackground(Color.white);
        c2.setFont(new Font("Calibri Light (Headings)",Font.BOLD,15));
        c2.setBounds(350, 410, 200, 30);
        add(c2);
        
        c3=new JCheckBox("Mobile Banking");
        c3.setBackground(Color.white);
        c3.setFont(new Font("Calibri Light (Headings)",Font.BOLD,15));
        c3.setBounds(100, 460, 200, 30);
        add(c3);
        
        c4=new JCheckBox("Email & Sms Alerts");
        c4.setBackground(Color.white);
        c4.setFont(new Font("Calibri Light (Headings)",Font.BOLD,15));
        c4.setBounds(350, 460, 200, 30);
        add(c4);
        
        c5=new JCheckBox("Cheque Book");
        c5.setBackground(Color.white);
        c5.setFont(new Font("Calibri Light (Headings)",Font.BOLD,15));
        c5.setBounds(100, 510, 200, 30);
        add(c5);
        
        c6=new JCheckBox("E-Statement");
        c6.setBackground(Color.white);
        c6.setFont(new Font("Calibri Light (Headings)",Font.BOLD,15));
        c6.setBounds(350, 510, 200, 30);
        add(c6);
        
        c7=new JCheckBox("I hereby declare that the above made statements are true to the best of my knowledge and belief");
        c7.setBackground(Color.white);
        c7.setFont(new Font("Calibri Light (Headings)",Font.BOLD,12));
        c7.setBounds(100, 590, 600, 30);
        add(c7);
        
        submit=new JButton("Submit");
        submit.setBackground(Color.green);
        submit.setForeground(Color.white);
        submit.setBounds(220,680,100,30);
        submit.addActionListener(this);
        add(submit);
        
        cancel=new JButton("Cancel");
        cancel.setBackground(Color.yellow);
        cancel.setForeground(Color.white);
        cancel.setBounds(420,680,100,30);
        cancel.addActionListener(this);
        add(cancel);
        
        
        
          
        ButtonGroup groupAccount=new ButtonGroup();
        groupAccount.add(r1);
        groupAccount.add(r2);
        groupAccount.add(r3);
        groupAccount.add(r4);


        
        getContentPane().setBackground(Color.WHITE);
        setSize(850,800);
        setLocation(350,10);
        setVisible(true);
        
    }
    
    
     public void actionPerformed(ActionEvent ae){
         if(ae.getSource()==submit){
            String  accountType=null; 
            if(r1.isSelected()){
                accountType="Saving Account";
            }else if(r2.isSelected()){
                accountType="Fixed Deposit Account";
            }else if(r3.isSelected()){
                accountType="Current Account";
            } else if(r4.isSelected()){
                accountType="Recurring Deposit Account";
            }
            Random random=new Random();
            String cardnumber = "";
            for (int i = 0; i < 16; i++) {
            cardnumber += random.nextInt(10);}
            
            String pinnumber = "";
            for (int i = 0; i < 4; i++) {
            pinnumber += random.nextInt(10); }


           
           String facility="";
           if(c1.isSelected()){
               facility=facility+"ATM CARD";
           }else if(c2.isSelected()){
               facility=facility+"Internet Banking";
           }else if(c3.isSelected()){
               facility=facility+"Mobile Banking";
           }else if(c4.isSelected()){
               facility=facility+"Email & Sms Alerts";
           }else if(c5.isSelected()){
               facility=facility+"Cheque Book";
           }else if(c6.isSelected()){
               facility=facility+"E-Statement";
           }
           
           try{
               if(accountType.equals("")){
                 JOptionPane.showMessageDialog(null,"Account type is Required");
               } else{
               Conn conn= new Conn();
               String query="insert into signupThree values('"+formno+"','"+accountType+"','"+cardnumber+"','"+pinnumber+"','"+facility+"')";
               String query1="insert into Login values('"+formno+"','"+cardnumber+"','"+pinnumber+"')";
               conn.s.executeUpdate(query);
               conn.s.executeUpdate(query1);
               JOptionPane.showMessageDialog(null,"Card No: "+cardnumber+"\n Pin: "+pinnumber);
               setVisible(false);
               new Transaction(pinnumber).setVisible(true);
               }
           }catch(Exception e){
               System.out.println(e);
           }
           
          } else if (ae.getSource()== cancel){
               setVisible(false);
               new Login().setVisible(true); 
     } 
         
     }
    public static void main(String args[]){
        new SignupThree("");
    }
}
