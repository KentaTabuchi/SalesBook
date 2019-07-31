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
	private String sales_month;
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
	private Long staff_director_id;//13
	private Long staff_sale_id;//14
	private Long staff_design_id;//15
	private Long staff_coding_id;//16
	private Long staff_system_id;//17
	private Long distribute_director_price;//18
	private Long distribute_sale_price;//19
	private Long distribute_design_price;//20
	private Long distribute_coding_price;//21
	private Long distribute_system_price;	//22
	
	private String created_at;
	//13項目
	public boolean isError = false;
	final String SQL = "insert into sales "
			+ "(name,sales_month,total_profit,total_expense,total_sale,settle,status_id,customer_id,genres_id,invoice_status,memo,income_date,"
			+ "billing_date,staff_director_id,staff_sale_id,staff_design_id,staff_coding_id,staff_system_id,"
			+ "distribute_director_price,distribute_sale_price,distribute_design_price,distribute_coding_price,distribute_system_price,"
			+ "created_at) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	
	public Sales_Insert(String name,String sales_month,Long total_profit,Long total_expense,Long total_sale,String settle,Long status_id,Long customer_id,Long genres_id,String invoice_status,
			String memo,String income_date,String billing_date,Long staff_director_id,Long staff_sale_id,Long staff_design_id,Long staff_coding_id,
			Long staff_system_id,Long distribute_director_price,Long distribute_sale_price,Long distribute_design_price,
			Long distribute_coding_price,Long distribute_system_price
			){		
		this.name = name;
		this.sales_month = sales_month;
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
		this.staff_director_id = staff_director_id != 0 ? staff_director_id : 0;
		this.staff_sale_id = staff_sale_id !=0 ? staff_sale_id : 0;
		this.staff_design_id = staff_design_id !=0 ? staff_design_id : 0;
		this.staff_coding_id = staff_coding_id !=0 ? staff_coding_id : 0;
		this.staff_system_id = staff_system_id !=0 ? staff_system_id : 0;
	
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
			ps.setString(2, this.sales_month);
			ps.setLong(3, this.total_profit);
			ps.setLong(4, this.total_expense);
			ps.setLong(5, this.total_sale);
			ps.setString(6, this.settle);
			ps.setLong(7,this.status_id);
			ps.setLong(8,this.customer_id);
			ps.setLong(9,this.genres_id);
			ps.setString(10,this.invoice_status);
			ps.setString(11,this.memo);
			ps.setString(12,this.income_date);
			ps.setString(13,"廃止");
			ps.setLong(14,this.staff_director_id);
			ps.setLong(15,this.staff_sale_id);
			ps.setLong(16, this.staff_design_id);
			ps.setLong(17, this.staff_coding_id);
			ps.setLong(18, this.staff_system_id);
			ps.setLong(19,this.distribute_director_price);
			ps.setLong(20,this.distribute_sale_price);
			ps.setLong(21, this.distribute_design_price);
			ps.setLong(22, this.distribute_coding_price);
			ps.setLong(23, this.distribute_system_price);
			
			ps.setString(24,this.created_at);
	
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
