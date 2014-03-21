/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package index;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.Font;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 *  
 */
class connection
{
    Connection con;
        void createconnectn()
        {
            try
            {
                System.out.println("main(): loading jdbc driver for software ");
                Class.forName("oracle.jdbc.driver.OracleDriver");
                System.out.println("main(): getting connection");
                con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "shenki");
                System.out.println("connected!!!");
             }
             catch(ClassNotFoundException fe)
             {
                System.err.println("main(): ClassNotFoundException: " + fe.getMessage());
             }
             catch(SQLException fe)
             {
                System.err.println("main(): SQLException: " + fe.getMessage());
             }
       
        }
}
public class Index {

    /**
     * @param args the command line arguments
     */
        JFrame frame1=new JFrame("Juno-Index");
        JPanel p1=new JPanel();
        JPanel px=new JPanel();
        JLabel l1= new JLabel("Juno");
        ImageIcon i1=new ImageIcon("logo.png");
        ImageIcon i2=new ImageIcon("cloud.png");
        ImageIcon i3=new ImageIcon("upload.png");
        ImageIcon i4=new ImageIcon("settings.png");
        ImageIcon i5=new ImageIcon("dropbox.png");
        JButton l2=new JButton(i1);
        JButton logout=new JButton("Logout");
        JPanel p3=new JPanel();
        JPanel p2=new JPanel();
        JLabel pxj;
        JButton cloud,upload,setting,dropbox;
        String ad;
        JLabel l5=new JLabel("Cloud Storage Client - Indian Institute of Information Technology,Allahabad");
        public Index(String admin){
            ad=admin;
            Container content = frame1.getContentPane();
            content.setBackground(Color.WHITE);
            frame1.setIconImage(Toolkit.getDefaultToolkit().getImage("logo.jpg"));
            frame1.setSize(900,600);
            frame1.setResizable(false);
            frame1.setLayout(null);
            frame1.setBackground(Color.white);
            p1.setLayout(null);
            p1.setBackground(Color.white);
            l2.setBounds(10,1,100,100);
            l1.setBounds(160,1,600,100);
            logout.setBounds(650,30,150,40);
            p1.setBounds(0,0,900,110);
            p1.setBorder(BorderFactory.createLineBorder(Color.black));
            cloud=new JButton("cloud");
            cloud.setBounds(10,120,240,190);
            cloud.setIcon(i2);
            cloud.addActionListener(new ActionListener(){
            @Override
             public void actionPerformed(ActionEvent e){
                 frame1.setVisible(false);
                 //Public_upload f1=new Public_upload(ad);
                 Cld cc1=new Cld(ad);
             }
         });
            upload=new JButton("upload");
            upload.setBounds(280,120,240,190);
            upload.setIcon(i3);
            upload.addActionListener(new ActionListener(){
            @Override
             public void actionPerformed(ActionEvent e){
                 frame1.setVisible(false);
                 Public_upload f1=new Public_upload(ad);
             }
         });
            setting=new JButton("setting");
            setting.setBounds(10,320,240,190);
            setting.setIcon(i4);
            dropbox=new JButton("dropbox");
            dropbox.setBounds(280,320,240,190);
            dropbox.setIcon(i5);
            dropbox.addActionListener(new ActionListener(){
            @Override
             public void actionPerformed(ActionEvent e){
                 frame1.setVisible(false);
                 Groups g=new Groups(ad);
             }
         });
            p1.add(l2,BorderLayout.NORTH);
            l1.setFont(new Font("Verdana", Font.BOLD, 58));
            l1.setForeground(Color.DARK_GRAY);
            p1.add(l1);
            p1.add(logout);
            p1.add(l2);
            p3.add(l5);
            p3.setBounds(0,530,900,40);
            p3.setBackground(Color.white);
            
            px.setLayout(null);
            px.setBounds(530,60,350,530);
            px.setBackground(Color.WHITE);
            for(int i=0;i<10;i++){
                //System.out.println("ved");
                JPanel xx=new JPanel();
                xx.setBounds(10,10+i*30,359,30);
                pxj=new JLabel("kinner"+i);
                pxj.setBounds(0,0,350,30);
                if (i%2==0) xx.setBackground(Color.WHITE);
                else xx.setBackground(Color.LIGHT_GRAY);
            xx.add(pxj);
            //px.add(xx);
            }
            l2.addActionListener(new ActionListener(){
            @Override
             public void actionPerformed(ActionEvent e){
                 frame1.setVisible(false);
                 //Public_upload f1=new Public_upload(ad);
                 Index kk=new Index (ad);
             }
         });
            logout.addActionListener(new ActionListener(){
            @Override
             public void actionPerformed(ActionEvent e){
                 frame1.setVisible(false);
                 //Public_upload f1=new Public_upload(ad);
                 Login ll=new Login();
             }
         });
            
            frame1.add(p1);
            frame1.add(px);
            frame1.add(p3);
            frame1.add(cloud);
            frame1.add(upload);
            frame1.add(setting);
            frame1.add(dropbox);
            frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame1.setVisible(true);
        }
    public static void main(String[] args) {
        // TODO code application logic here
       Login L=new Login();
        //Groups G=new Groups("rit2010030");
        //Index i=new Index("rit2010030");
        
    }
}
