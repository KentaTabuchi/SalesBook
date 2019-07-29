package model;

import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Aggregate {
	private StringProperty year_month;
	private LongProperty sum_sales;
	private LongProperty sum_profit;
	private LongProperty sum_expense;

	public Aggregate(){
	}
	
	public StringProperty year_monthProperty(){
		return year_month;
	}
	public void setYear_month(String year_month){
		this.year_month = new SimpleStringProperty(year_month);
	}
	
	public LongProperty sum_salesProperty(){
		return sum_sales;
	}
	public void setSum_salesProperty(Long sum_sales){
		this.sum_sales = new SimpleLongProperty(sum_sales);
	}
	
	public LongProperty sum_profitProperty(){
		return sum_profit;
	}
	public void setSum_profitProperty(Long sum_profit){
		this.sum_profit = new SimpleLongProperty(sum_profit);
	}
	public LongProperty sum_expenseProperty(){
		return sum_expense;
	}
	public void setSum_expenseProperty(Long sum_expense){
		this.sum_expense = new SimpleLongProperty(sum_expense);
	}
	
}
