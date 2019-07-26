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
	private LongProperty total_profit;
	private LongProperty total_expense;
	private LongProperty total_sale;
	private StringProperty settle;
	private LongProperty status_id;
	private LongProperty customer_id;
	private LongProperty genres_id;
	private StringProperty invoice_status;
	private StringProperty memo;
	private StringProperty income_date;
	private StringProperty billing_date;
	private LongProperty staff_director_id;
	private LongProperty staff_sale_id;
	private LongProperty staff_design_id;
	private LongProperty staff_coding_id;
	private LongProperty staff_system_id;
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
	private StringProperty staff_director_name;
	private StringProperty staff_sale_name;
	private StringProperty staff_design_name;
	private StringProperty staff_coding_name;
	private StringProperty staff_system_name;
	private StringProperty charge_person;//担当者
	
	
	public Sales(Long id,String name,Long total_profit,Long total_expense,Long total_sale,String settle,Long status_id,Long customer_id,Long genres_id,String invoice_status,
			String memo,String income_date,String billing_date,Long staff_director_id,Long staff_sale_id,
			Long staff_design_id,Long staff_coding_id,Long staff_system_id,
			Long distribute_director_price,Long distribute_sale_price,Long distribute_design_price,Long distribute_coding_price,
			Long distribute_system_price,String created_at,String update_at){
		
		this.id = new SimpleLongProperty(id);
		this.name = new SimpleStringProperty(name);
		this.total_profit = new SimpleLongProperty(total_profit);
		this.total_expense = new SimpleLongProperty(total_expense);
		this.total_sale = new SimpleLongProperty(total_sale);
		this.settle = new SimpleStringProperty(settle);
		this.status_id = new SimpleLongProperty(status_id);
		this.customer_id = new SimpleLongProperty(customer_id);
		this.genres_id = new SimpleLongProperty(genres_id);
		this.invoice_status = new SimpleStringProperty(invoice_status);
		this.memo = new SimpleStringProperty(memo);
		this.income_date = new SimpleStringProperty(income_date);
		this.billing_date = new SimpleStringProperty(billing_date);
		this.staff_sale_id = new SimpleLongProperty(staff_director_id);
		this.staff_sale_id = new SimpleLongProperty(staff_sale_id);
		this.staff_design_id = new SimpleLongProperty(staff_design_id);
		this.staff_coding_id = new SimpleLongProperty(staff_coding_id);
		this.staff_system_id = new SimpleLongProperty(staff_system_id);
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
	public LongProperty total_profitProperty(){
		return this.total_profit;
	}
	public LongProperty total_expenseProperty(){
		return this.total_expense;
	}
	public LongProperty total_saleProperty(){
		return this.total_sale;
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
	public LongProperty staff_director_idProperty(){
		return this.staff_director_id;
	}
	public LongProperty staff_sale_id_saleProperty(){
		return this.staff_sale_id;
	}
	public LongProperty staff_design_idProperty(){
		return this.staff_design_id;
	}
	public LongProperty distribute_codingProperty(){
		return this.staff_coding_id;
	}
	public LongProperty distribute_systemProperty(){
		return this.staff_system_id;
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
	public StringProperty staff_director_nameProperty(){
		return this.staff_director_name;
	}
	public void setStaff_director_name(String staff_director_name){
		this.staff_director_name = new SimpleStringProperty(staff_director_name);
	}
	public StringProperty staff_sale_nameProperty(){
		return this.staff_sale_name;
	}
	public void setStaff_sale_name(String staff_sale_name){
		this.staff_sale_name = new SimpleStringProperty(staff_sale_name);
	}
	public StringProperty staff_design_nameProperty(){
		return this.staff_design_name;
	}
	public void setStaff_design_name(String staff_design_name){
		this.staff_design_name = new SimpleStringProperty(staff_design_name);
	}
	public StringProperty staff_coding_nameProperty(){
		return this.staff_coding_name;
	}
	public void setStaff_coding_name(String staff_coding_name){
		this.staff_coding_name = new SimpleStringProperty(staff_coding_name);
	}
	public StringProperty staff_system_nameProperty(){
		return this.staff_system_name;
	}
	public void setStaff_system_name(String staff_system_name){
		this.staff_system_name = new SimpleStringProperty(staff_system_name);
	}
	public StringProperty charge_personProperty(){
		return this.charge_person;
	}
	public void setCharge_person(String charge_person){
		this.charge_person = new SimpleStringProperty(charge_person);
	}
	
}
