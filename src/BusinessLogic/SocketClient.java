package BusinessLogic;// File Name SocketClient.java

import FunctionalClasses.Database;

import java.io.*;
import java.net.Socket;

public class SocketClient
{

   public static boolean sendOrder(int orderId)
   {
      String serverName = Database.SERVER_NAME;
      int port = 6001;

      try {
         System.out.println("Connecting to " + serverName + " on port " + port);
         Socket client = new Socket(serverName, port);

         System.out.println("Just connected to " + client.getRemoteSocketAddress());
         OutputStream outToServer = client.getOutputStream();
         DataOutputStream out = new DataOutputStream(outToServer);

         out.writeUTF(orderId + "");

         client.close();
         return true;
      }catch(IOException e) {
         e.printStackTrace();
         return false;
      }
   }

   public static void main(String [] args) {
      //String serverName = args[0];
      String serverName = "192.168.18.224";
      //int port = Integer.parseInt(args[1]);
      int port = 6001;
      
      try {
         System.out.println("Connecting to " + serverName + " on port " + port);
         Socket client = new Socket(serverName, port);
         
         System.out.println("Just connected to " + client.getRemoteSocketAddress());
         OutputStream outToServer = client.getOutputStream();
         DataOutputStream out = new DataOutputStream(outToServer);
         
         out.writeUTF("Hello from " + client.getLocalSocketAddress());
         InputStream inFromServer = client.getInputStream();
         DataInputStream in = new DataInputStream(inFromServer);
         
         System.out.println("Server says " + in.readUTF());
         client.close();
      }catch(IOException e) {
         e.printStackTrace();
         
      }
   }
}