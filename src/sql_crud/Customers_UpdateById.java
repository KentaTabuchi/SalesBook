/**
 * 
 */
package sql_crud;

import java.sql.Connection;
import java.sql.PreparedStatement;

import application.ISQLExecutable;
import command.TimeStamper;
import model.Customers;

/**
 * @author misskabu
 */
public class Customers_UpdateById implements ISQLExecutable {

	private Customers customers;
	public boolean isError = false;
	final String SQL = "update customers set name = ?,name_kana = ?,tel =?,address1 = ?,address2 = ?,address3 = ?,"
			+ "zip = ?,email = ?,person_in_charge = ?,created_at = ? where id = ?";
	
	public Customers_UpdateById
	(Customers customers){
		this.customers = customers;
	}
	@Override
	public void executeQuery(Connection con) {
		System.out.println(this.SQL);
			try(PreparedStatement ps = con.prepareStatement(this.SQL)){
				ps.setString(1,this.customers.nameProperty().getValue());
				ps.setString(2,this.customers.name_kanaProperty().getValue());
				ps.setString(3,this.customers.telProperty().getValue());
				ps.setString(4,this.customers.address1Property().getValue());
				ps.setString(5,this.customers.address2Property().getValue());
				ps.setString(6,this.customers.address3Property().getValue());
				ps.setString(7,this.customers.zipProperty().getValue());
				ps.setString(8,this.customers.emailProperty().getValue());
				ps.setString(9,this.customers.person_in_chargeProperty().getValue());
				ps.setString(10,new TimeStamper().getNowJapanese());
				ps.setLong(11,this.customers.idProperty().getValue());
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
