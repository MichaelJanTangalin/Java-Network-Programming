package networkProgramming;

import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Collections;
import java.util.Enumeration;

public class networkAdapters {

	public static void main(String[] args) {
		// NetworkInterface.getNetworkInterfaces();
		// NetworkInterface.getByName;
		// NetworkInterface.getByInetAddress;

		try {
			Enumeration<NetworkInterface> networkIe = NetworkInterface.getNetworkInterfaces();
			System.out.println("Network Display : \n");
			
			for(NetworkInterface element : Collections.list(networkIe)) {
				System.out.printf("%-8s %-32s \n", element.getName(), element.getDisplayName());
			}
			
		} catch (SocketException e) {
			e.printStackTrace();
		}

	}
}
