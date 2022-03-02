import java.io.*;
import java.net.*;
import java.util.*;
public class ARPServer{
    public static void main(String args[]){
        try{
            ServerSocket ss=new ServerSocket(6666);
            Socket s=ss.accept();
            while(true){
                DataInputStream din=new DataInputStream(s.getInputStream());
                DataOutputStream dout=new DataOutputStream(s.getOutputStream()); 
                String str = din.readUTF();
                String ip[]={"165.165.80.80","165.165.79.1"};
                String mac[]={"6A:08:AA:C2","8A:BC:E3:FA"};
                for(int i=0;i<ip.length;i++){
                    if(str.equals(ip[i])){
                        dout.writeUTF(mac[i]+'\n');
                        break;
                    }
                }
                s.close();
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}
