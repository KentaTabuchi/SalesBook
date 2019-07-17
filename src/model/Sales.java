package model;

import java.time.LocalDateTime;

public class Sales {
	private Long id;
	private Integer status_id;
	private Integer type_id;
	private Integer customer_id;
	private Integer invoice_status_id;
	private LocalDateTime billing_date;
	private Float total_sale;
	private Float total_expense;
	private Float total_profit;
	private LocalDateTime created_at;
	private LocalDateTime update_at;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getStatus_id() {
		return status_id;
	}
	public void setStatus_id(Integer status_id) {
		this.status_id = status_id;
	}
	public Integer getType_id() {
		return type_id;
	}
	public void setType_id(Integer type_id) {
		this.type_id = type_id;
	}
	public Integer getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(Integer customer_id) {
		this.customer_id = customer_id;
	}
	public Integer getInvoice_status_id() {
		return invoice_status_id;
	}
	public void setInvoice_status_id(Integer invoice_status_id) {
		this.invoice_status_id = invoice_status_id;
	}
	public LocalDateTime getBilling_date() {
		return billing_date;
	}
	public void setBilling_date(LocalDateTime billing_date) {
		this.billing_date = billing_date;
	}
	public Float getTotal_sale() {
		return total_sale;
	}
	public void setTotal_sale(Float total_sale) {
		this.total_sale = total_sale;
	}
	public Float getTotal_expense() {
		return total_expense;
	}
	public void setTotal_expense(Float total_expense) {
		this.total_expense = total_expense;
	}
	public Float getTotal_profit() {
		return total_profit;
	}
	public void setTotal_profit(Float total_profit) {
		this.total_profit = total_profit;
	}
	public LocalDateTime getCreated_at() {
		return created_at;
	}
	public void setCreated_at(LocalDateTime created_at) {
		this.created_at = created_at;
	}
	public LocalDateTime getUpdate_at() {
		return update_at;
	}
	public void setUpdate_at(LocalDateTime update_at) {
		this.update_at = update_at;
	}
	
}
