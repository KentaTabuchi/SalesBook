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
public class Sales_Insert implements ISQLExecutable {

	private String name;//1
	private Long status_id;//2
	private String settle;//3
	private Long customer_id;//4
	private Long genres_id;//5
	private String invoice_status;//6
	private String memo;//7
	private String income_date;//8
	private String billing_date;//9
	private String distribute_director;
	private String distribute_sale;//10
	private String distribute_design;//11
	private String distribute_coding;//12
	private String distribute_system;//13
	private Long distribute_director_price;
	private Long distribute_sale_price;//14
	private Long distribute_design_price;//15
	private Long distribute_coding_price;//16
	private Long distribute_system_price;	//17
	
	private String created_at;
	//13項目
	public boolean isError = false;
	final String SQL = "insert into sales (name,settle,status_id,customer_id,genres_id,invoice_status,memo,income_date,"
			+ "billing_date,distribute_director,distribute_sale,distribute_design,distribute_coding,distribute_system,"
			+ "distribute_director_price,distribute_sale_price,distribute_design_price,distribute_coding_price,distribute_system_price,"
			+ "created_at) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	
	public Sales_Insert(String name,String settle,Long status_id,Long customer_id,Long genres_id,String invoice_status,
			String memo,String income_date,String billing_date,String distribute_director,String distribute_sale,String distribute_design,String distribute_coding,
			String distribute_system,Long distribute_director_price,Long distribute_sale_price,Long distribute_design_price,
			Long distribute_coding_price,Long distribute_system_price
			){		
		this.name = name;
		this.status_id = status_id;
		this.settle = settle;
		this.customer_id = customer_id;
		this.genres_id = genres_id;
		this.invoice_status = invoice_status;
		this.memo = memo;
		this.income_date = income_date;
		this.billing_date = billing_date;
		this.distribute_director = distribute_director;
		this.distribute_sale = distribute_sale;
		this.distribute_design = distribute_design;
		this.distribute_coding = distribute_coding;
		this.distribute_system = distribute_system;
		this.distribute_director_price = distribute_director_price;
		this.distribute_sale_price = distribute_sale_price;
		this.distribute_design_price = distribute_design_price;
		this.distribute_coding_price = distribute_coding_price;
		this.distribute_system_price = distribute_system_price;
		this.created_at = new TimeStamper().getNowJapanese();
	}
	@Override
	public void executeQuery(Connection con) {
			try(PreparedStatement ps = con.prepareStatement(this.SQL)){
			ps.setString(1,this.name);
			ps.setString(2, this.settle);
			ps.setLong(3,this.status_id);
			ps.setLong(4,this.customer_id);
			ps.setLong(5,this.genres_id);
			ps.setString(6,this.invoice_status);
			ps.setString(7,this.memo);
			ps.setString(8,this.income_date);
			ps.setString(9,this.billing_date);
			ps.setString(10,this.distribute_director);
			ps.setString(11,this.distribute_sale);
			ps.setString(12, this.distribute_design);
			ps.setString(13, this.distribute_coding);
			ps.setString(14, this.distribute_system);
			ps.setLong(15,this.distribute_director_price);
			ps.setLong(16,this.distribute_sale_price);
			ps.setLong(17, this.distribute_design_price);
			ps.setLong(18, this.distribute_coding_price);
			ps.setLong(19, this.distribute_system_price);
			
			ps.setString(20,this.created_at);
	
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
