

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
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

class Init6 extends JFrame{
     ImageIcon icon;
     Container c;
     JLabel userLabel,passLabel,imgLabel;
     Font f,f2;
     JTextField tf1,tf2;
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
       userLabel.setText("Tech Home / User Appointments");
       userLabel.setBounds(350,80,250,50);
       userLabel.setFont(f);
       userLabel.setForeground(Color.WHITE);
       c.add(userLabel);
       
       ta = new JTextArea();
       ta.setBounds(250,150,400,300);
       ta.setLineWrap(true);
       ta.setWrapStyleWord(true);
       ta.setFont(f2);
       
       scroll = new JScrollPane(ta,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
       scroll.setBounds(250,150,400,300);
       c.add(scroll);
       
       
       
       
    }
}
public class TechView extends Init6{
    
    
    TechView(){
       super.initComponents();
       initComponents(500,250,900,600);
       initComponents();
       
        
    }
    void initComponents(){
        //Handler Class-------------------------------------
       Handler handler = new Handler();
       
       //Cursor--------------------------------------------
       cursor = new Cursor(Cursor.HAND_CURSOR);
       
       //Button--------------------------------------------
       btn1 = new JButton("Logout");
       btn1.setCursor(cursor);
       btn1.setBounds(700,80,80,40);
       c.add(btn1);
       
       btn4 = new JButton("Back");
       btn4.setCursor(cursor);
       btn4.setBounds(400,500,100,50);
       c.add(btn4);
       
       btn1.addActionListener(handler);
       btn4.addActionListener(handler);
       
       try {
            FileReader reader = new FileReader("Database/appointments.txt");
            BufferedReader bufferedReader = new BufferedReader(reader);

            String line,text="";
            
            line = bufferedReader.readLine();
            while ((line = bufferedReader.readLine()) != null) {
              
                line = bufferedReader.readLine();
                text+=line+"\n";
                line = bufferedReader.readLine();
                text+=line+"\n";
                line = bufferedReader.readLine();
                text+=line+"\n";
                line = bufferedReader.readLine();
                text+=line+"\n";
                text+="\n";
               
            }
            ta.setText(text);
            reader.close();
        } catch (IOException ee) {
            ee.printStackTrace();
        }
    }
    
    class Handler implements ActionListener{
         public void actionPerformed(ActionEvent e) {
               if(e.getSource()==btn1){
                    Index frame = new Index();
               }
               if(e.getSource()==btn4){
                    Tech frame = new Tech();
               }
               
           }
    }
       
    
    public static void main(String[] args) {
        
       
        TechView frame = new TechView();
       

    }
}