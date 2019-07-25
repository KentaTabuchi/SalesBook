package model;

import java.time.LocalDateTime;

public class SalesProspects {
	private Long id;
	private Long year;
	private Long month;
	private Long total_sales;
	private Long total_expense;
	private Long total_profit;
	private Long profit_goal;
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
	public Long getTotal_sales() {
		return total_sales;
	}
	public void setTotal_sales(Long total_sales) {
		this.total_sales = total_sales;
	}
	public Long getTotal_expense() {
		return total_expense;
	}
	public void setTotal_expense(Long total_expense) {
		this.total_expense = total_expense;
	}
	public Long getTotal_profit() {
		return total_profit;
	}
	public void setTotal_profit(Long total_profit) {
		this.total_profit = total_profit;
	}
	public Long getProfit_goal() {
		return profit_goal;
	}
	public void setProfit_goal(Long profit_goal) {
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
