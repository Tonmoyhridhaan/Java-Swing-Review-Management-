

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
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

class Init8 extends JFrame{
     ImageIcon icon;
     Container c;
     JLabel id,date,issue,app,userLabel,imgLabel;
     Font f,f2;
     JTextField tf1,tf2,tf3,tf4;
     JPasswordField jp1;
     JButton btn1,btn2,btn3,btn4;
     Cursor cursor;
     JTextArea ta;
     JScrollPane scroll;
     String s1;
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
       
       //icon---------------------------------------------
       icon = new ImageIcon(getClass().getResource("user2.png"));
       this.setIconImage(icon.getImage());
       
       //image-------------------------------------------
       imgLabel = new JLabel(icon);
       imgLabel.setBounds(250,50,100,100);
       c.add(imgLabel);
       
       //jlabel------------------------------------------
       userLabel = new JLabel();
       userLabel.setText("User Home / Add Appointmments");
       userLabel.setBounds(350,80,250,50);
       userLabel.setFont(f);
       userLabel.setForeground(Color.WHITE);
       c.add(userLabel);
       
       //label
       userLabel = new JLabel();
       userLabel.setText("Enter Id                                   : ");
       userLabel.setBounds(200,200,300,50);
       userLabel.setFont(f);
       userLabel.setForeground(Color.WHITE);
       c.add(userLabel);
       
       userLabel = new JLabel();
       userLabel.setText("Enter Appliance                     : ");
       userLabel.setBounds(200,250,300,50);
       userLabel.setFont(f);
       userLabel.setForeground(Color.WHITE);
       c.add(userLabel);
       
       userLabel = new JLabel();
       userLabel.setText("Enter Warranty(dd/mm/yyyy) : ");
       userLabel.setBounds(200,300,300,50);
       userLabel.setFont(f);
       userLabel.setForeground(Color.WHITE);
       c.add(userLabel);
       
       userLabel = new JLabel();
       userLabel.setText("Write your Issues                  : ");
       userLabel.setBounds(200,350,300,50);
       userLabel.setFont(f);
       userLabel.setForeground(Color.WHITE);
       c.add(userLabel);
       
       
       //JTextField---------------------------------------
       tf1 = new JTextField();
       tf1.setBounds(450,210,200,30);
       tf1.setFont(f2);
       c.add(tf1);
       tf2 = new JTextField();
       tf2.setBounds(450,260,200,30);
       tf2.setFont(f2);
       c.add(tf2);
       tf3 = new JTextField();
       tf3.setBounds(450,310,200,30);
       tf3.setFont(f2);
       c.add(tf3);
       ta = new JTextArea();
       ta.setBounds(450,360,200,100);
       ta.setLineWrap(true);
       ta.setWrapStyleWord(true);
       ta.setFont(f2);
       
       scroll = new JScrollPane(ta,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
       scroll.setBounds(450,360,200,100);
       c.add(scroll);
       
       //Handler Class-------------------------------------
       
       
    }
}
public class UserAdd extends Init8{
    
    
    UserAdd(){
       super.initComponents();
       initComponents(500,250,900,600);
       initComponents();
    }
    UserAdd(String s){
       super.initComponents();
       s1 = s;
       initComponents(500,250,900,600);
       initComponents();
    }
   
       
    @Override
    void initComponents(){
        Handler handler = new Handler();
       
       //Cursor--------------------------------------------
       cursor = new Cursor(Cursor.HAND_CURSOR);
       
       //Button--------------------------------------------
       btn1 = new JButton("Logout");
       btn1.setCursor(cursor);
       btn1.setBounds(700,80,80,40);
       c.add(btn1);
       btn2 = new JButton("Add");
       btn2.setCursor(cursor);
       btn2.setBounds(250,500,100,50);
       c.add(btn2);
       btn3 = new JButton("Clear");
       btn3.setCursor(cursor);
       btn3.setBounds(410,500,100,50);
       c.add(btn3);
       btn4 = new JButton("Back");
       btn4.setCursor(cursor);
       btn4.setBounds(570,500,100,50);
       c.add(btn4);
       
       btn1.addActionListener(handler);
       btn2.addActionListener(handler);
       btn3.addActionListener(handler);
       btn4.addActionListener(handler);
    }
   
    class Handler implements ActionListener{
         public void actionPerformed(ActionEvent e) {
               if(e.getSource()==btn1){
                    JOptionPane.showMessageDialog(null,"Succesfully logged out");
                    Index frame = new Index();
                    frame.setVisible(true);
               }
               else if(e.getSource()==btn2){
                    boolean flag = true;
                    String id = tf1.getText();
                    if(id.isEmpty()){
                        JOptionPane.showMessageDialog(null,"Enter Valid ID");
                        flag=false;
                    }
                    String app = tf2.getText();
                    if(app.isEmpty()){
                        JOptionPane.showMessageDialog(null,"Enter an Applieance");
                        flag=false;
                    }
                    String date = tf3.getText();
                    if(date.isEmpty()){
                        JOptionPane.showMessageDialog(null,"Enter Warranty date");
                        flag=false;
                    }
                    String issue = ta.getText();
                    if(issue.isEmpty()){
                        JOptionPane.showMessageDialog(null,"Enter yor issue");
                        flag=false;
                    }
                    
                    if(flag){
                        //JOptionPane.showMessageDialog(null,s1+" "+id+" "+app+" "+date+" "+issue);
                        
                        try {

                            FileWriter writer = new FileWriter("Database/appointments.txt", true);
                            BufferedWriter bufferedWriter = new BufferedWriter(writer);
                            bufferedWriter.newLine();
                            bufferedWriter.write(s1);
                            bufferedWriter.newLine();
                            bufferedWriter.write(id);
                            bufferedWriter.newLine();
                            bufferedWriter.write(app);
                            bufferedWriter.newLine();
                            bufferedWriter.write(date);
                            bufferedWriter.newLine();
                            bufferedWriter.write(issue);

                            bufferedWriter.close();
                            JOptionPane.showMessageDialog(null,"Issue Successfully Added");


                        } catch (IOException ee) {
                            ee.printStackTrace();
                        }
                        
                    }
                    
               }
               else if(e.getSource()==btn3){
                    tf1.setText("");
                    tf2.setText("");
                    tf3.setText("");
                    ta.setText("");
               }
               else if(e.getSource()==btn4){
                    User frame = new User(s1);
               }
               
           }
    }
       
    
    public static void main(String[] args) {
        
       
        UserAdd frame = new UserAdd();
       

    }
}