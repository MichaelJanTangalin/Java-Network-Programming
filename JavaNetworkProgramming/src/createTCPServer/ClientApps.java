package createTCPServer;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ClientApps {

	public static void main(String[] args) throws IOException {
		
		//STEP 1
		ServerSocket serverSocket = new ServerSocket(1092); //1024-65535
		
		//STEP 2
		Socket link = serverSocket.accept();
		
		//STEP 3
		Scanner input = new Scanner(link.getInputStream());
		PrintWriter output = new PrintWriter(link.getOutputStream());
		
		//STEP 4
		output.println("Awaiting for Data....");
		String myinput = input.nextLine();
		
		link.close(); //STEP 5
	}

}
