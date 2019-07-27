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
public class Sales_Max_Id implements ISQLExecutable {

	public Long result;
	final String SQL = "select max(id) as max_id from sales";
	@Override
	public void executeQuery(Connection con) {
		
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
					Long max_id = rs.getLong("max_id");
					this.result = max_id;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

}
