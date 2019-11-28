package client;

import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class SocketChannelTimeClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SocketAddress address = new InetSocketAddress("127.0.0.1", 5000);
		try (SocketChannel socketChannel = SocketChannel.open(address)) {
			ByteBuffer byteBuffer = ByteBuffer.allocate(64);
			int bytesRead = socketChannel.read(byteBuffer);

			while (bytesRead > 0) {

				byteBuffer.flip();
				while (byteBuffer.hasRemaining()) {
					System.out.print((char) byteBuffer.get());
				}

				System.out.println();
				bytesRead = socketChannel.read(byteBuffer);

			}

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
