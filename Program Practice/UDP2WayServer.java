import java.util.*;
import java.io.*;
import java.net.*;

public class UDP2WayServer{
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
		DatagramSocket = new DatagramSocket(1234);
		Inetaddress ip = InetAddress.getLocalHost();
		Scanner sc = new Scanner(System.in);
		while(true){
			// receiving
			byte buff[] = new byte[65535];
			DatagramPacket = new DatagramPacket(buff,buff.length);
			ds.receive(buff);
			Syste.out.println("received msg: "+data(buff));
			if(data(recivedMsg).toString().equals("end")){
				System.out.println("end closing connection");
				break;
			}
			// sending
			System.out.prinln("Please enter message : ");
			String input = sc.nextLine();
			byte sentMsg = input.getBytes();
			DatagramPacket sendingPacket = new DatagramPacket(sentMsg,sentMsg.length,buff,6666);
			ds.send(sendingPacket);
			if(input.equals("end")){
				System.out.println("end closing connection");
				break;
			}
		}
	}
}