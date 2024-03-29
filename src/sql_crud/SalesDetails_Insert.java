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
	private Long vendor_id;
	private String description;
	private Long price;
	private String billing_date;
	
	public boolean isError = false;
	final String SQL = "insert into sales_detail (sales_id,vendor_id,description,price,billing_date) VALUES(?,?,?,?,?)";
	
	public SalesDetails_Insert(Long sales_id,Long vendor_id,String description,Long price,String billing_date){		
		this.sales_id = sales_id;
		this.vendor_id = vendor_id;
		this.description = description;
		this.price = price;
		this.billing_date = billing_date;
	}
	@Override
	public void executeQuery(Connection con) {
			try(PreparedStatement ps = con.prepareStatement(this.SQL)){
			ps.setLong(1,this.sales_id);
			ps.setLong(2, this.vendor_id);
			ps.setString(3, this.description);
			ps.setFloat(4,this.price);
			ps.setString(5, this.billing_date);
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
