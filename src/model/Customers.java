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

	public Customers
	(Long id,String name,String name_kana,String tel,String address1,String address2,String address3,String zip,
	 String email,String person_in_charge,String created_at,String update_at)
	{
		this.id = new SimpleLongProperty(id);
		this.name = new SimpleStringProperty(name);
		this.name_kana = new SimpleStringProperty(name_kana);
		this.tel = new SimpleStringProperty(tel);
		this.address1 = new SimpleStringProperty(address1);
		this.address2 = new SimpleStringProperty(address2);
		this.address3 = new SimpleStringProperty(address3);
		this.zip = new SimpleStringProperty(zip);
		this.email = new SimpleStringProperty(email);
		this.person_in_charge = new SimpleStringProperty(person_in_charge);
		this.created_at = new SimpleStringProperty(created_at);
		this.update_at = new SimpleStringProperty(update_at);
		
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
