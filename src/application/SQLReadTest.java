/**
 * 
 */
package application;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import application.ISQLExecutable;

/**
 * @author misskabu
 * TRADE_LOG TABLE から　読み出したデータを表に表示するためのSQL
 */
public class SQLReadTest implements ISQLExecutable {

	/* (非 Javadoc)
	 * @see application.ISQLExcutable#excuteQuery()
	 */
	public List<Test> recordList;
	final String SQL = "SELECT * FROM HOGE";
	@Override
	public void executeQuery(Connection con) {
		this.recordList = new ArrayList<Test>();
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
					Integer id=rs.getInt("id");
					String name=rs.getString("name");
					System.out.println(id+name);
					Test record = new Test(
							id,
							name);
					recordList.add(record);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
}
