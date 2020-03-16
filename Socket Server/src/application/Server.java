package application;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Iterator;
import java.util.Vector;

public class Server implements Runnable{

	static ServerSocket serverSocket;
	Vector<Service> allV;//��� �����
	Vector<Service> watiV;//���� �����
	Vector<Room> roomV;//������ ��ȭ�� �����
	Thread thread;
	public Server(){//������
		//���͵� �ʱ�ȭ
		allV =new Vector<>();
		watiV=new Vector<>();
		roomV=new Vector<>();
		
		thread=new Thread(this);
				thread.start();
	}
	
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			serverSocket= new ServerSocket(5000);
			
			System.out.println("��������");
			while(true){
				Socket socket=serverSocket.accept();
				Service ser= new Service(socket, this);
				
				System.out.println("���� ���� ����");
				//socket.close();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}//run
	public void StopServer(){
		try{
			Iterator<Service> iterator=allV.iterator();
			while(iterator.hasNext()){
				Service service=iterator.next();
				service.socket.close();
				iterator.remove();
			}
			System.out.println(serverSocket.isClosed());
			
			//���� ���� �ݱ� 
			if(serverSocket !=null && !serverSocket.isClosed()){
				serverSocket.close();
			}
			//������ Ǯ �����ϱ�
			thread.stop();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
