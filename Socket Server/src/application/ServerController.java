package application;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.paint.Stop;

public class ServerController implements Initializable{
	Server server;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	
	@FXML 
	Button ServerButton;
	public void ServerButton(ActionEvent event){
		if(ServerButton.getText().equals("시작하기")){
			StartServer();
			ServerButton.setText("종료하기");
		}else{
			StopServer();
			ServerButton.setText("시작하기");
		}
	}
	
	
	
	public void StartServer(){
		try {
			server=new Server();
		} catch (Exception e) {
			System.out.println("서버 실행 실패!");
		}
	}

	public void StopServer(){
		try {
			server.StopServer();
			System.out.println("서버소켓 종료!");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("서버소켓 종료실패");
		}
	}
	

}
