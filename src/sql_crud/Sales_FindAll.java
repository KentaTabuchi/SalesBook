/**
 * 
 */
package sql_crud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import application.ISQLExecutable;
import model.Sales;

/**
 * @author misskabu
 * 
 */
public class Sales_FindAll implements ISQLExecutable {

	public List<Sales> recordList;
	final String SQL =
	"select *,customers.name as customers_name,"
	+ "genres.name as genres_name,"
	+ "(select statuses.name  from sales left outer join statuses on sales.staff_director_id = statuses.id)as staff_director_name,"
	+ "(select statuses.name  from sales left outer join statuses on sales.staff_sale_id = statuses.id)as staff_sale_name,"
	+ "(select statuses.name from sales left outer join statuses on sales.staff_design_id = statuses.id)as staff_design_name,"
	+ "(select statuses.name  from sales left outer join statuses on sales.staff_coding_id = statuses.id)as staff_coding_name,"
	+ "(select statuses.name from sales left outer join statuses on sales.staff_system_id = statuses.id)as staff_system_name  "
	+ "from sales "
	+ "left outer join customers on sales.customer_id = customers.id "
	+ "left outer join genres on sales.genres_id = genres.id ";
		
	@Override
	public void executeQuery(Connection con) {
		this.recordList = new ArrayList<Sales>();
		System.out.println("executeQuery");
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(this.SQL);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		ResultSet rs = null;
		try {
			rs = ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
			try {
				while(rs.next()){
					Long id =     rs.getLong("id"); 
					String name = rs.getString("name"); 
					Long total_profit = rs.getLong("total_profit");
					Long total_expense = rs.getLong("total_expense");
					Long total_sale = rs.getLong("total_sale");
					String settle = rs.getString("settle");
					Long status_id = rs.getLong("status_id");
					Long customer_id = rs.getLong("customer_id");
					Long genres_id = rs.getLong("genres_id");
					String invoice_status = rs.getString("invoice_status");
					String memo = rs.getString("memo");
					String income_date = rs.getString("income_date");
					String billing_date = rs.getString("billing_date");
					Long staff_director_id = rs.getLong("staff_director_id");
					Long staff_sale_id = rs.getLong("staff_sale_id");
					Long staff_design_id = rs.getLong("staff_design_id");
					Long staff_coding_id = rs.getLong("staff_coding_id");
					Long staff_system_id = rs.getLong("staff_system_id");
					Long distribute_director_price = rs.getLong("distribute_director_price");
					Long distribute_sale_price = rs.getLong("distribute_sale_price");
					Long distribute_design_price = rs.getLong("distribute_design_price");
					Long distribute_coding_price = rs.getLong("distribute_coding_price");
					Long distribute_system_price = rs.getLong("distribute_system_price");
					String created_at = rs.getString("created_at");
					String update_at = rs.getString("update_at");
					String customers_name = rs.getString("customers_name");
					String genres_name = rs.getString("genres_name");
					String staff_director_name = rs.getString("staff_director_name");
					String staff_sale_name = rs.getString("staff_sale_name");
					String staff_design_name = rs.getString("staff_design_name");
					String staff_coding_name = rs.getString("staff_coding_name");
					String staff_system_name = rs.getString("staff_system_name");
					
		
					Sales record = new Sales
					(id,name,total_profit,total_expense,total_sale,settle,status_id,customer_id,genres_id,invoice_status,memo,income_date,billing_date,
					staff_director_id,staff_sale_id,staff_design_id,staff_coding_id,staff_system_id,
					distribute_director_price,distribute_sale_price,distribute_design_price,distribute_coding_price,distribute_system_price,
					created_at,update_at);
					System.out.println(customers_name);
					record.setCostmers_name(customers_name);
					record.setGenres_name(genres_name);
					record.setStaff_director_name(staff_director_name);
					record.setStaff_sale_name(staff_sale_name);
					record.setStaff_design_name(staff_design_name);
					record.setStaff_coding_name(staff_coding_name);
					record.setStaff_system_name(staff_system_name);
					recordList.add(record);
					
				}
				
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

}
