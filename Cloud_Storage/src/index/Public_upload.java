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
 *  GUDABALUPU
 */
public class Public_upload {
        
        JComboBox lang;
        JComboBox type;
        JFrame frame1=new JFrame("Juno-Index");
        JFrame frame2=new JFrame("Upload Movies");
        JFrame frame3=new JFrame("Upload Softwares");
        JFrame frame4=new JFrame("Upload Repository");
        JFrame frame5=new JFrame("Upload Documentaries");
        JButton browse=new JButton("Browse");
        JTextField nam=new JTextField(20);
        JTextField loc=new JTextField(200);
        JLabel la1=new JLabel("Name");
        JLabel la2=new JLabel("Language");
        JLabel so=new JLabel("Platform");
        JLabel ty=new JLabel("Type");
        JLabel sub=new JLabel("Subject");
        JPanel p1=new JPanel();
        String path;
        JLabel l1= new JLabel("Juno");
        ImageIcon i1=new ImageIcon("logo.png");
        ImageIcon i2=new ImageIcon("movie.png");
        ImageIcon i3=new ImageIcon("mus4.png");
        ImageIcon i4=new ImageIcon("lib.png");
        ImageIcon i5=new ImageIcon("soft.png");
        ImageIcon i6=new ImageIcon("docu.jpg");
        ImageIcon i7=new ImageIcon("repo.png");
        JButton l2=new JButton(i1);
        JPanel p3=new JPanel();
        JPanel p2=new JPanel();
        String ad;
        JButton logout=new JButton("Logout");
        JButton movie,music,upload,setting,software,docu,repo;
        JLabel l5=new JLabel("Cloud Storage Client - Indian Institute of Information Technology,Allahabad");
        public Public_upload(String admin){
            ad=admin;
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
            Container content = frame1.getContentPane();
            content.setBackground(Color.WHITE);
            frame1.setIconImage(Toolkit.getDefaultToolkit().getImage("logo.jpg"));
            frame1.setSize(900,600);
            frame1.setResizable(false);
            frame1.setLayout(null);
            frame1.setBackground(Color.white);
            logout.setBounds(650,30,150,40);
            p1.add(logout);
            p1.setLayout(null);
            p1.setBackground(Color.white);
            l2.setBounds(10,1,100,100);
            l1.setBounds(160,1,600,100);
            p1.setBounds(0,0,900,110);
            p1.setBorder(BorderFactory.createLineBorder(Color.black));
            movie=new JButton("cloud");
            movie.setBounds(10,120,240,190);
            movie.setIcon(i2);
        //
            movie.addActionListener(new ActionListener(){
            @Override
             public void actionPerformed(ActionEvent e){
            Movies_Upload um=new Movies_Upload(ad);
            }
            });
            
            music=new JButton("music");
            music.setBounds(280,120,240,190);
            music.setIcon(i3);
         
            setting=new JButton("setting");
            setting.setBounds(10,320,240,190);
            setting.setIcon(i4);
            setting.addActionListener(new ActionListener(){
            @Override
             public void actionPerformed(ActionEvent e){
                Book_Upload us=new Book_Upload(ad);
            }
            }); 
            software=new JButton("dropbox");
            software.setBounds(280,320,240,190);
            software.setIcon(i5);
            software.addActionListener(new ActionListener(){
            @Override
             public void actionPerformed(ActionEvent e){
                Software_Upload us=new Software_Upload(ad);
            }
            });   
            repo=new JButton("repo");
            repo.setBounds(550,320,240,190);
            repo.setIcon(i7);
            frame1.add(repo);
            docu=new JButton("docu");
            docu.setBounds(550,120,240,190);
            docu.setIcon(i6);
            docu.addActionListener(new ActionListener(){
            @Override
             public void actionPerformed(ActionEvent e){
                Docm_Upload us=new Docm_Upload(ad);
            }
            });
    // 
            repo.addActionListener(new ActionListener(){
            @Override
             public void actionPerformed(ActionEvent e){
            Repo_Upload ru=new Repo_Upload(ad);
            }
         });
      //
            frame1.add(docu);
            p1.add(l2,BorderLayout.NORTH);
            l1.setFont(new Font("Verdana", Font.BOLD, 58));
            l1.setForeground(Color.DARK_GRAY);
            p1.add(l1);
            p1.add(l2);
            p3.add(l5);
            p3.setBounds(0,530,900,40);
            p3.setBackground(Color.white);
            frame1.add(p1);
            frame1.add(p3);
            frame1.add(movie);
            frame1.add(music);
            frame1.add(setting);
            frame1.add(software);
            frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame1.setVisible(true);
        }
    
}
