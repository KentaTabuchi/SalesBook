package model;

import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Sales {
	private LongProperty id;
	private StringProperty name;
	private LongProperty status_id;
	private LongProperty customer_id;
	private LongProperty genres_id;
	private LongProperty bills;
	private StringProperty memo;
	private StringProperty income_date;
	private StringProperty billing_date;
	private StringProperty distribute_sale;
	private StringProperty distribute_design;
	private StringProperty distribute_coding;
	private StringProperty distribute_system;
	private StringProperty created_at;
	private StringProperty update_at;

	public Sales(Long id,String name,Long status_id,Long customer_id,Long genres_id,Long bills,
			String memo,String income_date,String billing_date,String distribute_sale,
			String distribute_design,String distribute_coding,String distribute_system,
			String created_at,String update_at){
		
		this.id = new SimpleLongProperty(id);
		this.name = new SimpleStringProperty(name);
		this.status_id = new SimpleLongProperty(status_id);
		this.customer_id = new SimpleLongProperty(customer_id);
		this.genres_id = new SimpleLongProperty(genres_id);
		this.bills = new SimpleLongProperty(bills);
		this.memo = new SimpleStringProperty(memo);
		this.income_date = new SimpleStringProperty(income_date);
		this.billing_date = new SimpleStringProperty(billing_date);
		this.distribute_sale = new SimpleStringProperty(distribute_sale);
		this.distribute_design = new SimpleStringProperty(distribute_design);
		this.distribute_coding = new SimpleStringProperty(distribute_coding);
		this.distribute_system = new SimpleStringProperty(distribute_system);
		this.created_at = new SimpleStringProperty(created_at);
		this.update_at = new SimpleStringProperty(update_at);
	}
	
	public LongProperty idProperty(){
		return this.id;
	}
	public StringProperty nameProperty(){
		return this.name;
	}
	public LongProperty status_idProperty(){
		return this.status_id;
	}
	public LongProperty customer_idProperty(){
		return this.customer_id;
	}
	public LongProperty genres_idProperty(){
		return this.genres_id;
	}
	public LongProperty billsProperty(){
		return this.bills;
	}
	public StringProperty memoProperty(){
		return this.memo;
	}
	public StringProperty income_dateProperty(){
		return this.income_date;
	}
	public StringProperty billing_dateProperty(){
		return this.billing_date;
	}
	public StringProperty distribute_saleProperty(){
		return this.distribute_sale;
	}
	public StringProperty distribute_designProperty(){
		return this.distribute_design;
	}
	public StringProperty distribute_codingProperty(){
		return this.distribute_coding;
	}
	public StringProperty distribute_systemProperty(){
		return this.distribute_system;
	}
	public StringProperty created_atProperty(){
		return this.created_at;
	}
	public StringProperty update_atProperty(){
		return this.update_at;
	}
	
}
