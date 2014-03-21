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
public class Groups {
    JFrame frame1=new JFrame("Login");
    JFrame frame2=new JFrame("New");
    JPanel p1=new JPanel();
    JLabel l1= new JLabel("Juno");
    JLabel l4= new JLabel("Create a");
    JLabel l6= new JLabel("Group name");
    JLabel l7= new JLabel("Select Group");
    JLabel l8=new JLabel("EnterID");
    JLabel l3=new JLabel("Groups Management");
    ImageIcon i1=new ImageIcon("logo.png");
    JButton l2=new JButton(i1);
    JPanel p3=new JPanel();
    JPanel p2=new JPanel();
    JTextField group = new JTextField(20);
    JTextField id = new JTextField(20);
    JLabel l5=new JLabel("Cloud Storage Client - Indian Institute of Information Technology,Allahabad");
    Statement stat;
    ResultSet rs;
    JButton New=new JButton("New Group");
    JButton ok=new JButton("OK");
    JButton ok1=new JButton("Add");
    JButton ok2=new JButton("Remove");
    JButton ok3=new JButton("ok");
    JButton add=new JButton("Add member");
    JButton rem=new JButton("Remove member");
    JComboBox grp=new JComboBox();
    JComboBox memb=new JComboBox();
    String ad;
    String str1,str2,str3;
    JButton logout=new JButton("Logout");
    public Groups(String admin)
    {
        ad=admin;
        Container content = frame1.getContentPane();
        content.setBackground(Color.WHITE);
        frame1.setIconImage(Toolkit.getDefaultToolkit().getImage("logo.jpg"));
        frame1.setSize(900,600);
        frame1.setResizable(false);
        frame1.setLayout(null);
        frame1.setBackground(Color.white);
        p1.setLayout(null);
        logout.setBounds(650,30,150,40);
        p1.add(logout);
        p1.setBackground(Color.white);
        p1.setBounds(0,0,900,110);
        p1.add(l2,BorderLayout.NORTH);
        p1.setBorder(BorderFactory.createLineBorder(Color.black));
        p2.setLayout(null);
        p2.setBackground(Color.white);
        p2.setBounds(10,120,870,400);
        p2.setBorder(BorderFactory.createLineBorder(Color.black));
        p3.setBounds(0,530,900,40);
        p3.setBackground(Color.white);
        l2.setBounds(10,1,100,100);
        l1.setBounds(160,1,600,100);
        l1.setFont(new Font("Verdana", Font.BOLD, 58));
        l1.setForeground(Color.DARK_GRAY);
        l3.setFont(new Font("Verdana", Font.ROMAN_BASELINE, 28));
        l3.setForeground(Color.BLUE);
        l3.setBounds(250,20,400,35);
        l4.setFont(new Font("Verdana", Font.ROMAN_BASELINE, 24));
        l4.setForeground(Color.BLACK);
        l4.setBounds(20,80,150,30);
        l6.setVisible(false);
        l7.setVisible(false);
        l8.setVisible(false);
        ok1.setVisible(false);
        ok2.setVisible(false);
        id.setVisible(false);
        grp.setVisible(false);
        ok.setVisible(false);
        ok3.setVisible(false);
        group.setVisible(false);
        memb.setVisible(false);
        memb.addItem("");
        p1.add(l1);
        p1.add(l2);
        p2.add(New);
        p2.add(l3);
        p2.add(l4);
        p2.add(l6);
        p2.add(group);
        p2.add(grp);
        p2.add(ok);
        p2.add(add);
        p2.add(l7);
        p2.add(l8);
        p2.add(ok1);
        p2.add(ok2);
        p2.add(ok3);
        p2.add(id);
        p2.add(rem);
        p2.add(memb);
        New.setBounds(130,80,150,30);
        New.addActionListener(new ActionListener(){
            @Override
             public void actionPerformed(ActionEvent e){
                add.setEnabled(false);
                rem.setEnabled(false);
                l6.setFont(new Font("Verdana", Font.ROMAN_BASELINE, 24));
                l6.setForeground(Color.BLUE);
                l6.setBounds(20,115,150,30);
                group.setBounds(20,150,200,30);
                ok.setBounds(20,190,75,30);
                group.setText("");
                l6.setVisible(true);
                ok.setVisible(true);
                group.setVisible(true);
             
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
        ok.setBounds(160,200,100,30);
        ok.addActionListener(new ActionListener(){
            @Override
             public void actionPerformed(ActionEvent e){
                connection con1=new connection();
                con1.createconnectn();
                String s;
                try
                {
                        stat = con1.con.createStatement();
                        s=group.getText();
                        rs=stat.executeQuery("select * from groups where(name='"+s+"')");
                 }
                 catch (SQLException fe)
                 {
                        System.err.println("actionpermd(): SQLException: " + fe.getMessage());
                 }
                try
                {
                    int c=0;
                    while(rs.next())
                    {
                        c++;
                    }
                    if(c>0)
                    {
                        JOptionPane.showMessageDialog(null,"Group already exists ..try a new name");
                    }
                    else
                    {
                        stat = con1.con.createStatement();
                        s=group.getText();
                        rs=stat.executeQuery("insert into groups values('"+s+"','"+ad+"')");
                        rs=stat.executeQuery("insert into groupmem values('"+s+"','"+ad+"')");
                        l6.setVisible(false);
                        ok.setVisible(false);
                        group.setVisible(false);
                        add.setEnabled(true);
                        rem.setEnabled(true);
                        grp.addItem(s);
                        JOptionPane.showMessageDialog(null,"Group created");
                    }
                }
                catch (SQLException fe)
                {
                    System.err.println("actionpermd(): SQLException: " + fe.getMessage());

                }
             }
         });
        add.setBounds(300,80,150,30);
         add.addActionListener(new ActionListener(){
            @Override
             public void actionPerformed(ActionEvent e){
                New.setEnabled(false);
                rem.setEnabled(false);
                l7.setFont(new Font("Verdana", Font.ROMAN_BASELINE, 22));
                l7.setForeground(Color.BLUE);
                l7.setBounds(300,115,200,30);
                l8.setFont(new Font("Verdana", Font.ROMAN_BASELINE, 22));
                l8.setForeground(Color.BLUE);
                l8.setBounds(300,185,200,30);
                id.setBounds(300,220,200,30);
                ok1.setBounds(300,255,75,30);
                grp.setBounds(300,150,200,30);
                l7.setVisible(true);
                grp.setVisible(true);
                l8.setVisible(true);
                id.setVisible(true);
                ok1.setVisible(true);
             }
         });
        connection con1=new connection();
        con1.createconnectn();
        try
         {
             String pa=null;
             stat = con1.con.createStatement();
             rs=stat.executeQuery("select name from groups where admin='"+ad+"'");
             while(rs.next())
             {   
                 pa=rs.getString("name");
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
        ok1.addActionListener(new ActionListener(){
            @Override
             public void actionPerformed(ActionEvent e){
                connection con1=new connection();
                con1.createconnectn();
                String s;
                try
                {
                        stat = con1.con.createStatement();
                        s=id.getText();
                        str1 = (String)grp.getSelectedItem();
                        rs=stat.executeQuery("select * from groupmem where(grp_name='"+str1+"' AND mem_id='"+s+"')");
                 }
                 catch (SQLException fe)
                 {
                        System.err.println("actionpermd(): SQLException: " + fe.getMessage());
                 }
                try
                {
                    int c=0;
                    while(rs.next())
                    {
                        c++;
                    }
                    if(c>0)
                    {
                        JOptionPane.showMessageDialog(null,"member already added");
                    }
                    else
                    {
                        stat = con1.con.createStatement();
                        s=id.getText();
                        rs=stat.executeQuery("insert into groupmem values('"+str1+"','"+s+"')");
                        l7.setVisible(false);
                        l8.setVisible(false);
                        ok1.setVisible(false);
                        grp.setVisible(false);
                        id.setVisible(false);
                        New.setEnabled(true);
                        rem.setEnabled(true);
                        JOptionPane.showMessageDialog(null,"Added to group");
                        id.setText("");
                    }
                }
                catch (SQLException fe)
                {
                    System.err.println("actionpermd(): SQLException: " + fe.getMessage());

                }
             }
         });
        rem.setBounds(470, 80,250,30);
        rem.addActionListener(new ActionListener(){
            @Override
             public void actionPerformed(ActionEvent e){
                New.setEnabled(false);
                add.setEnabled(false);
                l7.setFont(new Font("Verdana", Font.ROMAN_BASELINE, 22));
                l7.setForeground(Color.BLUE);
                l7.setBounds(470,115,200,30);
                l8.setFont(new Font("Verdana", Font.ROMAN_BASELINE, 22));
                l8.setForeground(Color.BLUE);
                l8.setBounds(470,185,200,30);
                memb.setBounds(470,220,200,30);
                ok2.setBounds(470,255,75,30);
                grp.setBounds(470,150,200,30);
                ok3.setBounds(680,150,70,30);
                l7.setVisible(true);
                grp.setVisible(true);
                l8.setVisible(true);
                memb.setVisible(true);
                ok2.setVisible(true);
                ok3.setVisible(true);
             }
         });
        ok3.addActionListener(new ActionListener(){
            @Override
             public void actionPerformed(ActionEvent e){
                memb.removeAllItems();
                connection con1=new connection();
                con1.createconnectn();
                try
                {
                        stat = con1.con.createStatement();
                        //s=id.getText();
                        str2 = (String)grp.getSelectedItem();
                        rs=stat.executeQuery("select mem_id from groupmem where(grp_name='"+str2+"')");
                 }
                 catch (SQLException fe)
                 {
                        System.err.println("actionpermd(): SQLException: " + fe.getMessage());
                 }
                 try
                {
                    int c=0;
                    String pa=null;
                    //t5.addItem("Public");
                    while(rs.next())
                    {
                        pa=rs.getString("mem_id");
                        if(pa!=null)
                        {
                            memb.addItem(pa);
                        }
                    }
                }
                catch (SQLException fe)
                {
                    System.err.println("actionpermd(): SQLException: " + fe.getMessage());

                }
             }
         });
        l2.addActionListener(new ActionListener(){
            @Override
             public void actionPerformed(ActionEvent e){
                 frame1.setVisible(false);
                 //Public_upload f1=new Public_upload(ad);
                 Index kk=new Index (ad);
             }
         });
        ok2.addActionListener(new ActionListener(){
            @Override
             public void actionPerformed(ActionEvent e){
                connection con1=new connection();
                con1.createconnectn();
                try
                {
                        stat = con1.con.createStatement();
                        str1 = (String)grp.getSelectedItem();
                        str2 = (String)memb.getSelectedItem();
                        //System.out.println(str1+"  ");
                        if(!"".equals(str2))
                        {
                        rs=stat.executeQuery("delete from groupmem where(grp_name='"+str1+"' and mem_id='"+str2+"')");
                        JOptionPane.showMessageDialog(null,"Member removed");
                        memb.removeAllItems();
                        }
                 }
                 catch (SQLException fe)
                 {
                        System.err.println("actionpermd(): SQLException: " + fe.getMessage());
                 }
                l7.setVisible(false);
                grp.setVisible(false);
                l8.setVisible(false);
                memb.setVisible(false);
                ok2.setVisible(false);
                ok3.setVisible(false);
                New.setEnabled(true);
                add.setEnabled(true);
             }
         });
        
        p3.add(l5);
        frame1.add(p1);
        frame1.add(p2);
        frame1.add(p3);
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setVisible(true);
    }
}
