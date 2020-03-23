package application;

import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.TableColumn;


public class Table{
		private final SimpleStringProperty inwon;
		private final SimpleStringProperty title;
		private final SimpleStringProperty state;
		
		public Table(String inWon, String title,String state) {
			this.inwon=new SimpleStringProperty(inWon);
			this.title=new SimpleStringProperty(title);
			this.state=new SimpleStringProperty(state);
			
			
		}

		public SimpleStringProperty getInwon() {
			return inwon;
		}

		public SimpleStringProperty getTitle() {
			return title;
		}

		public SimpleStringProperty getState() {
			return state;
		}

		

		
		
}