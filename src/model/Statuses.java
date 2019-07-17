package model;

import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Statuses {

		private LongProperty id;
		private StringProperty name;

		public Statuses(Long id,String name){
			this.id = new SimpleLongProperty(id);
			this.name = new SimpleStringProperty(name);
		}
		
		public  LongProperty idProperty(){
			return id;
		}
		public StringProperty nameProperty(){
			return name;
		}

	
}
