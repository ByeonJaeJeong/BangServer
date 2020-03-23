package application;

import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.TableColumn;


public class Table{
		private final SimpleStringProperty inwon;
		private final SimpleStringProperty title;
		private final SimpleStringProperty state;
		
		public Table(String inwon, String title,String state) {
			this.inwon=new SimpleStringProperty(inwon);
			this.title=new SimpleStringProperty(title);
			this.state=new SimpleStringProperty(state);
			
			
		}

		public String getInwon() {
			return inwon.get();
		}

		public String getTitle() {
			return title.get();
		}

		public String getState() {
			return state.get();
		}

		
		

		

		
		
}