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
	static OutputStream out;
	
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
			
			Socket socket= new Socket("localhost",5000);//나중에 IP로 변경
			new Client(socket);
			
			Client.sendMsg("100|");//(대기실) 접속 알림
			String nickName="새이름 입력";
			Client.sendMsg("150|"+nickName);//대화명 전달
		
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	public static void main(String[] args) {
		launch(args);
	}
}
