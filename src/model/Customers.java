package model;

import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Customers {
	private LongProperty id;
	private StringProperty name;
	private StringProperty name_kana;
	private StringProperty tel;
	private StringProperty address1;
	private StringProperty address2;
	private StringProperty address3;
	private StringProperty zip;
	private StringProperty email;
	private StringProperty person_in_charge;
	private StringProperty created_at;
	private StringProperty update_at;

	public Customers(Long id,String name){
		this.id = new SimpleLongProperty(id);
		this.name = new SimpleStringProperty(name);
	}
	
	public  LongProperty idProperty(){
		return id;
	}
	public StringProperty nameProperty(){
		return name;
	}
	public StringProperty name_kanaProperty(){
		return name_kana;
	}
	public StringProperty tesProperty(){
		return tel;
	}
	public StringProperty address1Property(){
		return address1;
	}
	public StringProperty address2Property(){
		return address2;
	}
	public StringProperty address3Property(){
		return address3;
	}
	public StringProperty zipProperty(){
		return zip;
	}
	public StringProperty emailProperty(){
		return email;
	}
	public StringProperty person_in_chargeProperty(){
		return person_in_charge;
	}
	public StringProperty created_atProperty(){
		return created_at;
	}
	public StringProperty update_atProperty(){
		return update_at;
	}
}
