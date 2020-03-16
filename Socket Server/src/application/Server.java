package application;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Iterator;
import java.util.Vector;

public class Server implements Runnable{

	static ServerSocket serverSocket;
	Vector<Service> allV;//모든 사용자
	Vector<Service> watiV;//대기실 사용자
	Vector<Room> roomV;//개설된 대화방 사용자
	Thread thread;
	public Server(){//생성자
		//백터들 초기화
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
			
			System.out.println("서버시작");
			while(true){
				Socket socket=serverSocket.accept();
				Service ser= new Service(socket, this);
				
				System.out.println("소켓 연결 들어옴");
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
			
			//서버 소켓 닫기 
			if(serverSocket !=null && !serverSocket.isClosed()){
				serverSocket.close();
			}
			//쓰레드 풀 종료하기
			thread.stop();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
