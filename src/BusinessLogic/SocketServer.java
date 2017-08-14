package BusinessLogic;// File Name SocketServer.java

import FunctionalClasses.Database;

import javax.swing.*;
import java.awt.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;

public class SocketServer extends Thread {
   private ServerSocket serverSocket;
   
   public SocketServer(int port) throws IOException {
      serverSocket = new ServerSocket(port);
      //serverSocket.setSoTimeout(100000);
   }

   public void run() {
      while(true) {
         try {
            System.out.println("Waiting for client on port " + 
               serverSocket.getLocalPort() + "...");
            Socket server = serverSocket.accept();
            
            System.out.println("Just connected to " + server.getRemoteSocketAddress());
            DataInputStream in = new DataInputStream(server.getInputStream());

            Order order = Database.getOrder(Integer.parseInt(in.readUTF()));
            JFrame jFrame = new JFrame("New order");
            jFrame.setLayout(new GridLayout(order.getFoods().size(), 1));
            for (Food food:order.getFoods())
            {
               JLabel jLabel = new JLabel(food.getName());
               jFrame.add(jLabel);
            }
            jFrame.setSize(200, 400);
            jFrame.setVisible(true);


            DataOutputStream out = new DataOutputStream(server.getOutputStream());

//            String msg = "SERVER>> "+server.getOutputStream().toString();
//            out.writeChars(msg);
//            out.flush();

            out.writeUTF("Thank you for connecting to " + server.getLocalSocketAddress()
               + "\nGoodbye!");
            server.close();

         }catch(SocketTimeoutException s) {
            System.out.println("Socket timed out!");
            break;
         }catch(IOException e) {
            e.printStackTrace();
            break;
         }
      }
   }
   
   public static void main(String [] args) {
      //int port = Integer.parseInt(args[0]);
      int port = 6001;

      try {
         Thread t = new SocketServer(port);
         t.start();
      }catch(IOException e) {
         e.printStackTrace();
      }
   }
}