package model;

import java.time.LocalDateTime;

public class SalesProspects {
	private Long id;
	private Long year;
	private Long month;
	private Float total_sales;
	private Float total_expense;
	private Float total_profit;
	private Float profit_goal;
	private LocalDateTime created_at;
	private LocalDateTime update_at;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getYear() {
		return year;
	}
	public void setYear(Long year) {
		this.year = year;
	}
	public Long getMonth() {
		return month;
	}
	public void setMonth(Long month) {
		this.month = month;
	}
	public Float getTotal_sales() {
		return total_sales;
	}
	public void setTotal_sales(Float total_sales) {
		this.total_sales = total_sales;
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
	public Float getProfit_goal() {
		return profit_goal;
	}
	public void setProfit_goal(Float profit_goal) {
		this.profit_goal = profit_goal;
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
