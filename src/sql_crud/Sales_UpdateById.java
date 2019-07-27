/**
 * 
 */
package sql_crud;

import java.sql.Connection;
import java.sql.PreparedStatement;

import application.ISQLExecutable;
import command.TimeStamper;
import model.Sales;

/**
 * @author misskabu
 * 
 */
public class Sales_UpdateById implements ISQLExecutable {

	private Sales sales;
	public boolean isError = false;
	final String SQL = "update sales set "
			+ "name = ?," //1
			+ "total_profit = ?," //2
			+ "total_expense = ?," //3
			+ "total_sale = ?," //4
			+ "settle = ?," //5
			+ "status_id = ?," //6
			+ "customer_id = ?," //7
			+ "genres_id = ?," //8
			+ "invoice_status = ?," //9
			+ "memo = ?," //10
			+ "income_date = ?," //11
			+ "billing_date = ?," //12
			+ "staff_director_id = ?," //13
			+ "staff_sale_id = ?," //14
			+ "staff_design_id = ?," //15
			+ "staff_coding_id = ?," //16
			+ "staff_system_id = ?," //17
			+ "distribute_director_price = ?," //18
			+ "distribute_sale_price = ?," //19
			+ "distribute_design_price = ?," //20
			+ "distribute_coding_price = ?," //21
			+ "distribute_system_price = ?," //22
			+ "update_at = ? " //23
			+ "where id = ?"; //24

	public Sales_UpdateById(Sales sales){
		this.sales = sales;
	}
	@Override
	public void executeQuery(Connection con) {
		System.out.println(this.SQL);
			try(PreparedStatement ps = con.prepareStatement(this.SQL)){
			ps.setString(1,this.sales.nameProperty().getValue());
			ps.setLong(2,this.sales.total_profitProperty().getValue());
			ps.setLong(3, this.sales.total_expenseProperty().getValue());
			ps.setLong(4, this.sales.total_saleProperty().getValue());
			ps.setString(5, this.sales.settleProperty().getValue());
			ps.setLong(6, this.sales.status_idProperty().getValue());
			ps.setLong(7, this.sales.customer_idProperty().getValue());
			ps.setLong(8, this.sales.genres_idProperty().getValue());
			ps.setString(9, this.sales.invoice_statusProperty().getValue());
			ps.setString(10, this.sales.memoProperty().getValue());
			ps.setString(11, this.sales.income_dateProperty().getValue());
			ps.setString(12, this.sales.billing_dateProperty().getValue());
			ps.setLong(13, this.sales.staff_director_idProperty().getValue());
			ps.setLong(14, this.sales.staff_sale_idProperty().getValue());
			ps.setLong(15, this.sales.staff_design_idProperty().getValue());
			ps.setLong(16, this.sales.staff_coding_idProperty().getValue());
			ps.setLong(17, this.sales.staff_system_idProperty().getValue());
			ps.setLong(18, this.sales.distribute_design_priceProperty().getValue());
			ps.setLong(19, this.sales.distribute_sale_priceProperty().getValue());
			ps.setLong(20, this.sales.distribute_design_priceProperty().getValue());
			ps.setLong(21, this.sales.distribute_coding_priceProperty().getValue());
			ps.setLong(22, this.sales.distribute_system_priceProperty().getValue());
			ps.setString(23,new TimeStamper().getNowJapanese());
			ps.setLong(24, this.sales.idProperty().getValue());
			
			
			int result = ps.executeUpdate();
				if(result!=0){
					System.out.println(result + "件の更新に成功しました。");
				}
				else{
					System.out.println("更新できませんでした。");
				}
			} catch (Exception e) {
			System.out.println("SQL failed.Please check SQL syntax or exiting Table,columnse");
			e.printStackTrace();
			}
	}
}
