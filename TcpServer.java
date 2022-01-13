import java.io.*;
import java.net.*;
public class TcpServer{
	public static void main(String[] args){
		try{
			ServerSocket ss = new ServerSocket(666);
			Socket s = ss.accept();
			DataInputStream dis = new DataInputStream(s.getInputStream());
			while(true){
				String str = (String) dis.readUTF();
				if(str.equals("end")){
					break;
				}
				System.out.println("message "+str);
			}
			
			
			ss.close();
	
		}catch(Exception e){
			System.out.println(e);

		}
	}
}