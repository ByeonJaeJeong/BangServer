package application;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

import javafx.collections.ObservableList;

public class Client extends Thread{

	BufferedReader in;
	static OutputStream out;
	
	Socket socket;
	RoomManagerController controller=new RoomManagerController();
	
	
	public Client(Socket socket) {
		connect();
		
		start();
	}
	
	public void run() {
		try{
			while(true){
				String msg = in.readLine();//msg 서버가 보낸 msg
				System.out.println(msg+"받음");
				String msgs[] =msg.split("\\|");
				String protocol=msgs[0];
				System.out.println(protocol);
				switch (protocol) {
				
				case "160": //방만들기
					System.out.println("방목록 뿌리기 실행");
					//방정보를 LIst로 뿌리기
				if(msgs.length>1){
					//개설된 방이 하나이상일때 실행
					//개설된 방 없음-->msg="160|"이였을때 에러
					controller.data.clear();
					String[] roomNames=msgs[1].split(",");
					System.out.println(roomNames);
					for(int i=0;i<roomNames.length;i++){
					String roomInwon=roomNames[i].split("--")[1]+"/8";
					String roomtitle=roomNames[i].split("--")[0];
					RoomManagerController.data.add(new Table(roomInwon, roomtitle, "대기중"));
					}
					
				}
					break;
				case "170"://대기실에서 대화방 인원정보
					String roomInwons[]=msgs[1].split(",");
					//controller.setListData(roomInwons);
					break;
				case "175"://(대화방에서) 대화방 인원정보
					String myRoomInwons[]=msgs[1].split(",");
				default:
					break;
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
		
	
	public void connect(){//소켓 서버 연결 요청
		try {
			Socket socket=new Socket("localhost", 5000);
			
			in= new BufferedReader(new InputStreamReader(socket.getInputStream()));
			//in 서버 메시지 읽기 객체 서버-->클라이언트
			out=socket.getOutputStream();
			//메시지 보내기 쓰기 객체 클라이언트->서버
			System.out.println("서버연결 성공");
			
		}catch (UnknownError e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}//connect
	
	

	
	public static void sendMsg(String msg){
		//서버에 메시지 보내기
		try{
			
			out.write((msg+"\n").getBytes());
			System.out.println("메세지 전송"+msg);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}//sendMsg
		
		
		

	
}
