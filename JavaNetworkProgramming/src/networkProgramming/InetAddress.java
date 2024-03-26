package networkProgramming;

import java.io.IOException;
import java.net.UnknownHostException;

public class InetAddress {

	public static void main(String[] args) throws UnknownHostException {

		// java.net.InetAddress names[] =
		// java.net.InetAddress.getAllByName("google.com");

		/**
		 * for (java.net.InetAddress name : names) { System.out.println(name); }
		 **/

		java.net.InetAddress myaddress = java.net.InetAddress.getByName("facebook.com");

		if (myaddress.isAnyLocalAddress()) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
		
		
		
		try {
			if (myaddress.isReachable(2)) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		java.net.InetAddress myaddress1 = java.net.InetAddress.getLoopbackAddress();
		System.out.println(myaddress1.getAddress().length);
		
		if (myaddress1.isLoopbackAddress()) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
		
	}
}
