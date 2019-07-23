/**
 * 
 */
package sql_calc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import application.ISQLExecutable;

/**
 * @author misskabu
 *
 */
public class SalesDetail_Sum_Price implements ISQLExecutable {

	public Long result;
	private Long sales_id;
	final String SQL = "select sum(price) as sum_detail from sales_detail where sales_id = ?";
	public void setSales_id(Long sales_id){
		this.sales_id = sales_id;
	}
	
	@Override
	public void executeQuery(Connection con) {
		
		System.out.println("executeQuery");
		PreparedStatement ps = null;
		try {
			
			ps = con.prepareStatement(this.SQL);
			ps.setLong(1, this.sales_id);
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
					Long sum_detail = rs.getLong("sum_detail");
					this.result = sum_detail;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

}
