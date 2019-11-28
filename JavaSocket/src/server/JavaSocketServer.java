package server;

import java.io.*;
import java.net.*;

public class JavaSocketServer {

	public static void main(String[] args) {
		try{
			
			int portNumber = 5001;
			
			//���� ������ �����ϱ� ���� serverScoket ��ü ����
			System.out.println("Strart Java Sock SERVER...");
			ServerSocket aServerSocket = new ServerSocket(portNumber);
			System.out.println("Listen port "+portNumber+"...");
			
			while(true){ //Ŭ�� ���� ���
				// Ŭ�� ����� ���� ��ü ����
				Socket sock = aServerSocket.accept();
				InetAddress clientHost = sock.getLocalAddress();
				int clientPort = sock.getPort();
				System.out.println("A client connet host : "+ clientHost+ ", port: "+clientPort);
				
				//������ �б⸦ ���� ��Ʈ�� ��ü ����� ������ �б�
				ObjectInputStream instream = new ObjectInputStream(sock.getInputStream());
				Object obj = instream.readObject();
				System.out.println("Client Message : " + obj);
				
				//������ ���⸦ ���� ��Ʈ�� ��ü ����� ������ ����
				ObjectOutputStream outstream = new ObjectOutputStream(sock.getOutputStream());
				outstream.writeObject(obj+" from Server");
				outstream.flush();
				sock.close();
			}
			
			
		}catch(Exception ex){
			ex.printStackTrace();
		}

	}

}