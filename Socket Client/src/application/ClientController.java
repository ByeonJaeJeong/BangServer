package application;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

public class ClientController implements Initializable{
	Socket socket;
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		/*if(MyInfo.socketConnect){ //서버 연결
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
		}*/
		
	}
	@FXML Pane addRoomPanel;
	@FXML
	public void addRoomBtn(){
		addRoomPanel.setVisible(true);
	}
	@FXML TextField title_input;
	@FXML TextField pass_input;
	@FXML
	public void addRoomcancel(){
		title_input.setText("");
		pass_input.setText("");
		addRoomPanel.setVisible(false);
	}
	@FXML
	public void addRoom(){
		String title_pass="160|"+title_input.getText()+"|"+pass_input.getText();
		
		addRoomPanel.setVisible(false);
		title_input.setText("");
		pass_input.setText("");
		
		Main main =new Main();
		main.sendMsg(title_pass);
	}
	
	
	@FXML
	TableView<Table> Roominfo;
	
	@FXML
	private TableColumn Number;
	@FXML
	private TableColumn title;
	@FXML
	private TableColumn state;
	
	private final ObservableList<Table> data
			=FXCollections.observableArrayList();
		
	
	
	public void addTable(String[] Tables){
		Table tables=new Table(Tables[0], Tables[1], Tables[2]);
	}
	
}


