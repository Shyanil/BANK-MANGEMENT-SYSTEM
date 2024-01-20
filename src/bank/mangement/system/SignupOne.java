
package bank.mangement.system;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;

public class SignupOne extends JFrame implements ActionListener{
    
    long random;
    JTextField nameTextField,fnameTextField,emailTextField,addressTextField,cityTextField,stateTextField,pincodeTextField;
    JButton next;
    JRadioButton male,female,married,unmarried,other;
    JDateChooser datechooser;
    
    SignupOne(){
    setLayout(null);
    //Random no
    Random ran=new Random();
    random=Math.abs(ran.nextLong() % 9000L)+ 1000L;
    // fromno
    JLabel formno= new JLabel("APPLICATION FORM NO. "+random);
    formno.setFont(new Font("Engravers MT",Font.BOLD,20));
    formno.setBounds(215,20,600,40);
    add(formno);
    
    //persondetails
    JLabel persondetails=new JLabel("Page 1: person details ");
    persondetails.setFont(new Font("Bell MT",Font.BOLD,22));
    persondetails.setBounds(310,80,400,30);
    add(persondetails);
    
    //name
    JLabel name=new JLabel("Name: ");
    name.setBounds(100,140,100,30);
    name.setFont(new Font("Bookman Old Style",Font.BOLD,18));
    add(name);
    
    nameTextField=new JTextField();
    nameTextField.setFont(new Font("Bookman Old Style",Font.BOLD,14));
    nameTextField.setBounds(300,140,400,30);
    add(nameTextField);
    
    //fname
    JLabel fname=new JLabel("Fathers Name: ");
    fname.setFont(new Font("Bookman Old Style",Font.BOLD,18));
    fname.setBounds(100,190,200,30);
    add(fname);
    
    fnameTextField=new JTextField();
    fnameTextField.setFont(new Font("Bookman Old Style",Font.BOLD,14));
    fnameTextField.setBounds(300,190,400,30);
    add(fnameTextField);
    
    
    //dob
    JLabel dob=new JLabel("Date of Birth: ");
    dob.setFont(new Font("Bookman Old Style",Font.BOLD,18));
    dob.setBounds(100,240,200,30);
    add(dob);
    
    datechooser=new JDateChooser();
    datechooser.setBounds(300, 240, 400, 30);
    add(datechooser);
    
    //gender
    JLabel gender=new JLabel("Gender: ");
    gender.setFont(new Font("Bookman Old Style",Font.BOLD,18));
    gender.setBounds(100,290,200,30);
    add(gender);
    
    male=new JRadioButton("Male ");
    male.setBounds(300,290,60,40);
    male.setBackground(Color.WHITE);
    add(male);
    
    female=new JRadioButton("Female ");
    female.setBounds(450,290,75,40);
    female.setBackground(Color.WHITE);
    add(female);
    
    //for gorup
    
    ButtonGroup genderGroup=new ButtonGroup();
    genderGroup.add(male);
    genderGroup.add(female);

    
    //email
    JLabel email=new JLabel("Email Address: ");
    email.setFont(new Font("Bookman Old Style",Font.BOLD,18));
    email.setBounds(100,340,200,30);
    add(email);
    
    emailTextField=new JTextField();
    emailTextField.setFont(new Font("Bookman Old Style",Font.BOLD,14));
    emailTextField.setBounds(300,340,400,30);
    add(emailTextField);
    
    //maraital
    JLabel maratial= new JLabel("Marital status: ");
    maratial.setFont(new Font("Bookman Old Style",Font.BOLD,18));
    maratial.setBounds(100,390,200,30);
    add(maratial);
    
    married=new JRadioButton("Married ");
    married.setBounds(300,390,100,40);
    married.setBackground(Color.WHITE);
    add(married);
    
    unmarried=new JRadioButton("Unmarried ");
    unmarried.setBounds(450,390,100,40);
    unmarried.setBackground(Color.WHITE);
    add(unmarried);
    
    
    other=new JRadioButton("Other ");
    other.setBounds(630,390,100,40);
    other.setBackground(Color.WHITE);
    add(other);
    
    ButtonGroup maratialGroup=new ButtonGroup();
    maratialGroup.add(married);
    maratialGroup.add(unmarried);
    maratialGroup.add(other);
    
    
    //address
    JLabel address=new JLabel("Address: ");
    address.setFont(new Font("Bookman Old Style",Font.BOLD,18));
    address.setBounds(100,440,200,30);
    add(address);
    
    addressTextField=new JTextField();
    addressTextField.setFont(new Font("Bookman Old Style",Font.BOLD,14));
    addressTextField.setBounds(300,440,400,30);
    add(addressTextField);

    //city
    JLabel city = new JLabel("City: ");
    city.setFont(new Font("Bookman Old Style",Font.BOLD,18));
    city.setBounds(100, 490, 200, 30);
    add(city);
    
    cityTextField=new JTextField();
    cityTextField.setFont(new Font("Bookman Old Style",Font.BOLD,14));
    cityTextField.setBounds(300,490,400,30);
    add(cityTextField);
    
    //state
    JLabel state = new JLabel("State: ");
    state.setFont(new Font("Bookman Old Style",Font.BOLD,18));
    state.setBounds(100, 540, 200, 30);
    add(state);
    
    stateTextField=new JTextField();
    stateTextField.setFont(new Font("Bookman Old Style",Font.BOLD,14));
    stateTextField.setBounds(300,540,400,30);
    add(stateTextField);
    
    //pincode
    JLabel pincode = new JLabel("Pin code: ");
    pincode.setFont(new Font("Bookman Old Style",Font.BOLD,18));
    pincode.setBounds(100, 590, 200, 30);
    add(pincode);
    
    pincodeTextField=new JTextField();
    pincodeTextField.setFont(new Font("Bookman Old Style",Font.BOLD,14));
    pincodeTextField.setBounds(300,590,400,30);
    add(pincodeTextField);
    
    //next page
    next=new JButton("Next");
    next.setBounds(620,660,80,30);
    next.setBackground(Color.BLACK);
    next.setForeground(Color.WHITE);
    next.setFont(new Font("Bookman Old Style",Font.BOLD,18));
    next.addActionListener(this);
    add(next);
    
    
    getContentPane().setBackground(Color.WHITE);
    setSize(850,800);
    setLocation(350,10);
    setVisible(true);
    
}
     public void actionPerformed(ActionEvent e) {
       String formno=" "+random;
       String name=nameTextField.getText();
       String fname=fnameTextField.getText();
       String dob =((JTextField) datechooser.getDateEditor().getUiComponent()).getText();
       String gender=null;
       if(male.isSelected()){
           gender="Male";
       }else if(female.isSelected()){
          gender="Female"; 
       }
       String email=emailTextField.getText();
       String maratial=null;
       if(married.isSelected()){
          maratial="Married";
       }else if(unmarried.isSelected()){
          maratial="Unmarried";
       } else if(other.isSelected()){
           maratial="Other";
       }
       String address=addressTextField.getText();
       String city=cityTextField.getText();
       String state=stateTextField.getText();
       String pincode=pincodeTextField.getText();
       
       try{
           if(name.equals("")){
               JOptionPane.showMessageDialog(null, "Write Your Name");
           }else{
               Conn c= new Conn();
               String query="insert into signup values('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+maratial+"','"+address+"','"+city+"','"+state+"','"+pincode+"')";
               c.s.executeUpdate(query);
           }
           setVisible(false);
           new SignupTwo(formno).setVisible(true);
           
       }catch(Exception es){
           System.out.println(es);
       }
       
    }
    public static void main(String args[]){
        new SignupOne();
    }

    
   
    
}
