/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcprealtimeapp;
import java.io.*;
import java.net.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;


/**
 *
 * @author Ian Kings
 */
public class TCPRealtimeapp {

    private static ServerSocket welcomeSocket = null;    
    private static Socket connectionSocket;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Client cl= new Client();
        Server svr= new Server();
        
        
       
         
        try{
        welcomeSocket = new ServerSocket(2056);
        }
        catch(IOException e){
            System.out.println(e);
        }
        
        cl.setVisible(true);
        svr.setVisible(true);
        
        
    }
    
    protected static void shtuaServer(){
        Server sv=new Server(); 
         String receivedMessage=null;
               
          try{  
          connectionSocket = welcomeSocket.accept();
          
          BufferedReader incomingMessage= new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
          
          //DataOutputStream messageToclient= new DataOutputStream(connectionSocket.getOutputStream());
          
          receivedMessage= incomingMessage.readLine();
            
          }
          
          catch(IOException e)
          {
              System.out.println(e);
          }
       
        sv.angushaKwaDatabase(receivedMessage);
       System.out.println(receivedMessage);
        
        
    }
    
    


    
}
