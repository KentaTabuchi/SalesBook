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
import model.Statuses;

/**
 * @author misskabu
 * TRADE_LOG TABLE から　読み出したデータを表に表示するためのSQL
 */
public class Statuses_FindAll implements ISQLExecutable {

	/* (非 Javadoc)
	 * @see application.ISQLExcutable#excuteQuery()
	 */
	public List<Statuses> recordList;
	final String SQL = "select * from statuses";
	@Override
	public void executeQuery(Connection con) {
		this.recordList = new ArrayList<Statuses>();
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
					System.out.println(id+name);
					Statuses record = new Statuses(id,name);
					recordList.add(record);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

}
