/**
 * 
 */
package sql_aggregate;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import application.ISQLExecutable;
import model.Aggregate;

/**
 * @author misskabu
 * 
 */
public class Aggregate_FindAll implements ISQLExecutable {

	public List<Aggregate> recordList;
	final String SQL = 
"select sum(total_sale) as sum_sales,strftime('%Y-%m',income_date) as month from sales group by month";

	@Override
	public void executeQuery(Connection con) {
		this.recordList = new ArrayList<Aggregate>();
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
					String month =  rs.getString("month"); 
					Long total_sale = rs.getLong("sum_sales"); 
					
					System.out.println("month:"+ month);
					System.out.println("total_sale:"+ total_sale);

					Aggregate record = new Aggregate();
				
					record.setYear_month(month);
					record.setSum_salesProperty(total_sale);

					recordList.add(record);
				}
				
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

}
