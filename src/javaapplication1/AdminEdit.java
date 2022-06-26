

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
import java.io.PrintWriter;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class AdminEdit extends JFrame{
    private ImageIcon icon;
    private Container c;
    private JLabel id,date,issue,app,userLabel,imgLabel;
    private Font f,f2;
    private JTextField tf1,tf2,tf3,tf4;
    private JPasswordField jp1;
    private JButton btn1,btn2,btn3,btn4;
    private Cursor cursor;
    private JTextArea ta;
    private JScrollPane scroll;
    private String text1="", text2="";
    
    AdminEdit(){
        
       initComponents();
       this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.setSize(900,600);
        //frame.setLocationRelativeTo(null);

        /*frame.setLocation(200,50);*/
        this.setBounds(500,250,900,600);
        this.setTitle("New Frame");
        this.setResizable(false);
    }
   
    public void initComponents(){
 
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
       imgLabel.setBounds(250,20,100,100);
       c.add(imgLabel);
       
       //jlabel------------------------------------------
       userLabel = new JLabel();
       userLabel.setText("User Home / Add Appointmments");
       userLabel.setBounds(350,50,250,50);
       userLabel.setFont(f);
       userLabel.setForeground(Color.WHITE);
       c.add(userLabel);
       
       //label
       userLabel = new JLabel();
       userLabel.setText("Enter Id          : ");
       userLabel.setBounds(200,150,300,50);
       userLabel.setFont(f);
       userLabel.setForeground(Color.WHITE);
       c.add(userLabel);
       
       userLabel = new JLabel();
       userLabel.setText("Appliance                             : ");
       userLabel.setBounds(200,250,300,50);
       userLabel.setFont(f);
       userLabel.setForeground(Color.WHITE);
       c.add(userLabel);
       
       userLabel = new JLabel();
       userLabel.setText("Warranty(dd/mm/yyyy)         : ");
       userLabel.setBounds(200,300,300,50);
       userLabel.setFont(f);
       userLabel.setForeground(Color.WHITE);
       c.add(userLabel);
       
       userLabel = new JLabel();
       userLabel.setText("Write your Issues                : ");
       userLabel.setBounds(200,350,300,50);
       userLabel.setFont(f);
       userLabel.setForeground(Color.WHITE);
       c.add(userLabel);
       
       
       //JTextField---------------------------------------
       tf1 = new JTextField();
       tf1.setBounds(320,160,200,30);
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
       Handler handler = new Handler();
       
       //Cursor--------------------------------------------
       cursor = new Cursor(Cursor.HAND_CURSOR);
       
       //Button--------------------------------------------
       btn1 = new JButton("Logout");
       btn1.setCursor(cursor);
       btn1.setBounds(700,50,80,40);
       c.add(btn1);
       btn2 = new JButton("Update");
       btn2.setCursor(cursor);
       btn2.setBounds(310,500,100,40);
       c.add(btn2);
       btn3 = new JButton("Search");
       btn3.setCursor(cursor);
       btn3.setBounds(370,200,100,30);
       c.add(btn3);
       btn4 = new JButton("Back");
       btn4.setCursor(cursor);
       btn4.setBounds(430,500,100,40);
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
               else if(e.getSource()==btn3){
                   String id = tf1.getText();
                   try {
                        FileReader reader = new FileReader("Database/appointments.txt");
                        BufferedReader bufferedReader = new BufferedReader(reader);

                        String line;
                        boolean fg=false;
                        text1 += bufferedReader.readLine();
                        while ((line = bufferedReader.readLine()) != null) {
                            if(fg)text2+=line+"\n";
                            else text1+=line+"\n";
                            line = bufferedReader.readLine();
                            if(id.equals(line)){
                                text1+=line;
                                fg=true;
                                String app = bufferedReader.readLine();
                                tf2.setText(app);
                                
                                String date = bufferedReader.readLine();
                                tf3.setText(date);
                                
                                String issue = bufferedReader.readLine();
                                ta.setText(issue);
                                continue;
                            }
                            
                            if(fg)text2+=line+"\n";
                            else text1+=line+"\n";
                            line = bufferedReader.readLine();
                            if(fg)text2+=line+"\n";
                            else text1+=line+"\n";
                            line = bufferedReader.readLine();
                            if(fg)text2+=line+"\n";
                            else text1+=line+"\n";
                            line = bufferedReader.readLine();
                            if(fg)text2+=line+"\n";
                            else text1+=line+"\n";
                            

                        }
                        
                        reader.close();
                    } catch (IOException ee) {
                        ee.printStackTrace();
                    }
                   
               }
               else if(e.getSource()==btn2){
                    
                    String app = tf2.getText();
                    String date = tf3.getText();
                    String issue = ta.getText();
                    if(app.isEmpty()){
                        JOptionPane.showMessageDialog(null,"Appliance can't be empty");
                        
                    }
                    else if(date.isEmpty()){
                        JOptionPane.showMessageDialog(null,"Warranty can't be empty");
                        
                    }
                    else if(issue.isEmpty()){
                        JOptionPane.showMessageDialog(null,"issue can't be empty");
                        
                    }
                    else{
                        try {
                            FileWriter writer = new FileWriter("Database/appointments.txt", false);
                           
                            PrintWriter pwOb = new PrintWriter(writer, false);
                            pwOb.flush();
                            pwOb.close();
                            writer = new FileWriter("Database/appointments.txt", true);
                            BufferedWriter bufferedWriter = new BufferedWriter(writer);
                            
                            bufferedWriter.newLine();
                            bufferedWriter.write(text1);
                            bufferedWriter.newLine();
                            bufferedWriter.write(app);
                            bufferedWriter.newLine();
                            bufferedWriter.write(date);
                            bufferedWriter.newLine();
                            bufferedWriter.write(issue);
                            bufferedWriter.newLine();
                            bufferedWriter.write(text2);

                            bufferedWriter.close();

                        } catch (IOException ee) {
                            ee.printStackTrace();
                        }
                        JOptionPane.showMessageDialog(null,"Successfully updated");
                    }
                        
                } 
               else if(e.getSource()==btn4){
                    Admin frame = new Admin();
               }
               
           }
    }
       
    
    public static void main(String[] args) {
        
       
        AdminEdit frame = new AdminEdit();
       

    }
}