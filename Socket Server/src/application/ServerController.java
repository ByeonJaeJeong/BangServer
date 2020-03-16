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

	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	
	@FXML 
	Button ServerButton;
	public void ServerButton(ActionEvent event){
		if(ServerButton.getText().equals("�����ϱ�")){
			StartServer();
			ServerButton.setText("�����ϱ�");
		}else{
			StopServer();
			ServerButton.setText("�����ϱ�");
		}
	}
	
	
	ServerSocket serverSocket;
	Socket socket;
	public void StartServer(){
		try {
			new Server();
		} catch (Exception e) {
			System.out.println("���� ���� ����!");
		}
	}

	public void StopServer(){
		try {
			serverSocket.close();
			System.out.println("�������� ����!");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("�������� �������");
		}
	}
	

}
