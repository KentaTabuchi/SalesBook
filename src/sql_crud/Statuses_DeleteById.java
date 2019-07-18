/**
 * 
 */
package sql_crud;

import java.sql.Connection;
import java.sql.PreparedStatement;

import application.ISQLExecutable;

/**
 * @author misskabu
 */
public class Statuses_DeleteById implements ISQLExecutable {

	private Long id;
	final String SQL = "delete from statuses where id = ?"; 
	
	public Statuses_DeleteById(long id){
		this.id = id;
	}
	@Override
	public void executeQuery(Connection con) {
			try(PreparedStatement ps = con.prepareStatement(this.SQL)){
			ps.setLong(1,this.id);

			int result = ps.executeUpdate();
				if(result!=0){
					System.out.println(result + "件の削除に成功しました。");
				}
				else{
					System.out.println("書き込みに失敗しました");
				}
			} catch (Exception e) {
			System.out.println("SQL failed.Please check SQL syntax or exiting Table,columnse");
			e.printStackTrace();
			}
	}
}
