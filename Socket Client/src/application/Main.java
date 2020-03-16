package application;
	
import java.awt.SecondaryLoop;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Vector;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	
	//소켓 입출력 객체
	BufferedReader in;
	OutputStream out;
	
	String selectRoom;

	
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("BangRoomManager.fxml"));
			Scene scene = new Scene(root,1024,700);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			primaryStage.setTitle("Bang! 대기실");
			
			
			connect();
			sendMsg("100|");//(대기실) 접속 알림
			String nickName="새이름 입력";
			sendMsg("150|"+nickName);//대화명 전달
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void connect(){//소켓 서버 연결 요청
		try {
			Socket socket= new Socket("localhost",5000);//나중에 IP로 변경
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
	
	public void sendMsg(String msg){
		//서버에 메시지 보내기
		try{
			System.out.println(msg);
			out.write((msg+"\n").getBytes());
		}catch (Exception e) {
			e.printStackTrace();
		}
	}//sendMsg
	Runnable Thread= new Runnable() {
		ClientController controller=new ClientController();
		public void run() {
			try{
				while(true){
					String msg = in.readLine();//msg 서버가 보낸 msg
					
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
						String roomNames[]=msgs[1].split(",");
						controller.addTable(roomNames);
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
	};
	
	
	public static void main(String[] args) {
		launch(args);
	}
}
