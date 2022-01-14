import java.io.*;
import java.util.*;
import java.net.*;
public class TCP2WayServer{
	public static void main(String[] args) {
		try{
			ServerSocket ss = new ServerSocket(666);
			Socket s = ss.accept();
			DataInputStream din = new DataInputStream(s.getInputStream());
			DataOutputStream dout = new DataOutputStream(s.getOutputStream());
			while(true){
				String rcvdMsg = (String)din.readUTF();
				System.out.println("\nreceived message is :"+rcvdMsg);
				if(rcvdMsg.equals("end")){
					System.out.println("end occured closing connection");
					break;
				}
				Scanner sc = new Scanner(System.in);
				String tobeSent = sc.nextLine();
				dout.writeUTF(tobeSent);
			}
			ss.close();
			s.close();
		}catch(Exception e){
			System.out.println(e);
		}
	}
}