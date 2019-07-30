/**
 * 
 */
package sql_crud;

import java.sql.Connection;
import java.sql.PreparedStatement;

import application.ISQLExecutable;
import model.PL;

/**
 * @author misskabu
 * 
 */
public class PL_Insert implements ISQLExecutable {

	private String month;
	private Long bonus_allowance;
	private Long provision_of_bonus_allowance;
	private Long commuter_traffic_expenses;
	private Long communication_cost;
	private Long back_log;
	private Long rent_fee;
	private Long lease_fee;
	private Long repair_costs;
	private Long maintenance_fee;
	private Long insurance_fee;
	private Long recruiting_expenses;
	private Long fees;
	private Long newspaper_book_expenses;
	private Long miscellaneous_expenses;
	public boolean isError = false;
	final String SQL = "insert into pl ("
			+ "month,"
			+ "bonus_allowance,"
			+ "provision_of_bonus_allowance,"
			+ "commuter_traffic_expenses,"
			+ "communication_cost,"
			+ "back_log,"
			+ "rent_fee,"
			+ "lease_fee,"
			+ "repair_costs,"
			+ "maintenance_fee,"
			+ "insurance_fee,"
			+ "recruiting_expenses,"
			+ "fees,"
			+ "newspaper_book_expenses,"
			+ "miscellaneous_expenses) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	
	public PL_Insert(PL pl){		
		this.month = pl.monthProperty().getValue();
		this.bonus_allowance = pl.bonus_allowanceProperty().getValue();
		this.provision_of_bonus_allowance = pl.provision_of_bonus_allowanceProperty().getValue();
		this.commuter_traffic_expenses = pl.commuter_traffic_expensesProperty().getValue();
		this.communication_cost = pl.communication_costProperty().getValue();
		this.back_log = pl.back_logProperty().getValue();
		this.rent_fee = pl.rent_feeProperty().getValue();
		this.lease_fee = pl.lease_feeProperty().getValue();
		this.repair_costs = pl.repair_costsProperty().getValue();
		this.maintenance_fee = pl.maintenance_feeProperty().getValue();
		this.insurance_fee = pl.insurance_feeProperty().getValue();
		this.recruiting_expenses = pl.recruiting_expensesProperty().getValue();
		this.fees = pl.feesProperty().getValue();
		this.newspaper_book_expenses = pl.newspaper_book_expensesProperty().getValue();
		this.miscellaneous_expenses = pl.miscellaneous_expensesProperty().getValue();
	}
	@Override
	public void executeQuery(Connection con) {
			try(PreparedStatement ps = con.prepareStatement(this.SQL)){
			ps.setString(1,this.month);
			ps.setLong(2, this.bonus_allowance);
			ps.setLong(3, this.provision_of_bonus_allowance);
			ps.setLong(4, this.commuter_traffic_expenses);
			ps.setLong(5, this.communication_cost);
			ps.setLong(6, this.back_log);
			ps.setLong(7, this.rent_fee);
			ps.setLong(8, this.lease_fee);
			ps.setLong(9, this.repair_costs);
			ps.setLong(10, this.maintenance_fee);
			ps.setLong(11, this.insurance_fee);
			ps.setLong(12, this.recruiting_expenses);
			ps.setLong(13, this.fees);
			ps.setLong(14, this.newspaper_book_expenses);
			ps.setLong(15, this.miscellaneous_expenses);
			
			int result = ps.executeUpdate();
				if(result!=0){
					System.out.println(result + "件のレコード書き込みに成功しました");
				}
				else{
					System.out.println("書き込みに失敗しました");
				}
			} catch (Exception e) {
			System.out.println("SQL failed.Please check SQL syntax or exiting Table,columnse");
			e.printStackTrace();
			this.isError = true;
			}
	}
}
