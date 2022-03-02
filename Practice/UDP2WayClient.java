import java.util.*;
import java.net.*;
import java.io.*;
public class UDP2WayClient {
    public static void main(String[] args) {
        try {
            DatagramSocket ds = new DatagramSocket();
            InetAddress ia = InetAddress.getLocalHost();
            while(true){
                System.out.println("enter msg to send : ");
                Scanner sc = new Scanner(System.in);
                String output = sc.nextLine();
                byte b1[] = output.getBytes();
                DatagramPacket dp1 = new DatagramPacket(b1, b1.length,ia,6666);
                ds.send(dp1);
                if(output.equals("end")){
                    System.out.println("exiting...");
                    break;
                }

                // for receiving
                byte b2[] = new byte[65235];
                DatagramPacket dp2 = new DatagramPacket(b2, b2.length);
                ds.receive(dp2);
                String input = new String(dp2.getData());
                System.out.println("Server says : "+input);
                if(input.equals("end")){
                    System.out.println("exiting...");
                    break;
                }

            }
        } catch (Exception e) {
            //TODO: handle exception
            e.printStackTrace();
        }
    }
}
