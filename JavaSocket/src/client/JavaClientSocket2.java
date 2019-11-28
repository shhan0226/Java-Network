package client;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;


public class JavaClientSocket2 {
	
	public static void main(String[] args) {

		try {
			Socket aSocket = new Socket("localhost", 11001);
			System.out.println("Ŭ���̾�Ʈ ������ ����������ϴ�. ȣ��Ʈ : localhost, ��Ʈ : 11001");
			//������ ����
			
			ObjectOutputStream outstream = new ObjectOutputStream(aSocket.getOutputStream());
			outstream.writeObject("Hello.");
			outstream.flush();
			System.out.println("���� ������ : Hello.");
			//���ڿ��� Object Ÿ������ ����
			
			ObjectInputStream instream = new ObjectInputStream(aSocket.getInputStream());
			Object obj = instream.readObject();
			System.out.println("���� ������ : " + obj);
			//Object�� ����
			
			aSocket.close();
			System.out.println("���� ����.");

		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
}