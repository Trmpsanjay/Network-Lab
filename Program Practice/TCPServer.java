import java.util.*;
import java.io.*;
import java.net.*;
public class TCPServer{
	public static void main(String[] args) {
		try{
			ServerSocket ss = new ServerSocket(666);
			Socket s = ss.accept();
			DataInputStream dis = new DataInputStream(s.getInputStream());
			while(true){
				String message = dis.readUTF();
				System.out.println("Message received : "+message);
				if(message.equals("end")){
					System.out.println("end occured clossing connection");
					break;
				}
			}
			dis.close();
			ss.close();
			}
		catch(Exception e){
			System.out.println(e);
		}
		

	}
}