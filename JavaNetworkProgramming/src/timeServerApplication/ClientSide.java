package timeServerApplication;

import java.io.IOException;
import java.net.InetSocketAddress;
//import java.net.Socket;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class ClientSide {

	public static void main(String[] args) {

		SocketAddress socketaddress = new InetSocketAddress("127.0.0.1", 5000);

		try (SocketChannel socketChannel = SocketChannel.open(socketaddress)) {
			ByteBuffer byteBuffer = ByteBuffer.allocate(64);

			int bytesRead = socketChannel.read(byteBuffer);
			while (bytesRead > 0) {
				byteBuffer.flip();
				while(byteBuffer.hasRemaining()) {
					//System.out.println((char) byteBuffer.get() + "\n");
					System.out.print((char) byteBuffer.get());
				}
				
				bytesRead = socketChannel.read(byteBuffer);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
