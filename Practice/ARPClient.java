import java.io.*;
import java.net.*;
import java.util.*;
public class ARPClient{
    public static void main(String args[]){
        try{
           Scanner sc = new Scanner(System.in);
            Socket s=new Socket("localhost",6666);
            DataInputStream din=new DataInputStream(s.getInputStream());
            DataOutputStream dout=new DataOutputStream(s.getOutputStream());
            System.out.println("Enter the Logical address(IP):");
            String str1=sc.nextLine();
            dout.writeUTF(str1);
            String str= din.readUTF();
            System.out.println("The Physical Address is: "+str);
            s.close();
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
    
}
