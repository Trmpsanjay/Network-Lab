import java.util.*;
import java.net.*;
import java.io.*;
public class UDP1WayClient {
   public static void main(String[] args) {
    try {
        DatagramSocket ds = new DatagramSocket();
        InetAddress ia = InetAddress.getLocalHost();
        Scanner sc = new Scanner(System.in);
        while(true){
            String input = sc.nextLine();
            byte b[] = input.getBytes();
            DatagramPacket dp = new DatagramPacket(b, b.length,ia,6666);
            ds.send(dp);
            if(input.equals("end")){
                System.out.println("end got exiting..");
                break;
            }
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
   }
}
