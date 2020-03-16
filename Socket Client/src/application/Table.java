package application;

import javafx.beans.property.SimpleStringProperty;


public class Table{
		private final SimpleStringProperty number;
		private final SimpleStringProperty title;
		private final SimpleStringProperty state;
		
		public Table(String number, String title, String state) {
			this.number=new SimpleStringProperty(number);
			this.title=new SimpleStringProperty(title);
			this.state=new SimpleStringProperty(state);
			
			
		}

		public SimpleStringProperty getNumber() {
			return number;
		}

		public SimpleStringProperty getTitle() {
			return title;
		}

		public SimpleStringProperty getState() {
			return state;
		}
		
}