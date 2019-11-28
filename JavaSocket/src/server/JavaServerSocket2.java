package server;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class JavaServerSocket2 {
	public static void main(String[] args) {
		
		try {
			ServerSocket server = new ServerSocket(11001);
			System.out.println("���� ������ ����������ϴ�. ��Ʈ : 11001");
			
			while(true) {
				Socket aSocket = server.accept();
				System.out.println("Ŭ���̾�Ʈ�� �����.");
				//Ŭ���̾�Ʈ�κ��� ���� ��û ����
				
				ObjectInputStream instream = new ObjectInputStream(aSocket.getInputStream());
				Object obj = instream.readObject();
				System.out.println("���� ������ : " + obj);
				//Object �����͸� ����

				ObjectOutputStream outstream = new ObjectOutputStream(aSocket.getOutputStream());
				outstream.writeObject(obj + " from Server.");
				outstream.flush();
				System.out.println("���� ������ : " + obj + " from Server.");
				//Object �����Ϳ� ���ڿ��� �ٿ��� ����
				
				aSocket.close();
				System.out.println("���� ����.");
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
