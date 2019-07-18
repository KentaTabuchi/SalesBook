/**
 * 
 */
package sql_crud;

import java.sql.Connection;
import java.sql.PreparedStatement;

import application.ISQLExecutable;

/**
 * @author misskabu
 * テキストボックスから集めたデータをtradeLogテーブルに書き込む
 */
public class Genres_UpdateById implements ISQLExecutable {

	private String name;
	private Long id;
	
	final String SQL = "update genres set name = ? where id = ?";
	
	public Genres_UpdateById(long id,String name){
		this.id = id;
		this.name = name;
	}
	@Override
	public void executeQuery(Connection con) {
		System.out.println(this.SQL);
			try(PreparedStatement ps = con.prepareStatement(this.SQL)){
			ps.setString(1,this.name);
			ps.setLong(2,this.id);
			int result = ps.executeUpdate();
				if(result!=0){
					System.out.println(result + "件の更新に成功しました。");
				}
				else{
					System.out.println("更新できませんでした。");
				}
			} catch (Exception e) {
			System.out.println("SQL failed.Please check SQL syntax or exiting Table,columnse");
			e.printStackTrace();
			}
	}
}
