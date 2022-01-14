import java.io.*;
import java.util.*;
import java.net.*;
public class TCP2WayClient{
	public static void main(String[] args) {
		try{
			Socket s=new Socket("localhost",666);  
			DataInputStream din=new DataInputStream(s.getInputStream());  
			DataOutputStream dout=new DataOutputStream(s.getOutputStream()); 
			while(true){
				Scanner sc = new Scanner(System.in);
				String str = sc.nextLine();
				dout.writeUTF(str);
				if(str.equals("end")){
					System.out.println("end occured closing connection");
					break;
				}
				//reading input
				String rcvdStr = din.readUTF();
				System.out.println("\n received msg : "+rcvdStr);
				if(rcvdStr.equals("end")){
					System.out.println("end occured closing connection");
					break;
				}
			}
		}catch(Exception e){





			System.out.println(e);
		}
	}
}