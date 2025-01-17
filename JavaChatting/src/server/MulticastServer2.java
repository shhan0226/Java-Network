package server;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Date;

public class MulticastServer2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		System.out.println("Multicast Time Server");

		DatagramSocket serverSocket = null;

		try {
			serverSocket = new DatagramSocket();

			while (true) {

				InetAddress address;
				address = InetAddress.getLocalHost();
				String dateText = address.getHostAddress();

				byte[] buffer = new byte[256];
				buffer = dateText.getBytes();

				InetAddress group = InetAddress.getByName("224.0.0.0");

				DatagramPacket packet;
				packet = new DatagramPacket(buffer, buffer.length, group, 8888);
				serverSocket.send(packet);
				System.out.println("Host Multicast Data: " + dateText);

				try {
					Thread.sleep(1000);
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		} catch (SocketException e) {
			// TODO: handle exception
		} catch (IOException ex) {
		}

	}

}
