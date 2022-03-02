import java.net.*;
import java.io.*;
import java.util.*;

public class TCP1WayServer{
    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(6666);
            Socket s = ss.accept();
            DataInputStream dis = new DataInputStream(s.getInputStream());
            while(true){
                String msg = dis.readUTF();
                System.out.println("Received msg from client : "+msg);
                if(msg.equals("end")){
                    System.out.println("end received exiting...");
                    break;
                }
              
            }
            ss.close();
            dis.close();
        
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}