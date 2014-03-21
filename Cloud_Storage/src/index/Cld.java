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
import oracle.net.aso.a;
import org.apache.commons.net.ftp.FTPClient;
/**
 *
 *  SaSORi
 */
public class Cld {
    JFrame frame1=new JFrame("Login");
    JPanel p1=new JPanel();
    JLabel l1= new JLabel("Juno");
    JButton Login=new JButton("Login");
    ImageIcon i1=new ImageIcon("logo.png");
    JButton l2=new JButton(i1);
    JPanel p3=new JPanel();
    JPanel p2=new JPanel();
    JComboBox grp=new JComboBox();
    JTextField gg=new JTextField();
    JButton ok=new JButton("OK");
    ButtonGroup group1=new ButtonGroup();
    ButtonGroup group2=new ButtonGroup();
    String choosex[]={"Movies","Documentaries","Books","Repsitory","Music"};
    JComboBox choose=new JComboBox(choosex);    
    String set[][];
    JLabel l5=new JLabel("Cloud Storage Client - Indian Institute of Information Technology,Allahabad");
    Statement stat;
    ResultSet rs;
    String s,ad,s1,s2,s3;
    JButton logout=new JButton("Logout");
 Cld(String admin){
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
            p1.setBounds(0,0,900,110);
            p1.add(l2,BorderLayout.NORTH);
            p1.setBorder(BorderFactory.createLineBorder(Color.black));
            p2.setLayout(null);
            p2.setBounds(10,160,870,270);
            p2.setBackground(Color.white);
            p3.setBounds(0,530,900,40);
            p3.setBackground(Color.white);
            p2.setBorder(BorderFactory.createLineBorder(Color.black));
            l2.setBounds(10,1,100,100);
            logout.setBounds(650,30,150,40);
            l1.setBounds(160,1,600,100);
            l1.setFont(new Font("Verdana", Font.BOLD, 58));
            l1.setForeground(Color.DARK_GRAY);
            p1.add(l1);
            p1.add(l2);
            p3.add(l5);
            frame1.add(p2);
            frame1.add(p1);
            frame1.add(p3);
            logout.addActionListener(new ActionListener(){
            @Override
             public void actionPerformed(ActionEvent e){
                 frame1.setVisible(false);
                 //Public_upload f1=new Public_upload(ad);
                 Login ll=new Login();
             }
         });
            l2.addActionListener(new ActionListener(){
            @Override
             public void actionPerformed(ActionEvent e){
                 frame1.setVisible(false);
                 Index kk=new Index (ad);
             }
         });
         gg.setBounds(10,120,200,30);
         choose.setBounds(220,120,200,30);
         grp.setBounds(430,120,200,30);
         ok.setBounds(650,120,100,30);
         frame1.add(gg);
         frame1.add(choose);
         frame1.add(ok);
         frame1.add(grp);
         frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         frame1.setVisible(true);
         connection con1=new connection();
                con1.createconnectn();
                String s;
                try
                {
                        stat = con1.con.createStatement();
                        rs=stat.executeQuery("select grp_name from groupmem where(mem_id='"+ad+"')");
                 }
                 catch (SQLException fe)
                 {
                        System.err.println("actionpermd(): SQLException: " + fe.getMessage());
                 }
                 try
                {
                    int c=0;
                    String pa=null;
                    grp.addItem("Public");
                    while(rs.next())
                    {
                        pa=rs.getString("grp_name");
                        if(pa!=null)
                        {
                            grp.addItem(pa);
                        }
                    }
                }
                catch (SQLException fe)
                {
                    System.err.println("actionpermd(): SQLException: " + fe.getMessage());

                }
         ok.addActionListener(new ActionListener(){
            @Override
             public void actionPerformed(ActionEvent e){
                 s1=gg.getText();
                 s2=(String)choose.getSelectedItem();
                 s3=(String)grp.getSelectedItem();
                 connection con1=new connection();
                con1.createconnectn();
                try
                {
                        stat = con1.con.createStatement();
                        rs=stat.executeQuery("select name,path1 from "+s2+" where(name='"+s1+"' AND per='"+s3+"')");
                 }
                 catch (SQLException fe)
                 {
                        System.err.println("actionpermd(): SQLException: " + fe.getMessage());
                 }
                try
                {
                    //int c=0;
                    String pa1=null,pa2=null;
                    grp.addItem("Public");
                    int ix=0;
                    while(rs.next())
                    {
                        pa1=rs.getString("name");
                        System.out.println(pa1);
                        pa2=rs.getString("path1");
                        System.out.println(pa2);
                        JLabel xl=new JLabel(pa1);
                        JButton xp=new JButton("Download");
                        xp.setActionCommand(pa2);
                        xl.setBounds(10,30*ix,100,30);
                        xp.setBounds(110,30*ix,100,30);
                        p2.add(xp);
                        p2.add(xl);
                        xp.addActionListener(sliceActionListener);
                        ix++;
                    }
                }
                catch (SQLException fe)
                {
                    System.err.println("actionpermd(): SQLException: " + fe.getMessage());

                }
                p2.revalidate();
                frame1.repaint();
             }
         });
    }
 ActionListener sliceActionListener = new ActionListener() {
      public void actionPerformed(ActionEvent actionEvent) {
        AbstractButton aButton = (AbstractButton) actionEvent.getSource();
        System.out.println("Selected: " + aButton.getText());
        FTPClient f=new FTPClient();
             FTPUtils u=new FTPUtils();
                try {
                    u.ftpConnect(f,"172.16.1.1","anonymous","");
                    System.out.println("logged in");
                } catch (IOException ex) {
                    Logger.getLogger(Movies_Upload.class.getName()).log(Level.SEVERE, null, ex);
                }
            try {
                u.downloadFile(f,"ftp://172.16.1.1/Upload/Bhagam Bhag Hindi Movie kalaasif1 - YouTube.FLV","C://Users//SaSORi//Downloads//v");
            } catch (IOException ex) {
                Logger.getLogger(Cld.class.getName()).log(Level.SEVERE, null, ex);
            }
      }
    };
}
