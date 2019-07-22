/**
 * 
 */
package sql_crud;

import java.sql.Connection;
import java.sql.PreparedStatement;

import application.ISQLExecutable;

/**
 * @author misskabu
 * 
 */
public class SalesDetails_Insert implements ISQLExecutable {

	private Long sales_id;
	private String description;
	private Float price;
	private Float discount;
	public boolean isError = false;
	final String SQL = "insert into sales_detail (sales_id,description,price,discount) VALUES(?,?,?,?)";
	
	public SalesDetails_Insert(Long sales_id,String description,Float price,Float discount){		
		this.sales_id = sales_id;
		this.description = description;
		this.price = price;
		this.discount = discount;
		
	}
	@Override
	public void executeQuery(Connection con) {
			try(PreparedStatement ps = con.prepareStatement(this.SQL)){
			ps.setLong(1,this.sales_id);
			ps.setString(2, this.description);
			ps.setFloat(3,this.price);
			ps.setFloat(4, this.discount);
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
