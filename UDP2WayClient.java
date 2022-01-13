import java.io.*;
import java.net.*;
public class UDP2WayClient
{
public static void main(String a[])throws Exception
{
while(true)
{
DatagramSocket ds=new
DatagramSocket();
BufferedReader br=new
BufferedReader(new InputStreamReader(System.in));
System.out.println("Enter the Message:");
String msg=br.readLine();
byte b1[]=msg.getBytes();
InetAddress
add=InetAddress.getLocalHost();
DatagramPacket dp=new
 DatagramPacket(b1,b1.length,add,1234);
ds.send(dp);
if(msg.equals("exit"))
System.exit(0);
byte b[]=new byte[1024];
DatagramPacket dp1=new
DatagramPacket(b1,b1.length);
ds.receive(dp1);
String msg1=new String(dp1.getData());
System.out.println("Received msg:"+msg1);
}
}
}  