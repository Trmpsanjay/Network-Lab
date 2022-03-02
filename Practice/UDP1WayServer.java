import java.io.*;
import java.util.*;
import java.net.*;
public class UDP1WayServer {
    public static void main(String[] args) {
        
        try {
            DatagramSocket ds = new DatagramSocket(6666);
            byte receive[] = new byte[65535];
            while(true){
               DatagramPacket dp = new DatagramPacket(receive, receive.length);
               ds.receive(dp);
               String str = new String(dp.getData());
               System.out.println("Client Says : "+str);
               if(getdata(receive).toString().equals("end")){
                   System.out.println("end received exiting....");
                   break;
               }
            }
        } catch (Exception e) {
            //TODO: handle exception
            e.printStackTrace();
        }
    }
}
