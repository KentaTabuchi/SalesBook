/**
 * 
 */
package sql_crud;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import application.ISQLExecutable;
import model.SalesDetails;

/**
 * @author misskabu
 * TRADE_LOG TABLE から　読み出したデータを表に表示するためのSQL
 */
public class SalesDetails_FindAll implements ISQLExecutable {

	public List<SalesDetails> recordList;
	final String SQL = "select *,price * discount as final_price from sales_detail";
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
			rs = ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
			try {
				while(rs.next()){
					Long id =     rs.getLong("id");
					Long sales_id = rs.getLong("sales_id");
					String description = rs.getString("description");
					Float price = rs.getFloat("price");
					Float discount = rs.getFloat("discount");
					Float final_price = rs.getFloat("final_price");

					SalesDetails record = new SalesDetails(id,sales_id,description,price,discount,final_price);
					recordList.add(record);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

}
