package createTCPServer;

import javax.sound.sampled.Port;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.sql.SQLOutput;
import java.util.Scanner;

public class ClientSide {

	private static InetAddress host;
    private static final int PORT = 1234;

    public static void main(String[] args) {

        try {
            host = InetAddress.getLocalHost();
        } catch (UnknownHostException unknownHostException) {
            System.out.println("ERROR CASUED"   + unknownHostException.getMessage());
            System.exit(1);

        }
        accessServer();

    }
    
    private static void accessServer() {
        Socket link = new Socket();             //STEP 1
        
        try {
            link = new Socket(host, PORT);    //STEP 1
            Scanner input = new Scanner(link.getInputStream());  //STEP 2

            PrintWriter output = new PrintWriter(link.getOutputStream(), true);  //STEP 2
            Scanner userEntry = new Scanner(System.in);
            String message, response;
            do {
                System.out.print("ENTER MESSAGE : ");
                message = userEntry.nextLine();
                output.println(message);            //STEP 3
                response = input.nextLine();  //STEP 3
                System.out.println("\nSERVER "   + response);

            } while (!message.equals("***CLOSE***"));

        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        finally {
            try {
                System.out.println("\nCLOSING CONNECTION...");
                link.close();                //STEP 4
            } catch (IOException ioException) {
                System.out.println("Unable to Disconnect ERROR : "   + ioException.getMessage());
                System.exit(1);
            }
        }

    }
}
