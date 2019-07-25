package model;

import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Sales {
	//--------------------------------------------
	//  sales table has these columns itself.
	//--------------------------------------------
	private LongProperty id;
	private StringProperty name;
	private StringProperty settle;
	private LongProperty status_id;
	private LongProperty customer_id;
	private LongProperty genres_id;
	private StringProperty invoice_status;
	private StringProperty memo;
	private StringProperty income_date;
	private StringProperty billing_date;
	private StringProperty distribute_director;
	private StringProperty distribute_sale;
	private StringProperty distribute_design;
	private StringProperty distribute_coding;
	private StringProperty distribute_system;
	private LongProperty distribute_director_price;
	private LongProperty distribute_sale_price;
	private LongProperty distribute_design_price;
	private LongProperty distribute_coding_price;
	private LongProperty distribute_system_price;
	private StringProperty created_at;
	private StringProperty update_at;
	//--------------------------------------------
	//  Join from other table.
	//--------------------------------------------
	private StringProperty customers_name;
	private StringProperty genres_name;
	
	
	public Sales(Long id,String name,String settle,Long status_id,Long customer_id,Long genres_id,String invoice_status,
			String memo,String income_date,String billing_date,String distribute_director,String distribute_sale,
			String distribute_design,String distribute_coding,String distribute_system,
			Long distribute_director_price,Long distribute_sale_price,Long distribute_design_price,Long distribute_coding_price,
			Long distribute_system_price,String created_at,String update_at){
		
		this.id = new SimpleLongProperty(id);
		this.name = new SimpleStringProperty(name);
		this.settle = new SimpleStringProperty(settle);
		this.status_id = new SimpleLongProperty(status_id);
		this.customer_id = new SimpleLongProperty(customer_id);
		this.genres_id = new SimpleLongProperty(genres_id);
		this.invoice_status = new SimpleStringProperty(invoice_status);
		this.memo = new SimpleStringProperty(memo);
		this.income_date = new SimpleStringProperty(income_date);
		this.billing_date = new SimpleStringProperty(billing_date);
		this.distribute_sale = new SimpleStringProperty(distribute_director);
		this.distribute_sale = new SimpleStringProperty(distribute_sale);
		this.distribute_design = new SimpleStringProperty(distribute_design);
		this.distribute_coding = new SimpleStringProperty(distribute_coding);
		this.distribute_system = new SimpleStringProperty(distribute_system);
		this.distribute_director_price = new SimpleLongProperty(distribute_director_price);
		this.distribute_sale_price = new SimpleLongProperty(distribute_sale_price);
		this.distribute_design_price = new SimpleLongProperty(distribute_design_price);
		this.distribute_coding_price = new SimpleLongProperty(distribute_coding_price);
		this.distribute_system_price = new SimpleLongProperty(distribute_system_price);
		this.created_at = new SimpleStringProperty(created_at);
		this.update_at = new SimpleStringProperty(update_at);
	}
	
	public LongProperty idProperty(){
		return this.id;
	}
	public StringProperty nameProperty(){
		return this.name;
	}
	public StringProperty settleProperty(){
		return this.settle;
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
	public StringProperty invoice_statusProperty(){
		return this.invoice_status;
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
	public StringProperty distribute_directorProperty(){
		return this.distribute_director;
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
	public LongProperty distribute_director_priceProperty(){
		return this.distribute_director_price;
	}	
	public LongProperty distribute_sale_priceProperty(){
		return this.distribute_sale_price;
	}
	public LongProperty distribute_design_priceProperty(){
		return this.distribute_design_price;
	}
	public LongProperty distribute_coding_priceProperty(){
		return this.distribute_coding_price;
	}
	public LongProperty distribute_system_priceProperty(){
		return this.distribute_system_price;
	}
	public StringProperty created_atProperty(){
		return this.created_at;
	}
	public StringProperty update_atProperty(){
		return this.update_at;
	}
	//----------------------------------------------------
	public StringProperty customers_nameProperty(){
		return this.customers_name;
	}
	public void setCostmers_name(String customers_name){
		this.customers_name = new SimpleStringProperty(customers_name);
	}
	public StringProperty genres_nameProperty(){
		return this.genres_name;
	}
	public void setGenres_name(String genres_name){
		this.genres_name = new SimpleStringProperty(genres_name);
	}
	
}
