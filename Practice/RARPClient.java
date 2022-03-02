import java.io.*;
import java.net.*;
import java.util.*;
class RARPClient{
    public static void main(String args[]){
        try{
            DatagramSocket ds=new DatagramSocket();
            InetAddress ia=InetAddress.getLocalHost();
            byte[] b1=new byte[1024];
            byte[] b=new byte[1024];
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter the Physical address (MAC):");
            String str=sc.nextLine(); 
            b1=str.getBytes();
            DatagramPacket dp=new DatagramPacket(b1,b1.length,ia,1309);
            ds.send(dp);
            DatagramPacket dp1=new DatagramPacket(b,b.length);
            ds.receive(dp1);
            String s=new String(dp1.getData()); 
            System.out.println("The Logical Address is(IP): "+s.trim());
            ds.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}
