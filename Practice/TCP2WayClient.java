import java.net.*;
import java.io.*;
import java.util.*;



public class TCP2WayClient {
  public static void main(String[] args) {
      try {
          Socket s = new Socket("localhost",6666);
          DataOutputStream dout = new DataOutputStream(s.getOutputStream());
          DataInputStream dis = new DataInputStream(s.getInputStream());
          Scanner sc = new Scanner(System.in);
          while(true){
              System.out.println("Enter message to send : ");
              String input = sc.nextLine();
              dout.writeUTF(input);
              if(input.equals("end")){
                  System.out.println("end received exiting ...");
                  break;
              }
              String receivedMsg = dis.readUTF();
              System.out.println("Received msg is : "+receivedMsg);
              if(receivedMsg.equals("end")){
                System.out.println("end received exiting ...");
                break;
            }
            dout.flush();
          }
          s.close();
          dout.close();
      } catch (Exception e) {
          e.printStackTrace();
      }
  }  
}
