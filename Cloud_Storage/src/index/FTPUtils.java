/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package index;
import java.io.*;
import javax.swing.ProgressMonitorInputStream;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import java.lang.String;
/**
 *
 *  
 */
public class FTPUtils {
    public static void ftpConnect(FTPClient ftpclient, String host, String username, String password) throws IOException {
    System.out.println("FTPUtils :: Logging in FTP..");
    try{
        ftpclient.connect(host);
        if (!ftpclient.login(username, password)) {
            throw new IOException("Supplied wrong credentials to FTP Server");
        }

        if (ftpclient.getReplyCode() != 0) {
            System.out.println(ftpclient.getReplyString());
        }
    }catch(IOException ioe){
        ioe.printStackTrace();
        System.out.println("FTP Client is not able to Connect to host");
        throw new IOException("FTP Client is not able to Connect to host");
    }
    System.out.println("FTPUtils :: FTP Login Successful..");
    
}
    /**
 * disconnect to FTP server
 * 
 * @param ftpclient is Object which is having details of FTP server like IP, user name and password
 * @throws IOException throws Exception
 */
    public static void ftpDisConnect(FTPClient ftpclient) throws IOException {
    System.out.println("FTPUtils :: FTP Logging out..");
    ftpclient.logout();
    ftpclient.disconnect();
    System.out.println("FTPUtils :: FTP Disconnected Successfully..");
}
    /**
 * download's file from source path to destination path by using FTP Client.
 * 
 * @param ftpclient is Object which is having details of FTP server like IP, user name and password
 * @param sourcePath is String from where to download's file
 * @param destinationPath is String to where to download's file.
 * @return boolean true if download's with out any fail else false
 * @throws IOException will throw any problem with file system
 */
    public static boolean downloadFile(FTPClient ftpclient, String sourcePath, String destinationPath) throws IOException {
    System.out.println("FTPUtils :: RemoteFile download starts ..FTP SOURCE " + sourcePath + " DESTINATION " + destinationPath);
    FileOutputStream fos = null;
    boolean result = false;
    try{            
        ftpclient.setFileTransferMode(FTP.BINARY_FILE_TYPE);
        ftpclient.setFileType(FTP.BINARY_FILE_TYPE);
        File fDestination = new File(destinationPath);
        fos = new FileOutputStream(fDestination);
        result = ftpclient.retrieveFile(sourcePath, fos);
        if (result) {
            System.out.println("FTPUtils :: RemoteFile download Completed..FTP " + sourcePath);
        }
    }catch(IOException ioe){
        ioe.printStackTrace();
        System.out.println("FTP is not able to Download the files from host");
        throw new IOException("FTP is not able to Download the files from host");
    }finally{
        fos.close();
    }
    return result;
}
       /**
 * @param ftpclient
 * @param sourcePath
 * @param destinationPath
 * @throws IOException
 */
    public static void uploadFile(FTPClient ftpclient, String sourcePath, String destinationPath,String Filename) throws IOException {

    FileInputStream fis = null;
     //ftpclient.enterLocalPassiveMode();
    try {
        //String filename = "C:\\Users\\rsharma\\Desktop\\test\\Testing.mkv";
        BufferedInputStream bis=new BufferedInputStream(new FileInputStream(sourcePath));
        ftpclient.changeWorkingDirectory("Upload");
        System.out.println(ftpclient.getReplyString());
        ftpclient.storeFile(Filename, bis);
        System.out.println(ftpclient.getReplyString());
    }catch(IOException ioe){
        ioe.printStackTrace();
        System.out.println("FTP is not able to upload the files from host");
        throw new IOException("FTP is not able to upload the files from host");
    }

}
 
    
}
