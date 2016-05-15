import java.io.*;
import java.net.*;
import java.util.Date;
import java.util.Scanner;

class MessageServer {
  public static void main(String[] args) {
    try {
      ServerSocket server = new ServerSocket(8800);
      System.out.println("Waiting for clients to connect . . .");
      Socket client = server.accept();

      while (true)
      {
        System.out.println("Client connected.");

        Scanner in = new Scanner(client.getInputStream());
        PrintWriter out = new PrintWriter(client.getOutputStream());
        String whichMessageString = in.nextLine();
        int whichMessage = Integer.parseInt(whichMessageString);
        System.out.println("whichMessage " + whichMessage);
        
        switch(whichMessage)
        {
          case 1:out.println("You have chosen the first option");
            out.flush();
            break;
          case 2: out.println("You have chosen the second option");
            out.flush();
            break;
          case 3 : out.println("You have chosen the third option");
            out.flush();
            break;
          case 4 : out.println(); // No message should be sent out, because the user has decided to quit. 
            out.flush();
        	out.close();
        	client.close();
          break;
          default : out.println("Invalid choice");
            out.flush();
        }
      }
    }
    catch (IOException e) {
      System.err.println(e.getMessage());
    }
  }
}