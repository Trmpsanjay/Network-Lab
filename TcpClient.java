import java.io.*;
import java.net.*;
import java.util.*;
public class TcpClient{
	public static void main(String[] args){
		try{
			Socket s = new Socket("localhost",666);
			DataOutputStream dout = new DataOutputStream(s.getOutputStream());
			DataInputStream din = new DataInputStream(s.getInputStream());
			Scanner sc = new Scanner(System.in);
			while(true){
				System.out.println("Enter message");
				String str = sc.next();
				if(str.equals("end")){
					break;
				} 
				dout.writeUTF(str);
				
			}
			
			dout.flush();	
			dout.close();
			din.close();
			s.close();
	
		}catch(Exception e){
			System.out.println(e);

		}
	}
}