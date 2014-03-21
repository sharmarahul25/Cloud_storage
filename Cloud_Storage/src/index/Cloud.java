/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package index;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.Font;
import java.io.File;
import java.io.IOException;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.net.ftp.FTPClient;
/**
 *
 *  SaSORi
 */
public class Cloud {
    JFrame frame1=new JFrame("Cloud");
    JPanel p1=new JPanel();
    JLabel l1= new JLabel("Juno");
    JButton Login=new JButton("Login");
    ImageIcon i1=new ImageIcon("logo.png");
    JButton l2=new JButton(i1);
    JButton mov=new JButton("Movies");
    JButton doc=new JButton("Documentries");
    JButton rep=new JButton("Repository");
    JButton book=new JButton("Books");
    JButton soft=new JButton("Softwares");
    JButton nxt=new JButton("Next>>");
    JButton prev=new JButton("<<Previous");
    JPanel p3=new JPanel();
    JPanel p2=new JPanel();
    JTextField username = new JTextField(20);
    JButton xx3=new JButton("download");
    JPasswordField password = new JPasswordField(20);
    JLabel l5=new JLabel("Cloud Storage Client - Indian Institute of Information Technology,Allahabad");
    ButtonGroup group = new ButtonGroup();
    Statement stat;
    ResultSet rs;
    String s,ad;
    int c=0,d=0;
    int i=0,j=0;
    JButton logout=new JButton("Logout");
    String [][]z=new String [100][2];
    String [][]z1=new String [100][2];
    String [][]z2=new String [100][2];
    public Cloud(String admin){
        Container content = frame1.getContentPane();
            content.setBackground(Color.WHITE);
            frame1.setIconImage(Toolkit.getDefaultToolkit().getImage("logo.jpg"));
            frame1.setSize(900,600);
            frame1.setResizable(false);
            frame1.setLayout(null);
            frame1.setBackground(Color.white);
            nxt.setBounds(480,440,100,30);
            nxt.setEnabled(false);
            prev.setBounds(280,440,100,30);
            prev.setEnabled(false);
            p1.setLayout(null);
            p1.setBackground(Color.white);
            p1.setBounds(0,0,900,110);
            p1.add(l2,BorderLayout.NORTH);
            p1.setBorder(BorderFactory.createLineBorder(Color.black));
            logout.setBounds(650,30,150,40);
            l2.setBounds(10,1,100,100);
            l1.setBounds(160,1,600,100);
            l1.setFont(new Font("Verdana", Font.BOLD, 58));
            l1.setForeground(Color.DARK_GRAY);
            p1.add(l1);
            p1.add(l2);
            p1.add(logout);
            p3.add(l5);
            p2.setLayout(null);
            p2.setBackground(Color.white);
            p2.setBorder(BorderFactory.createLineBorder(Color.black));
            mov.setBounds(10,120,150,30);
            doc.setBounds(170,120,150,30);
            rep.setBounds(330,120,150,30);
            book.setBounds(490,120,150,30);
            soft.setBounds(650,120,150,30);
            p2.setBounds(10,160,870,270);
            p3.setBounds(0,530,900,40);
            p3.setBackground(Color.white);
            frame1.add(p1);
            frame1.add(mov);
            frame1.add(doc);
            frame1.add(rep);
            frame1.add(book);
            frame1.add(soft);
            frame1.add(p2);
            frame1.add(nxt);
            frame1.add(prev);
            frame1.add(p3);
            logout.addActionListener(new ActionListener(){
            @Override
             public void actionPerformed(ActionEvent e){
                 frame1.setVisible(false);
                 //Public_upload f1=new Public_upload(ad);
                 Login ll=new Login();
             }
         });
            
            mov.addActionListener(new ActionListener(){
            @Override
             public void actionPerformed(ActionEvent e){
                connection con1=new connection();
                con1.createconnectn();
                String s;
                try
                {
                        stat = con1.con.createStatement();
                        //s=group.getText();
                        rs=stat.executeQuery("select id,name from Movies");
                 }
                 catch (SQLException fe)
                 {
                        System.err.println("actionpermd(): SQLException: " + fe.getMessage());
                 } 
                  try
                {
                    //int c=0;
                    String pa=null;
                    //t5.addItem("Public");
                    
                    while(rs.next())
                    {
                        
                       z[i][0]=rs.getString("id");
                       z[i][1]=rs.getString("name");
                       i++;
                    }
                    for(j=0;j<10 && j<i;j++)
                    {
                       JLabel xx1=new JLabel(z[j][0]);
                       xx1.setBounds(10,30*(j-1),200,20);
                       p2.add(xx1);
                       
                       JLabel xx2=new JLabel(z[j][1]);
                       xx2.setBounds(220,30*(j-1),200,20);
                       p2.add(xx2);
                       
                       xx3=new JButton("download");
                       xx3.setActionCommand(z[j][0]);
                       xx3.setBounds(420,30*(j-1),200,20);
                       xx3.addActionListener(sliceActionListener);
                       group.add(xx3);
                       p2.add(xx3);
                      
                    }
                    if(j==10 && i>j)
                    {
                        nxt.setEnabled(true);
                    }                        
                }
                catch (SQLException fe)
                {
                    System.err.println("actionpermd(): SQLException: " + fe.getMessage());

                }
             }
         });
            
            //
                        doc.addActionListener(new ActionListener(){
            @Override
             public void actionPerformed(ActionEvent e){
                connection con1=new connection();
                con1.createconnectn();
                String s;
                try
                {
                        stat = con1.con.createStatement();
                        //s=group.getText();
                        rs=stat.executeQuery("select id,name from Documentaries");
                 }
                 catch (SQLException fe)
                 {
                        System.err.println("actionpermd(): SQLException: " + fe.getMessage());
                 } 
                  try
                {
                    //int c=0;
                    String pa=null;
                    //t5.addItem("Public");
                    
                    while(rs.next())
                    {
                        
                       z[i][0]=rs.getString("id");
                       z[i][1]=rs.getString("name");
                       i++;
                    }
                    for(j=0;j<10 && j<i;j++)
                    {   
                       JLabel xx1=new JLabel(z[j][0]);
                       p2.add(xx1);
                       xx1.setBounds(10,30*(j-1),200,20);
                       JLabel xx2=new JLabel(z[j][1]);
                       p2.add(xx2);
                       xx2.setBounds(220,30*(j-1),200,20);
                       xx3=new JButton("download");
                       xx3.setActionCommand(z[j][0]);
                       xx3.setBounds(420,30*(j-1),200,20);
                       xx3.addActionListener(sliceActionListener);
                       group.add(xx3);
                       p2.add(xx3);
                      
                    }
                    if(j==10 && i>j)
                    {
                        nxt.setEnabled(true);
                    }                        
                }
                catch (SQLException fe)
                {
                    System.err.println("actionpermd(): SQLException: " + fe.getMessage());

                }
             }
         });
            //
                        
          
            l2.addActionListener(new ActionListener(){
            @Override
             public void actionPerformed(ActionEvent e){
                 frame1.setVisible(false);
                 Index kk=new Index (ad);
             }
         });
            nxt.addActionListener(new ActionListener(){
            @Override
             public void actionPerformed(ActionEvent e){
                 //frame1.setVisible(false);
                 //Index kk=new Index (ad);
                d++;
                c=0;
                if(d>0)
                    prev.setEnabled(true);
                else 
                    prev.setEnabled(false);
                p2.removeAll();
                      c=0;
                      int ved=0;
                      for(j=(d*10);j<(d*10)+10 && j<i;j++)
                        {
                            JLabel xx1=new JLabel(z[j][0]);
                       p2.add(xx1);
                       xx1.setBounds(10,30*(ved),200,20);
                       JLabel xx2=new JLabel(z[j][1]);
                       p2.add(xx2);
                       xx2.setBounds(220,30*(ved-1),200,20);
                       xx3=new JButton("download");
                       xx3.setActionCommand(z[j][0]);
                       xx3.setBounds(420,30*(ved-1),200,20);
                       xx3.addActionListener(sliceActionListener);
                       group.add(xx3);
                       p2.add(xx3);
                       ved++;
                           c++;
                        }
                      p2.revalidate();
                      frame1.repaint();
               
             }
         });
          prev.addActionListener(new ActionListener(){
            @Override
             public void actionPerformed(ActionEvent e){
                 //frame1.setVisible(false);
                 //Index kk=new Index (ad);
                d--;
                if(d>0)
                    prev.setEnabled(true);
                else 
                    prev.setEnabled(false);
                p2.removeAll();
                //try {
                     c=0;
                     for(j=(d*10);j<(d*10)+10;j++)
                        {  
                           //c++;
                            int ved=0;
                           JLabel xx1=new JLabel(z[j][0]);
                       p2.add(xx1);
                       xx1.setBounds(10,30*(ved),200,20);
                       JLabel xx2=new JLabel(z[j][1]);
                       p2.add(xx2);
                       xx2.setBounds(220,30*(ved-1),200,20);
                       xx3=new JButton("download");
                       xx3.setActionCommand(z[j][0]);
                       xx3.setBounds(420,30*(ved-1),200,20);
                       xx3.addActionListener(sliceActionListener);
                       group.add(xx3);
                       p2.add(xx3);
                       ved++;
                           c++;
                        }
                      p2.revalidate();
                      frame1.repaint();
             }
         });
            frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame1.setVisible(true);
    }
    ActionListener sliceActionListener = new ActionListener() {
      public void actionPerformed(ActionEvent actionEvent) {
        AbstractButton aButton = (AbstractButton) actionEvent.getSource();
       System.out.println("Selected: " + aButton.getActionCommand());
        
            
        }
    };
}
