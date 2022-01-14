import java.util.*;
import java.io.*;
import java.net.*;
public class UDPServer{
	public static StringBuilder data(byte a[]){
			if(a==null) return null;
			StringBuilder answer = new StringBuilder();
			int i=0;
			while(a[i]!=0){
				answer.append((char)a[i]);
				i++;
			}
			return answer;
		}
	public static void main(String[] args) {

		try{
			DatagramSocket ds = new DatagramSocket(1234);
			byte recivedMsg[] = new byte[65535];
			while(true){
				DatagramPacket dp = new DatagramPacket(recivedMsg,recivedMsg.length);
				ds.receive(dp);
				System.out.println("client received : "+data(recivedMsg));
				if(data(recivedMsg).toString().equals("end")){
					System.out.println("end closing connection");
					break;
				}
			}

		}
		catch(Exception e){
			System.out.println(e);
		}
	}
}