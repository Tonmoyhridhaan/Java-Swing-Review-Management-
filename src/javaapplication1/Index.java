
package javaapplication1;

import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;

class Init extends JFrame{
    ImageIcon icon;
    Container c;
    JLabel userLabel,passLabel,imgLabel,type,title;
    Font f,f2,f3;
    JTextField tf1,tf2;
    JPasswordField jp1;
    JButton btn1,btn2,btn3;
    Cursor cursor;
    JRadioButton admin,user,tech;
    ButtonGroup grp;
    private String end = "admin";
    String getEnd(){
        return end;
    }
    void initComponents(int a,int b,int c,int d){
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.setSize(900,600);
        //frame.setLocationRelativeTo(null);

        /*frame.setLocation(200,50);*/
        this.setBounds(a,b,c,d);
        this.setTitle("Frame demo");
        this.setResizable(false);
    }
    void initComponents(){
        
       //content----------------------------------------
       c = this.getContentPane(); 
       c.setLayout(null);
       c.setBackground(Color.GRAY);
       
       //font--------------------------------------------
       f = new Font("Arial",Font.BOLD,14);
       f2 = new Font("Times New Roman",Font.BOLD,14);
       f3 = new Font("Times New Roman",Font.BOLD,22);
       
       //icon---------------------------------------------
       icon = new ImageIcon(getClass().getResource("user1.png"));
       this.setIconImage(icon.getImage());
       
       //image-------------------------------------------
       imgLabel = new JLabel(icon);
       imgLabel.setBounds(370,50,150,150);
       c.add(imgLabel);
       //radio button gropu-----------------------------
       grp = new ButtonGroup();
       
       
       //radio button-----------------------------------
       admin = new JRadioButton("Admin");
       admin.setBounds(280,220,80,50);
       admin.setFont(f);
       admin.setForeground(Color.WHITE);
       admin.setBackground(Color.GRAY);
       admin.setSelected(true);
       c.add(admin);
       
       
       user = new JRadioButton("User");
       user.setBounds(370,220,80,50);
       user.setFont(f);
       user.setForeground(Color.WHITE);
       user.setBackground(Color.GRAY);
       c.add(user);
       
       tech = new JRadioButton("Technician");
       tech.setBounds(450,220,150,50);
       tech.setFont(f);
       tech.setForeground(Color.WHITE);
       tech.setBackground(Color.GRAY);
       c.add(tech);
       
       grp.add(admin);
       grp.add(user);
       grp.add(tech);
       
       //jlabel------------------------------------------
       title = new JLabel();
       title.setText("Login Form");
       title.setBounds(390,180,150,50);
       title.setFont(f3);
       title.setForeground(Color.WHITE);
       c.add(title);
       
       
       type = new JLabel();
       type.setText("Login as: ");
       type.setBounds(200,220,100,50);
       type.setFont(f);
       type.setForeground(Color.WHITE);
       c.add(type);
       
       userLabel = new JLabel();
       userLabel.setText("Enter your username: ");
       userLabel.setBounds(200,270,200,50);
       userLabel.setFont(f);
       userLabel.setForeground(Color.WHITE);
       c.add(userLabel);
       passLabel = new JLabel();
       passLabel.setText("Enter your Password: ");
       passLabel.setBounds(200,320,200,50);
       passLabel.setFont(f);
       passLabel.setForeground(Color.WHITE);
       c.add(passLabel);
       
       
       //JTextField---------------------------------------
       tf1 = new JTextField();
       tf1.setBounds(360,280,200,30);
       tf1.setFont(f2);
       c.add(tf1);
       tf2 = new JPasswordField();
       tf2.setBounds(360,330,200,30);
       tf2.setFont(f2);
       c.add(tf2);

    }
}

public class Index extends Init{

    Index(){
       super.initComponents();
       initComponents(500,250,900,600);
       initComponents();

    }
    void initComponents(){
        //Handler Class-------------------------------------
       Handler handler = new Handler();
       //Handler2 handler2 = new Handler2();
       tf1.addActionListener(handler);
       tf2.addActionListener(handler);
       
       //Cursor--------------------------------------------
       cursor = new Cursor(Cursor.HAND_CURSOR);
       
       //Button--------------------------------------------
       btn1 = new JButton("Login");
       btn1.setCursor(cursor);
       btn1.setBounds(300,420,100,50);
       c.add(btn1);
       btn2 = new JButton("Clear");
       btn2.setCursor(cursor);
       btn2.setBounds(420,420,100,50);
       c.add(btn2);
       btn3 = new JButton("Register");
       btn3.setCursor(cursor);
       btn3.setBounds(540,420,100,50);
       c.add(btn3);
       
       btn1.addActionListener(handler);
       btn2.addActionListener(handler);
       btn3.addActionListener(handler);
       admin.addActionListener(handler);
       user.addActionListener(handler);
       tech.addActionListener(handler);
    }
    

    class Handler implements ActionListener{
         
         String type=getEnd();
         public void actionPerformed(ActionEvent e) {
                if(e.getSource()==admin){
                   type="admin";
                }
                else if(e.getSource()==user){
                    type="user";
                }
                else if(e.getSource()==tech){
                    type="tech";
                }
               //String type = Handler2.getType();
               if(e.getSource()==tf1){
                   String s1 = tf1.getText();
                    if(s1.isEmpty()){
                        JOptionPane.showMessageDialog(null,"Enter your Username");
                    }
                    else{
                        JOptionPane.showMessageDialog(null,"Tf1: "+s1);
                    }
               }
               else if(e.getSource()==tf2){
                    String s1 = tf2.getText();
                    if(s1.isEmpty()){
                        JOptionPane.showMessageDialog(null,"Enter your Password");
                    }
                    else{
                        JOptionPane.showMessageDialog(null,"Tf2: "+s1);
                    }
               }
               else if(e.getSource()==btn1){
                    String s1 = tf1.getText();
                    String s2 = tf2.getText();
                    String s3="";
                    //if()
                    
                    if(s1.isEmpty()){
                        JOptionPane.showMessageDialog(null,"Enter Username or password");
                    }
                    else{
                            if(type=="user"){
                                boolean fg=false;
                                try {
                                    FileReader reader = new FileReader("Database/users.txt");
                                    BufferedReader bufferedReader = new BufferedReader(reader);

                                    String line;
                                   
                                    String user,pass;
                                    line = bufferedReader.readLine();
                                    while ((user = bufferedReader.readLine()) != null) {
                                        pass = bufferedReader.readLine();
                                        if(user.equals(s1) && pass.equals(s2)){
                                            fg=true;
                                            break;
                                        }
                                    }
                                    reader.close();
                                } catch (IOException ee) {
                                    ee.printStackTrace();
                                }
                                if(fg){
                                    JOptionPane.showMessageDialog(null,"Succesfully logged in "+s1);
                                    User frame = new User(s1);
                                    frame.setVisible(true);
                                }
                                else{
                                    JOptionPane.showMessageDialog(null,"Wrong Username or password");
                                }
                                
                            }
                            else if(type=="admin"){
                                System.out.println("Admin");
                                boolean fg=false;
                                try {
                                    FileReader reader = new FileReader("Database/admins.txt");
                                    BufferedReader bufferedReader = new BufferedReader(reader);

                                    String line;
                                   
                                    String user,pass;
                                    while ((user = bufferedReader.readLine()) != null) {
                                        pass = bufferedReader.readLine();
                                        if(user.equals(s1) && pass.equals(s2)){
                                            fg=true;
                                            break;
                                        }
                                    }
                                    reader.close();
                                } catch (IOException ee) {
                                    ee.printStackTrace();
                                }
                                if(fg){
                                    JOptionPane.showMessageDialog(null,"Succesfully logged in "+s1);
                                    Admin frame = new Admin();
                                    frame.setVisible(true);
                                }
                                else{
                                    JOptionPane.showMessageDialog(null,"Wrong Username or password");
                                }
                            }
                            else if(type=="tech"){
                                 boolean fg=false;
                                try {
                                    FileReader reader = new FileReader("Database/techs.txt");
                                    BufferedReader bufferedReader = new BufferedReader(reader);

                                    String line;
                                   
                                    String user,pass;
                                    while ((user = bufferedReader.readLine()) != null) {
                                        pass = bufferedReader.readLine();
                                        if(user.equals(s1) && pass.equals(s2)){
                                            fg=true;
                                            break;
                                        }
                                    }
                                    reader.close();
                                } catch (IOException ee) {
                                    ee.printStackTrace();
                                }
                                if(fg){
                                    JOptionPane.showMessageDialog(null,"Succesfully logged in "+s1);
                                    Tech frame = new Tech();
                                    frame.setVisible(true);
                                }
                                else{
                                    JOptionPane.showMessageDialog(null,"Wrong Username or password");
                                }
                            }

                    }
               }
               else if(e.getSource()==btn2){
                    tf1.setText("");
                    tf2.setText("");
               }
               else if(e.getSource()==btn3){
                   Registration frame = new Registration();
               }
               
           }
    }
       
    
    public static void main(String[] args) {

        Index frame = new Index();

    }
}