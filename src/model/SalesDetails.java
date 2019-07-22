package model;

public class SalesDetails {
	private Long id;
	private Long sales_id;
	private String description;
	private Float price;
	private Float discount;
	public SalesDetails(Long id, Long sales_id, String description, Float price, Float discount) {
		this.id = id;
		this.sales_id = sales_id;
		this.description = description;
		this.price = price;
		this.discount = discount;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getSales_id() {
		return sales_id;
	}
	public void setSales_id(Long sales_id) {
		this.sales_id = sales_id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
	public Float getDiscount() {
		return discount;
	}
	public void setDiscount(Float discount) {
		this.discount = discount;
	}
}
