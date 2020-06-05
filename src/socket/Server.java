package socket;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;


public class Server {

    private int port = 8081;
    private Socket socket = null;
    private ServerSocket serverSocket = null;
    private BufferedInputStream bis = null;
   
    private DataInputStream dis = null;
    private DataOutputStream dos = null;
	public PrintWriter output;
	public PrintWriter output1;
	
    
    public Server() {
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Server started on port " + serverSocket.getLocalPort() + "...");
            System.out.println("Waiting for client...");
            File f = new File("C:\\Users\\Haithem\\eclipse-workspace\\Ex7\\sys\\class\\gpio\\gpio27\\direction.txt");
            File g = new File("C:\\Users\\Haithem\\eclipse-workspace\\Ex7\\sys\\class\\gpio\\gpio27\\value.txt");
            socket = serverSocket.accept();
            System.out.println("Client " + socket.getRemoteSocketAddress() + " connected to server...");

            bis = new BufferedInputStream(socket.getInputStream());
            dis = new DataInputStream(bis);
            dos = new DataOutputStream(socket.getOutputStream());
            String vanne ="";
            while (true) {
                try { 
                    String messageFromClient = dis.readUTF();
                    switch(messageFromClient){
                      case "vanne 0 ON":
                      vanne="vanne 0 ON";
                      	  break;
                      case "vanne 1 ON":
                    	  vanne="vanne 1 ON";
                      	  break;
                      case "vanne 2 ON":
                    	  vanne="vanne 2 ON";
                      	  break;
                      case "vanne 3 ON":
                    	  vanne="vanne 3 ON";          
                      	  break;
                      case "vanne ALL ON":
                    	  vanne="vanne ALL ON";
                      	  break;
                      case "vanne 0 OFF":
                    	  vanne="vanne 0 OFF";
                      	  break;
                      case "vanne 1 OFF":
                    	  vanne="vanne 1 OFF";
                      	  break;
                      case "vanne 2 OFF":
                    	  vanne="vanne 2 OFF";
                      	  break;
                      case "vanne 3 OFF":
                    	  vanne="vanne 3 OFF";
                      	  break;
                      case "vanne ALL OFF":
                    	  vanne="vanne ALL OFF";
                      	  break;
                      case "exit" :
                    	  break;
                      default:
                    	  System.out.println("Not in the list");
                      break;
                  }
                    
                    System.out.println("Client [" + socket.getRemoteSocketAddress() + "] : " + vanne+" OK");
                    dos.writeUTF(vanne);
                    dos.flush();
                    try {
                    	
          			if(vanne =="vanne 3 ON") 
          			{ output = new PrintWriter(f);
        			output.println("out");
        			output1 = new PrintWriter(g);
        			output1.println("1");
        			output.close();
        			output1.close();}
        		}catch(IOException ex) {
        			System.out.println("Client [" + socket.getRemoteSocketAddress() + "] : " + vanne+" Error");
                    
                    }
                } catch (IOException e) {
      
                    break;
                }
            }
            dos.close();
            dis.close();
            socket.close();
            System.out.println("Client " + socket.getRemoteSocketAddress() + " disconnect from server...");
        } catch (IOException e) {
            System.out.println("Error : " + e);
        }
    }

    public static void main(String args[]) {
        Server server = new Server();
    }
}