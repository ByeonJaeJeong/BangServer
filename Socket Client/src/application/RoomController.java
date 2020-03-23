package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

public class RoomController implements Initializable{

	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		
	}
	
	public void exitRoom(ActionEvent event){
		Main main=new Main();
		main.start(main.primaryStage);
		Client.sendMsg("400|exit");
	}

}
