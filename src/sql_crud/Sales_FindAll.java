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
	"select *,customers.name as customers_name,genres.name as genres_name from sales left outer join customers on sales.customer_id = customers.id left outer join genres on sales.genres_id = genres.id";
		
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
					String settle = rs.getString("settle");
					Long status_id = rs.getLong("status_id");
					Long customer_id = rs.getLong("customer_id");
					Long genres_id = rs.getLong("genres_id");
					String invoice_status = rs.getString("invoice_status");
					String memo = rs.getString("memo");
					String income_date = rs.getString("income_date");
					String billing_date = rs.getString("billing_date");
					String distribute_director = rs.getString("distribute_director");
					String distribute_sale = rs.getString("distribute_sale");
					String distribute_design = rs.getString("distribute_design");
					String distribute_coding = rs.getString("distribute_coding");
					String distribute_system = rs.getString("distribute_system");
					Long distribute_director_price = rs.getLong("distribute_director_price");
					Long distribute_sale_price = rs.getLong("distribute_sale_price");
					Long distribute_design_price = rs.getLong("distribute_design_price");
					Long distribute_coding_price = rs.getLong("distribute_coding_price");
					Long distribute_system_price = rs.getLong("distribute_system_price");
					String created_at = rs.getString("created_at");
					String update_at = rs.getString("update_at");
					String customers_name = rs.getString("customers_name");
					String genres_name = rs.getString("genres_name");
		
					Sales record = new Sales
					(id,name,settle,status_id,customer_id,genres_id,invoice_status,memo,income_date,billing_date,
					distribute_director,distribute_sale,distribute_design,distribute_coding,distribute_system,
					distribute_director_price,distribute_sale_price,distribute_design_price,distribute_coding_price,distribute_system_price,
					created_at,update_at);
					System.out.println(customers_name);//ここまできてる
					record.setCostmers_name(customers_name);
					record.setGenres_name(genres_name);
					recordList.add(record);
					
				}
				
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

}
