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
	private Long total_profit;//2
	private Long total_expense;//3
	private Long total_sale;//4
	private Long status_id;//5
	private String settle;//6
	private Long customer_id;//7
	private Long genres_id;//8
	private String invoice_status;//9
	private String memo;//10
	private String income_date;//11
	private String billing_date;//12
	private String distribute_director;//13
	private String distribute_sale;//14
	private String distribute_design;//15
	private String distribute_coding;//16
	private String distribute_system;//17
	private Long distribute_director_price;//18
	private Long distribute_sale_price;//19
	private Long distribute_design_price;//20
	private Long distribute_coding_price;//21
	private Long distribute_system_price;	//22
	
	private String created_at;
	//13項目
	public boolean isError = false;
	final String SQL = "insert into sales "
			+ "(name,total_profit,total_expense,total_sale,settle,status_id,customer_id,genres_id,invoice_status,memo,income_date,"
			+ "billing_date,distribute_director,distribute_sale,distribute_design,distribute_coding,distribute_system,"
			+ "distribute_director_price,distribute_sale_price,distribute_design_price,distribute_coding_price,distribute_system_price,"
			+ "created_at) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	
	public Sales_Insert(String name,Long total_profit,Long total_expense,Long total_sale,String settle,Long status_id,Long customer_id,Long genres_id,String invoice_status,
			String memo,String income_date,String billing_date,String distribute_director,String distribute_sale,String distribute_design,String distribute_coding,
			String distribute_system,Long distribute_director_price,Long distribute_sale_price,Long distribute_design_price,
			Long distribute_coding_price,Long distribute_system_price
			){		
		this.name = name;
		this.total_profit = total_profit;
		this.total_expense = total_expense;
		this.total_sale = total_sale;
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
			ps.setLong(2, this.total_profit);
			ps.setLong(3, this.total_expense);
			ps.setLong(4, this.total_sale);
			ps.setString(5, this.settle);
			ps.setLong(6,this.status_id);
			ps.setLong(7,this.customer_id);
			ps.setLong(8,this.genres_id);
			ps.setString(9,this.invoice_status);
			ps.setString(10,this.memo);
			ps.setString(11,this.income_date);
			ps.setString(12,this.billing_date);
			ps.setString(13,this.distribute_director);
			ps.setString(14,this.distribute_sale);
			ps.setString(15, this.distribute_design);
			ps.setString(16, this.distribute_coding);
			ps.setString(17, this.distribute_system);
			ps.setLong(18,this.distribute_director_price);
			ps.setLong(19,this.distribute_sale_price);
			ps.setLong(20, this.distribute_design_price);
			ps.setLong(21, this.distribute_coding_price);
			ps.setLong(22, this.distribute_system_price);
			
			ps.setString(23,this.created_at);
	
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
