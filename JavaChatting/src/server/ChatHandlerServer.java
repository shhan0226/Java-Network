package server;

import java.net.*;
import java.util.*;

public class ChatHandlerServer {

	public static void main(String args[]) throws Exception {
		if (args.length != 1) {
			throw new IllegalArgumentException("Syntax : ChatServer [��Ʈ��ȣ]");
		}
		int port = Integer.parseInt(args[0]);
		ServerSocket server = new ServerSocket(port);
		while (true) {
			Socket client = server.accept();
			ChatHandler handler = new ChatHandler(client);
			System.out.println("Client��" + client.getInetAddress().getHostAddress() + "���� �����Ͽ����ϴ�.");
			handler.start();
		}
	}

}
