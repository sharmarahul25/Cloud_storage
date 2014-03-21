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
public class Login {
    JFrame frame1=new JFrame("Login");
    JPanel p1=new JPanel();
    JLabel l1= new JLabel("Juno");
    JButton Login=new JButton("Login");
    ImageIcon i1=new ImageIcon("logo.png");
    JButton l2=new JButton(i1);
    JLabel l3=new JLabel("UserName :");
    JLabel l4=new JLabel("PassWord :");
    JPanel p3=new JPanel();
    JPanel p2=new JPanel();
    JTextField username = new JTextField(20);
    JPasswordField password = new JPasswordField(20);
    JLabel l5=new JLabel("Cloud Storage Client - Indian Institute of Information Technology,Allahabad");
    Statement stat;
    ResultSet rs;
    String s;
    public Login()
    {
            
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
            l2.setBounds(10,1,100,100);
            l1.setBounds(160,1,600,100);
            l1.setFont(new Font("Verdana", Font.BOLD, 58));
            l1.setForeground(Color.DARK_GRAY);
            l3.setFont(new Font("Verdana", Font.ROMAN_BASELINE, 18));
            l3.setForeground(Color.BLUE);
            l3.setBounds(10,0,600,100);
            l4.setFont(new Font("Verdana", Font.ROMAN_BASELINE, 18));
            l4.setForeground(Color.BLUE);
            l4.setBounds(10,80,600,100);
            Login.setBounds(95,230,100,40);
            p2.add(password);
            p1.add(l1);
            p1.add(l2);
            p3.add(l5);
            p2.add(username);
            p2.add(l3);
            p2.add(l4);
            p2.add(Login);
            p2.setLayout(null);
            username.setBounds(20,80,250,30);
            password.setBounds(20,160,250,30);
            p2.setBackground(Color.white);
            p2.setBounds(275,150,300,300);
            p2.setBorder(BorderFactory.createLineBorder(Color.black));
            p3.setBounds(0,530,900,40);
            p3.setBackground(Color.white);
            frame1.add(p1);
            frame1.add(p3);
            frame1.add(p2);
            Login.addActionListener(new ActionListener(){
            @Override
             public void actionPerformed(ActionEvent e){
                connection con1=new connection();
                con1.createconnectn();
                String pass;
                try
                {
                        stat = con1.con.createStatement();
                        s=username.getText();
                        pass=password.getText();
                        rs=stat.executeQuery("select * from login where(user_id='"+s+"'and pass='"+pass+"')");
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
                    if(c==1)
                    {
                        Index I=new Index(s);
                        frame1.setVisible(false);
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null,"Invalid username or password ");
                    }
                }
                catch (SQLException fe)
                {
                    System.err.println("actionpermd(): SQLException: " + fe.getMessage());

                }
                 
             }
         });
            frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame1.setVisible(true);
    }
}
