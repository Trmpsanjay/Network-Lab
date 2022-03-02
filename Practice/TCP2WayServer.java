
import java.net.*;
import java.io.*;
import java.util.*;

public class TCP2WayServer{
    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(6666);
            Socket s = ss.accept();
            DataInputStream dis = new DataInputStream(s.getInputStream());
            DataOutputStream dout = new DataOutputStream(s.getOutputStream());
            Scanner sc = new Scanner(System.in);
            while(true){
                String msg = dis.readUTF();
                System.out.println("Received msg from client : "+msg);
                if(msg.equals("end")){
                    System.out.println("end received exiting...");
                    break;
                }
                System.out.println("enter message to send : ");
                String out = sc.nextLine();
                dout.writeUTF(out);
                if(out.equals("end")){
                    System.out.println("end received exiting...");
                    break;
                }
                dout.flush();
              
            }
            ss.close();
            dis.close();
        
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}