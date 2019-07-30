package model;

import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class SalesDetails {
	private LongProperty id;
	private LongProperty sales_id;
	private LongProperty vendor_id;
	private StringProperty description;
	private LongProperty price;
	private StringProperty customer_name;
	private StringProperty billing_date;
	public SalesDetails(Long id, Long sales_id, Long vendor_id,String description, Long price,String customer_name,String billing_date) {
		this.id = new SimpleLongProperty(id);
		this.sales_id = new SimpleLongProperty(sales_id);
		this.vendor_id = new SimpleLongProperty(vendor_id);
		this.description = new SimpleStringProperty(description);
		this.price = new SimpleLongProperty(price);
		this.customer_name = new SimpleStringProperty(customer_name);
		this.billing_date = new SimpleStringProperty(billing_date);
	}
	public LongProperty idProperty() {
		return id;
	}

	public LongProperty sales_idProperty() {
		return sales_id;
	}

	public StringProperty descriptionProperty() {
		return description;
	}

	public LongProperty priceProperty() {
		return price;
	}

	public LongProperty vendor_idProperty() {
		return vendor_id;
	}
	public StringProperty customer_nameProperty(){
		return customer_name;
	}
	public StringProperty billing_dateProperty(){
		return billing_date;
	}
}
