import java.util.*;
import java.io.*;
import java.net.*;
public class UDPClient{
	public static void main(String[] args) {
		try{
			DatagramSocket ds = new DatagramSocket();
			InetAddress ip = InetAddress.getLocalHost();
			Scanner sc = new Scanner(System.in);
			while(true){
				String input = sc.nextLine();
				byte buff[] = input.getBytes();
				DatagramPacket dp = new DatagramPacket(buff,buff.length,ip,1234);
				ds.send(dp);
				if(input.equals("bye")){
					System.out.println("exiting bye received ...");
					break;
				}
			}
		}catch(Exception e){
			System.out.println(e);
		}
	}
}