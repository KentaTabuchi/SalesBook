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
import model.Genres;

/**
 * @author misskabu
 * 
 */
public class Genres_FindAll implements ISQLExecutable {

	/* (非 Javadoc)
	 * @see application.ISQLExcutable#excuteQuery()
	 */
	public List<Genres> recordList;
	final String SQL = "select * from genres";
	@Override
	public void executeQuery(Connection con) {
		this.recordList = new ArrayList<Genres>();
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
					Genres record = new Genres(id,name);
					recordList.add(record);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

}
