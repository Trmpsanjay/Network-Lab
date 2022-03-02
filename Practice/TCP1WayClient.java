import java.net.*;
import java.io.*;
import java.util.*;



public class TCP1WayClient {
  public static void main(String[] args) {
      try {
          Socket s = new Socket("localhost",6666);
          DataOutputStream dout = new DataOutputStream(s.getOutputStream());
          Scanner sc = new Scanner(System.in);
          while(true){
              System.out.println("Enter message to send : ");
              String input = sc.nextLine();
              dout.writeUTF(input);
              if(input.equals("end")){
                  System.out.println("end received exiting ...");
                  break;
              }
          }
          s.close();
          dout.close();
      } catch (Exception e) {
          e.printStackTrace();
      }
  }  
}
