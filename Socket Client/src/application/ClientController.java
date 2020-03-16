package application;

import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;

public class ClientController implements Initializable{
	Socket socket;
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		if(MyInfo.socketConnect){ //서버 연결
			final String SERVER_IP="192.168.7.21";
			final int SERVER_PORT=5000;
			
			socket=new Socket();
			try{
				socket.connect(new InetSocketAddress(SERVER_IP,SERVER_PORT));
				System.out.println("서버 연결 성공!");
				MyInfo.setConnect(true);
				MyInfo.setSocket(socket);
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}
	
}
