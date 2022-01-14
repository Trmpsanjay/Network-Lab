import java.util.*;
import java.io.*;
import java.net.*;
public class UDP2WayClient{
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
	try{
		DatagramSocket ds = new DatagramSocket();
		InetAddress ip = InetAddress.getLocalHost();
		while(true){
			Scanner sc = new Scaneer(System.in);
			String str = sc.nextLine();
			byte buff = str.getBytes();
			DatagramPacket dp = new DatagramPacket(buff,buff.length,ip,666);
			ds.send(dp);
			if(str.equals("bye")){
				System.out.println("bye received exiting...");
				break;
			}
			// receiving message
			byte receivedMsg = new buff[65535];
			DatagramPacket receivedMsg = new DatagramPacket(receivedMsg,receivedMsg.length);
			ds.receive(receivedMsg);
			System.out.println("received msg : "+data(receivedMsg));

		}
	}catch(Excepton e){
		System.out.println(e);
	}
}