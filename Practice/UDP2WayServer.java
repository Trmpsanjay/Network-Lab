import java.util.*;
import java.io.*;
import java.net.*;
public class UDP2WayServer {
    public static void main(String[] args) {
        try {
            DatagramSocket ds = new DatagramSocket(6666);
            InetAddress ia = InetAddress.getLocalHost();
            byte b[] = new byte[65535];
            while(true){
                DatagramPacket dp = new DatagramPacket(b, b.length);
                ds.receive(dp);
                String input = new String(dp.getData());
                System.out.println("Client says : "+input);
                if(input.equals("end")){
                    System.out.println("exiting ....");
                    break;
                }
                Scanner sc = new Scanner(System.in);
                String output = sc.nextLine();
                byte b1[] = output.getBytes();
                DatagramPacket dp1 = new DatagramPacket(b1, b1.length,ia,dp.getPort());
                ds.send(dp1);
                if(output.equals("end")){
                    System.out.println("exiting ....");
                    break;
                }

            }
        } catch (Exception e) {
            //TODO: handle exception
            e.printStackTrace();
        }
    }
}
