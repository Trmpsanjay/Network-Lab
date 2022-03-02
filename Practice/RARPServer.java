import java.io.*;
import java.net.*;
import java.util.*;
class RARPServer{
    public static void main(String args[]){
        try{
            DatagramSocket ds=new DatagramSocket(6666);
            while(true){
                byte[] b1=new byte[1024];
                byte[] b=new byte[1024];
                DatagramPacket dp=new DatagramPacket(b,b.length);
                ds.receive(dp);
                String str=new String(dp.getData());
                String s=str.trim();
                InetAddress addr=dp.getAddress();
                int port=dp.getPort();
                String ip[]={"165.165.80.80","165.165.79.1"};
                String mac[]={"6A:08:AA:C2","8A:BC:E3:FA"};
                for(int i=0;i<ip.length;i++){
                    if(s.equals(mac[i])){
                        b1=ip[i].getBytes();
                        DatagramPacket dp1=new DatagramPacket(b1,b1.length,addr,port);
                        ds.send(dp1);
                        break;
                    }
                }
                break;
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}
