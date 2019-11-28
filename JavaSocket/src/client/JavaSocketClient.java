package client;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.*;

public class JavaSocketClient {

	public static void main(String[] args) {
		try{
			
			int portNumber = 5001;
			
			//���� ������ ���� ���� ��ü ����
			Socket sock = new Socket("localhost", portNumber);
			
			
			//�����͸� ���� ���� ��Ʈ�� ��ü ����� ����
			ObjectOutputStream outstream = new ObjectOutputStream(sock.getOutputStream());
			outstream.writeObject("Hellow World");
			outstream.flush();
			
			//�����͸� �б� ���� ��Ƽ�� ��ü�� ����� ������ �б�
			ObjectInputStream instream = new ObjectInputStream(sock.getInputStream());			
			System.out.println(instream.readObject());	
			sock.close();
						
		}catch(Exception ex){
			ex.printStackTrace();
		}
		

	}

}