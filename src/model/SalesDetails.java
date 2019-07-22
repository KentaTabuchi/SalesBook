package model;

import javafx.beans.property.FloatProperty;
import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class SalesDetails {
	private LongProperty id;
	private LongProperty sales_id;
	private LongProperty vendor_id;
	private StringProperty description;
	private FloatProperty price;
	private StringProperty customer_name;
	public SalesDetails(Long id, Long sales_id, Long vendor_id,String description, Float price,String customer_name) {
		this.id = new SimpleLongProperty(id);
		this.sales_id = new SimpleLongProperty(sales_id);
		this.vendor_id = new SimpleLongProperty(vendor_id);
		this.description = new SimpleStringProperty(description);
		this.price = new SimpleFloatProperty(price);
		this.customer_name = new SimpleStringProperty(customer_name);
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

	public FloatProperty priceProperty() {
		return price;
	}

	public LongProperty vendor_idProperty() {
		return vendor_id;
	}
	public StringProperty customer_nameProperty(){
		return customer_name;
	}
}
