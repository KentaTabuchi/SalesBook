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
import model.SalesDetails;

/**
 * @author misskabu
 * 
 */
public class SalesDetails_FindAll implements ISQLExecutable {

	private Long sales_id;
	public List<SalesDetails> recordList;
	//final String SQL = "select * from sales_detail inner join customers on sales_detail.vendor_id = customers.id";
	final String SQL = "select * from sales_detail left outer join customers on sales_detail.vendor_id = customers.id "
			+ "where sales_detail.sales_id = ?";
	@Override
	public void executeQuery(Connection con) {
		this.recordList = new ArrayList<SalesDetails>();
		System.out.println("executeQuery");
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(this.SQL);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		ResultSet rs = null;
		try {
			ps.setLong(1, sales_id);
			rs = ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
			try {
				while(rs.next()){
					Long id =     rs.getLong("id");
					Long sales_id = rs.getLong("sales_id");
					Long vendor_id = rs.getLong("vendor_id");
					String description = rs.getString("description");
					Long price = rs.getLong("price");
					String customer_name = rs.getString("name");
					
					SalesDetails record = new SalesDetails(id,sales_id,vendor_id,description,price,customer_name);
					recordList.add(record);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	public void setSales_id(Long sales_id) {
		this.sales_id = sales_id;
	}

}
