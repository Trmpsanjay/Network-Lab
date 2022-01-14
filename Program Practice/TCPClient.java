import java.util.*;
import java.net.*;
import java.io.*;
public class TCPClient{
	public static void main(String[] args) {
		try{
		Socket s = new Socket("localhost",666);
		DataOutputStream dout = new DataOutputStream(s.getOutputStream());
		while(true){
			System.out.println("Enter message to send");
			Scanner sc = new Scanner(System.in);
			String input = sc.next();
			dout.writeUTF(input);
			if(input.equals("end")){
				System.out.println("End transferrred closing connection");
				break;
			}
			System.out.print("Message is :"+input);
		}
		s.close();
		dout.flush();
		dout.close();
	}
	catch(Exception e){
		System.out.println(e);
	}
	}
}