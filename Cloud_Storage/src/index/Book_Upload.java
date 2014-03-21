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
 *  
 */
public class Book_Upload {
    String set1[]={"TextBook","Referance","Comics","Magazines"};
    String set2[]={"C++","Java","C","python","Networking","Others"};
    String set3[]={"English","Hindi","Telugu","Sanskrit"};
    String set4[]=set2;
    String x;
    JFrame f1=new JFrame("Upload Books");
    JLabel l1=new JLabel("Name");
    JLabel l2=new JLabel("Language");
    JLabel l3=new JLabel("Type");
    JLabel l4=new JLabel("Category");
    JLabel l5=new JLabel("Edition");
    JLabel l6=new JLabel("Browse");
    
    JTextField t1=new JTextField();
    JComboBox t2=new JComboBox(set3);
    JComboBox t3=new JComboBox(set1);
    JComboBox t4=new JComboBox(set2);
    JTextField t5=new JTextField();
    JTextField t6=new JTextField(); 
    JButton b6=new JButton("Browse");
    String ad;
    JButton bu=new JButton("Upload");
    String path1=null,path2=null,str,ex=null,name=null,ex1=null;
    String id,ss1,ss2,ss3,ss4,ss5,ss6,ss7;
    String s1="ftp://172.16.1.1/Books/";
    int il,il1,cc=0;
    Statement stat;
    ResultSet rs;
    JComboBox t7=new JComboBox();
    JLabel l7=new JLabel("Share with");
    public Book_Upload(String admin){
        ad=admin;
        Container content = f1.getContentPane();
            content.setBackground(Color.WHITE);
            f1.setIconImage(Toolkit.getDefaultToolkit().getImage("logo.jpg"));
            f1.setBounds(100,100,800,600);
            f1.setLayout(null);
            l1.setBounds(20,20,100,30);
            t1.setBounds(120,20,400,30);
            l2.setBounds(20,60,100,30);
            t2.setBounds(120,60,200,30);
            l3.setBounds(20,110,100,30);
            t3.setBounds(120,110,200,30);
            l4.setBounds(20,150,100,30);
            t4.setBounds(120,150,400,30);
            l5.setBounds(20,190,100,30);
            t5.setBounds(120,190,400,30);
            l6.setBounds(20,230,100,30);
            t6.setBounds(120,230,400,30);
            l7.setBounds(20,270,100,30);
            t7.setBounds(120,270,400,30);
            b6.setBounds(540,230,100,30);
            bu.setBounds(250,310,200,40);
            //
            connection con1=new connection();
                con1.createconnectn();
                String s;
                try
                {
                        stat = con1.con.createStatement();
                        //s=group.getText();
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
                    t7.addItem("Public");
                    while(rs.next())
                    {
                        pa=rs.getString("grp_name");
                        if(pa!=null)
                        {
                            t7.addItem(pa);
                        }
                    }
                }
                catch (SQLException fe)
                {
                    System.err.println("actionpermd(): SQLException: " + fe.getMessage());

                }
             //}
            
            
            //
            b6.addActionListener(new ActionListener(){
            @Override
             public void actionPerformed(ActionEvent e){
                JFileChooser chooser = new JFileChooser();
             chooser.showOpenDialog(null);
             File f = chooser.getSelectedFile();
             path1 = f.getPath();
             t6.setText(path1);
            }
            });
            
             bu.addActionListener(new ActionListener(){
            @Override
             public void actionPerformed(ActionEvent e){
             FTPClient f=new FTPClient();
             FTPUtils u=new FTPUtils();
                try {
                    u.ftpConnect(f,"172.16.1.1","anonymous","");
                    System.out.println("logged in");
                } catch (IOException ex) {
                    Logger.getLogger(Movies_Upload.class.getName()).log(Level.SEVERE, null, ex);
                }
                id=ad+System.currentTimeMillis();
                path1=t6.getText();
                if(!"".equals(path1))
                {  
                    cc=0;
                    for(il=path1.length()-1;il>=0;il--)
                    {
                        if(path1.charAt(il)=='.')
                        break;
                    }
                    ex=path1.substring(il,path1.length());
                }
                else
                {
                 JOptionPane.showMessageDialog(null,"Select file");
                 cc=1;
                }
                name=t1.getText();
                if("".equals(name))
                {
                    cc=1;
                    JOptionPane.showMessageDialog(null,"Enter file Name");
                }
                try {
                    if(cc!=1)
                    {
                     u.uploadFile(f,path1,s1,id+ex);
                     JOptionPane.showMessageDialog(null,"File Uploaded");
                    }
                } catch (IOException ex) {
                    Logger.getLogger(Movies_Upload.class.getName()).log(Level.SEVERE, null, ex);
                }
                connection con1=new connection();
                con1.createconnectn();
                try
                {
                        
                        stat = con1.con.createStatement();
                        ss1=t1.getText();
                        ss2=(String)t2.getSelectedItem();
                        ss3=(String)t3.getSelectedItem();
                        ss4=(String)t4.getSelectedItem();
                        ss5=t5.getText();
                        ss6=s1+id+ex;
                        ss7=(String)t7.getSelectedItem();
                        if(cc!=1)
                        rs=stat.executeQuery("insert into Books values('"+id+"','"+ss1+"','"+ss2+"','"+ss3+"','"+ss4+"','"+ss5+"','"+ss6+"','"+ss7+"')");
                 }
                 catch (SQLException fe)
                 {
                        System.err.println("actionpermd(): SQLException: " + fe.getMessage());
                 }
                
            }
            });
             f1.add(l1);
            f1.add(l2);
            f1.add(l3);
            f1.add(l4);
            f1.add(l5);
            f1.add(l6);
            
            f1.add(t1);
            f1.add(t2);
            f1.add(t3);
            f1.add(t4);
            f1.add(t5);
            f1.add(t6);
            
            f1.add(b6);
            
            f1.add(bu);
            f1.setVisible(true);
    }
}
