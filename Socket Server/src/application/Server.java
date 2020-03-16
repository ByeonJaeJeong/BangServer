package application;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

public class Server implements Runnable{

	ServerSocket serverSocket;
	Vector<Service> allV;//모든 사용자
	Vector<Service> watiV;//대기실 사용자
	Vector<Room> roomV;//개설된 대화방 사용자
	
	public Server(){//생성자
		//백터들 초기화
		allV =new Vector<>();
		watiV=new Vector<>();
		roomV=new Vector<>();
		
		new Thread(this).start();
	}
	
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			serverSocket= new ServerSocket(7000);
			
			System.out.println("서버시작");
			while(true){
				Socket socket=serverSocket.accept();
				Service ser= new Service(socket, this);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		
			
		
	}//run
}
