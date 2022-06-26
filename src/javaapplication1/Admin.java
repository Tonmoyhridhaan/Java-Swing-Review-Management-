

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

public class Admin extends JFrame{
    private ImageIcon icon;
    private Container c;
    private JLabel userLabel,passLabel,imgLabel;
    private Font f,f2;
    private JTextField tf1,tf2;
    private JPasswordField jp1;
    private JButton btn1,btn2,btn3;
    private Cursor cursor;
    private JTextArea ta;
    private JScrollPane scroll;
    private String s1;
    
    Admin(){
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
       imgLabel.setBounds(250,50,100,100);
       c.add(imgLabel);
       
       //jlabel------------------------------------------
       userLabel = new JLabel();
       userLabel.setText("Admin Home");
       userLabel.setBounds(350,80,100,50);
       userLabel.setFont(f);
       userLabel.setForeground(Color.WHITE);
       c.add(userLabel);
       
       
       //Handler Class-------------------------------------
       Handler handler = new Handler();
       
       //Cursor--------------------------------------------
       cursor = new Cursor(Cursor.HAND_CURSOR);
       
       //Button--------------------------------------------
       btn1 = new JButton("Logout");
       btn1.setCursor(cursor);
       btn1.setBounds(700,80,80,40);
       c.add(btn1);
       btn2 = new JButton("Edit appointments");
       btn2.setCursor(cursor);
       btn2.setBounds(250,250,150,50);
       c.add(btn2);
       btn3 = new JButton("View appointments");
       btn3.setCursor(cursor);
       btn3.setBounds(450,250,150,50);
       c.add(btn3);
       
       btn1.addActionListener(handler);
       btn2.addActionListener(handler);
       btn3.addActionListener(handler);
       
    }
    class Handler implements ActionListener{
         public void actionPerformed(ActionEvent e) {
               if(e.getSource()==btn1){
                    Index frame = new Index();
                    frame.setVisible(true);
               }
               else if(e.getSource()==btn2){
                    AdminEdit frame = new AdminEdit();
                    //frame.setVisible(true);
               }
               else if(e.getSource()==btn3){
                    AdminView frame = new AdminView();
                    //frame.setVisible(true);
               }

           }
    }
       
    
    public static void main(String[] args) {
        
       
        Admin frame = new Admin();
       

    }
}