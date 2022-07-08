

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
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

class Init5 extends JFrame{
     ImageIcon icon;
     Container c;
     JLabel userLabel,passLabel,imgLabel;
     Font f,f2;
     JTextField tf1,tf2;
     JPasswordField jp1;
     JButton btn1,btn2,btn3;
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
       userLabel.setText("Tech Home");
       userLabel.setBounds(350,80,80,50);
       userLabel.setFont(f);
       userLabel.setForeground(Color.WHITE);
       c.add(userLabel);

    }
}
public class Tech extends Init5{
   
    
    Tech(){
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
      
       btn3 = new JButton("View appointments");
       btn3.setCursor(cursor);
       btn3.setBounds(350,250,150,50);
       c.add(btn3);
       
       btn1.addActionListener(handler);

       btn3.addActionListener(handler);
    }
    
    class Handler implements ActionListener{
         public void actionPerformed(ActionEvent e) {
               if(e.getSource()==btn1){
                    Index frame = new Index();
                    frame.setVisible(true);
               }
              
               else if(e.getSource()==btn3){
                    TechView frame = new TechView();
                    //frame.setVisible(true);
               }

           }
    }
       
    
    public static void main(String[] args) {
        
       
        Tech frame = new Tech();
       

    }
}