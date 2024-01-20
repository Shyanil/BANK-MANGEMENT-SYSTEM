
package bank.mangement.system;
import javax.swing.*;
import java.awt.*;

import java.awt.event.*;

public class SignupTwo extends JFrame implements ActionListener{
    
   
    JTextField pan,aadhar;
    JButton next;
    JRadioButton syes,sno,eyes,eno;
    
    JComboBox religion,income,education,occupation;
    Choice category;
    String formno;
    
    SignupTwo(String formno){
        this.formno=formno;
    setLayout(null);
    setTitle("NEW ACCOUNT APPLICATION FORM--- PAGE 2");
    
    
    
    //additionaldetails
    JLabel additionaldetails=new JLabel("Page 2: Additional Details");
    additionaldetails.setFont(new Font("Bell MT",Font.BOLD,22));
    additionaldetails.setBounds(310,80,400,30);
    add(additionaldetails);
    
    //Religion
    JLabel religions=new JLabel("Religion: ");
    religions.setBounds(100,140,100,30);
    religions.setFont(new Font("Bookman Old Style",Font.BOLD,18));
    add(religions);
    
    
    String valReligion[]={"Hinduism","Islam","Christianity","Sikhism","Buddhism","Other"};
    religion=new JComboBox(valReligion);
    religion.setBounds(300,140,400,30);
    religion.setBackground(Color.yellow);
    add(religion);
    
    //Category
   
    JLabel categorys=new JLabel("Category: ");
    categorys.setFont(new Font("Bookman Old Style",Font.BOLD,18));
    categorys.setBounds(100,190,200,30);
    add(categorys);
    
    category = new Choice();
    category.setBounds(300, 190, 400, 30);
    category.add("General");
    category.add("OBC");
    category.add("SC");
    category.add("ST");
    category.add("Other");
    category.setFont(new Font("Bookman Old Style",Font.BOLD,12));
    category.setBackground(Color.yellow);
    add(category);
    
    //Income
    JLabel incomes=new JLabel("Income: ");
    incomes.setFont(new Font("Bookman Old Style",Font.BOLD,18));
    incomes.setBounds(100,240,200,30);
    add(incomes);
    
    String incomecategory[]={"Null","<1,50,000","<2,50,000","<4,50,000","<5,50,000","Upto 10,00,000"};
    income=new JComboBox(incomecategory);
    income.setBounds(300,240,400,30);
    income.setBackground(Color.yellow);
    add(income);
    
    //Educational
    JLabel educational=new JLabel("Educational");
    educational.setFont(new Font("Bookman Old Style",Font.BOLD,18));
    educational.setBounds(100,290,200,30);
    add(educational);
    
    //Qualification
    JLabel qualification=new JLabel("Qualification: ");
    qualification.setFont(new Font("Bookman Old Style",Font.BOLD,18));
    qualification.setBounds(100,315,200,30);
    add(qualification);
    
     
    String educationvalues[]={"Non-Graduation","Graduate","Post-Graduation","Doctrate","Others"};
    education=new JComboBox(educationvalues);
    education.setBounds(300,315,400,30);
    education.setBackground(Color.yellow);
    add(education);
    
    
    //Occupation
    JLabel occupations= new JLabel("Occupation");
    occupations.setFont(new Font("Bookman Old Style",Font.BOLD,18));
    occupations.setBounds(100,390,200,30);
    add(occupations);
    
    String occupationValues[]={"Salaried","Self-Employed","Bussiness","Student","Retired","Others"};
    occupation=new JComboBox(occupationValues);
    occupation.setBounds(300,390,400,30);
    occupation.setBackground(Color.yellow);
    add(occupation);
    
    //pannumber
    JLabel pann=new JLabel("PAN Number: ");
    pann.setFont(new Font("Bookman Old Style",Font.BOLD,18));
    pann.setBounds(100,440,200,30);
    add(pann);
    
    pan=new JTextField();
    pan.setFont(new Font("Bookman Old Style",Font.BOLD,14));
    pan.setBounds(300,440,400,30);
    add(pan);

    //Aadhar
    JLabel aadharn = new JLabel("Aadhar Number: ");
    aadharn.setFont(new Font("Bookman Old Style",Font.BOLD,18));
    aadharn.setBounds(100, 490, 200, 30);
    add(aadharn);
    
    aadhar=new JTextField();
    aadhar.setFont(new Font("Bookman Old Style",Font.BOLD,14));
    aadhar.setBounds(300,490,400,30);
    add(aadhar);
    
    //Seniorcitizen
    JLabel sc = new JLabel("Senior Citizen: ");
    sc.setFont(new Font("Bookman Old Style",Font.BOLD,18));
    sc.setBounds(100, 540, 200, 30);
    add(sc);
    
    syes=new JRadioButton("Yes");
    syes.setBounds(300,537,100,40);
    syes.setBackground(Color.WHITE);
    add(syes);
    
    sno=new JRadioButton("No ");
    sno.setBounds(450,537,100,40);
    sno.setBackground(Color.WHITE);
    add(sno);
    
    
    ButtonGroup maratialGroup=new ButtonGroup();
    maratialGroup.add(syes);
    maratialGroup.add(sno);
    
    //ExisitingAccount
    JLabel exisitingaccount = new JLabel("Exisiting Account: ");
    exisitingaccount.setFont(new Font("Bookman Old Style",Font.BOLD,18));
    exisitingaccount.setBounds(100, 590, 200, 30);
    add(exisitingaccount);
    
    eyes=new JRadioButton("Yes");
    eyes.setBounds(300,587,100,40);
    eyes.setBackground(Color.WHITE);
    add(eyes);
    
    eno=new JRadioButton("No ");
    eno.setBounds(450,587,100,40);
    eno.setBackground(Color.WHITE);
    add(eno);
    
    
    ButtonGroup Aexisitingaccount=new ButtonGroup();
    Aexisitingaccount.add(eyes);
    Aexisitingaccount.add(eno);
    
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
       String sreligion=(String)religion.getSelectedItem();
       String scategory=(String)category.getSelectedItem();
       String sincome =(String)income.getSelectedItem();
       String seducation =(String)education.getSelectedItem();
       String soccupation =(String)occupation.getSelectedItem();
       
       String sc=null;
       if(syes.isSelected()){
           sc="Yes";
       }else if(sno.isSelected()){
          sc="No"; 
       }
      
       
       String exisitingaccount=null;
       if(eyes.isSelected()){
          exisitingaccount="Yes";
       }else if(eno.isSelected()){
          exisitingaccount="No";
       } 
       
       String span=pan.getText();
       String saadhar=aadhar.getText();
       
       
       
       try{
               Conn c= new Conn();
               String query="insert into signupTwo values('"+formno+"','"+sreligion+"','"+scategory+"','"+sincome+"','"+seducation+"','"+soccupation+"','"+sc+"','"+exisitingaccount+"','"+span+"','"+saadhar+"')";
               c.s.executeUpdate(query);
               setVisible(false);
               new SignupThree(formno).setVisible(true);
               
       }       
               //signupThree object
              catch(Exception es){
               System.out.println(es);
       }
       
    }
    public static void main(String args[]){
        new SignupTwo("");
    }

    
   
    
}
