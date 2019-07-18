/**
 * 
 */
package sql_crud;

import java.sql.Connection;
import java.sql.PreparedStatement;

import application.ISQLExecutable;
import command.TimeStamper;

/**
 * @author misskabu
 * 
 */
public class Customers_Insert implements ISQLExecutable {

	private String name;
	private String name_kana;
	private String tel;
	private String address1;
	private String address2;
	private String address3;
	private String zip;
	private String email;
	private String person_in_charge;
	private String created_at;
	
	public boolean isError = false;
	final String SQL = "insert into customers (name,name_kana,tel,address1,address2,address3,zip,email,person_in_charge,"
			+ "created_at) VALUES(?,?,?,?,?,?,?,?,?,?)";
	
	public Customers_Insert(String name,String name_kana,String tel,String address1,String address2,String address3,
			String zip,String email,String person_in_charge){		
		this.name = name;
		this.name_kana = name_kana;
		this.tel = tel;
		this.address1 = address1;
		this.address2 = address2;
		this.address3 = address3;
		this.zip = zip;
		this.email = email;
		this.person_in_charge = person_in_charge;
		this.created_at = new TimeStamper().getNowJapanese();
	}
	@Override
	public void executeQuery(Connection con) {
			try(PreparedStatement ps = con.prepareStatement(this.SQL)){
			ps.setString(1,this.name);
			ps.setString(2,this.name_kana);
			ps.setString(3,this.tel);
			ps.setString(4,this.address1);
			ps.setString(5,this.address2);
			ps.setString(6,this.address3);
			ps.setString(7,this.zip);
			ps.setString(8,this.email);
			ps.setString(9,this.person_in_charge);
			ps.setString(10,this.created_at);
	
			int result = ps.executeUpdate();
				if(result!=0){
					System.out.println(result + "件のレコード書き込みに成功しました");
				}
				else{
					System.out.println("書き込みに失敗しました");
				}
			} catch (Exception e) {
			System.out.println("SQL failed.Please check SQL syntax or exiting Table,columnse");
			e.printStackTrace();
			this.isError = true;
			}
	}
}
