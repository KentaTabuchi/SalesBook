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
import model.Customers;

/**
 * @author misskabu
 * 
 */
public class Customers_FindAll implements ISQLExecutable {

	public List<Customers> recordList;
	final String SQL = "select * from customers";
	@Override
	public void executeQuery(Connection con) {
		this.recordList = new ArrayList<Customers>();
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
					String name_kana = rs.getString("name_kana");
					String tel = rs.getString("tel");
					String address1 = rs.getString("address1");
					String address2 = rs.getString("address2");
					String address3 = rs.getString("address3");
					String zip = rs.getString("zip");
					String email = rs.getString("email");
					String person_in_charge = rs.getString("person_in_charge");
					String created_at = rs.getString("created_at");
					String update_at = rs.getString("update_at");
					System.out.println(id+name);
					Customers record = new Customers
							(id,name,name_kana,tel,address1,address2,address3,zip,email,person_in_charge,created_at,update_at);
					recordList.add(record);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

}
