package model;

import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class PL {
	private StringProperty month;
	private LongProperty bonus_allowance;
	private LongProperty provision_of_bonus_allowance;
	private LongProperty commuter_traffic_expenses;
	private LongProperty communication_cost;
	private LongProperty back_log;
	private LongProperty rent_fee;
	private LongProperty lease_fee;
	private LongProperty repair_costs;
	private LongProperty maintenance_fee;
	private LongProperty insurance_fee;
	private LongProperty recruiting_expenses;
	private LongProperty fees;
	private LongProperty newspaper_book_expenses;
	private LongProperty miscellaneous_expenses;

	public PL(){
	}
	
	public StringProperty monthProperty(){
		return month;
	}
	public void setMonth(String month){
		this.month = new SimpleStringProperty(month);
	}
	
	public LongProperty bonus_allowanceProperty(){
		return bonus_allowance;
	}
	public void setbonus_allowance(Long bonus_allowance){
		this.bonus_allowance = new SimpleLongProperty(bonus_allowance);
	}
	public LongProperty provision_of_bonus_allowanceProperty(){
		return provision_of_bonus_allowance;
	}
	public void setProvision_of_bonus_allowance(Long provision_of_bonus_allowance){
		this.provision_of_bonus_allowance = new SimpleLongProperty(provision_of_bonus_allowance);
	}
	
	public LongProperty commuter_traffic_expensesProperty(){
		return commuter_traffic_expenses;
	}
	public void setCommuter_traffic_expenses(Long commuter_traffic_expenses){
		this.commuter_traffic_expenses = new SimpleLongProperty(commuter_traffic_expenses);
	}
	public LongProperty communication_costProperty(){
		return communication_cost;
	}
	public void setCommunication_cost(Long communication_cost){
		this.communication_cost = new SimpleLongProperty(communication_cost);
	}
	public LongProperty back_logProperty(){
		return back_log;
	}
	public void setBack_log(Long back_log){
		this.back_log = new SimpleLongProperty(back_log);
	}
	public LongProperty rent_feeProperty(){
		return rent_fee;
	}
	public void setRent_fee(Long rent_fee){
		this.rent_fee = new SimpleLongProperty(rent_fee);
	}
	public LongProperty repair_costsProperty(){
		return repair_costs;
	}
	public void setRepair_costs(Long repair_costs){
		this.repair_costs = new SimpleLongProperty(repair_costs);
	}
	public LongProperty maintenance_feeProperty(){
		return maintenance_fee;
	}
	public void setMaintenance_fee(Long maintenance_fee){
		this.maintenance_fee = new SimpleLongProperty(maintenance_fee);
	}
	public LongProperty insurance_feeProperty(){
		return insurance_fee;
	}
	public void setInsurance_fee(Long insurance_fee){
		this.insurance_fee = new SimpleLongProperty(insurance_fee);
	}
	public LongProperty recruiting_expensesProperty(){
		return recruiting_expenses;
	}
	public void setRecruiting_expenses(Long recruiting_expenses){
		this.recruiting_expenses = new SimpleLongProperty(recruiting_expenses);
	}
	public LongProperty feesProperty(){
		return fees;
	}
	public void setFees(Long fees){
		this.fees = new SimpleLongProperty(fees);
	}
	public LongProperty newspaper_book_expensesProperty(){
		return newspaper_book_expenses;
	}
	public void setNewspaper_book_expenses(Long newspaper_book_expenses){
		this.newspaper_book_expenses = new SimpleLongProperty(newspaper_book_expenses);
	}
	public LongProperty miscellaneous_expensesProperty(){
		return miscellaneous_expenses;
	}
	public void setmiscellaneous_expenses(Long miscellaneous_expenses){
		this.miscellaneous_expenses = new SimpleLongProperty(miscellaneous_expenses);
	}
	public LongProperty lease_feeProperty(){
		return lease_fee;
	}
	public void setLease_fee(Long lease_fee){
		this.lease_fee = new SimpleLongProperty(lease_fee);
	}
	
}
