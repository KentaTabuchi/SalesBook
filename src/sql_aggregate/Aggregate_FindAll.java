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
"select "
+ "sum(total_sale) as sum_sales,"
+ "sum(total_profit) as sum_profit,"
+ "sum(total_expense) as sum_expense,"
+ "strftime('%Y-%m',sales_month || '-01') as month "
+ "from sales "
+ "group by month";

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
					Long total_profit = rs.getLong("sum_profit");
					Long total_expense = rs.getLong("sum_expense");
					
					System.out.println("month:"+ month);
					System.out.println("total_sale:"+ total_sale);

					Aggregate record = new Aggregate();
				
					record.setYear_month(month);
					record.setSum_salesProperty(total_sale);
					record.setSum_profitProperty(total_profit);
					record.setSum_expenseProperty(total_expense);

					recordList.add(record);
				}
				
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

}
