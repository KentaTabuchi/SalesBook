package controller;

import java.net.URL;
import java.util.ResourceBundle;

import application.SalesDao;
import command.StageGenerator;
import command.StringDoubleBinding;
import enums.InvoiceStatuses;
import enums.Settle;
import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import model.Customers;
import model.Genres;
import sql_calc.Sales_Max_Id;
import sql_crud.Customers_FindAll;
import sql_crud.Customers_Insert;
import sql_crud.Genres_FindAllById;
import sql_crud.Sales_Insert;

public class SalesTableCController  implements Initializable
{
	@FXML private ComboBox<String> fx_combo_settle;
	@FXML private ComboBox<String> fx_combo_genres_id;
	@FXML private ComboBox<String> fx_combo_customers_id;
	@FXML private ComboBox<String> fx_invoice_statuses_id;
	@FXML private DatePicker fx_picker_billing_date;
	@FXML private TextField fx_text_total_sale;
	@FXML private TextField fx_text_total_expense;
	@FXML private TextField fx_text_profit;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		for(Settle item:Settle.values()){
			fx_combo_settle.getItems().add(item.getValue());
		}
		for(InvoiceStatuses item:InvoiceStatuses.values()){
			fx_invoice_statuses_id.getItems().add(item.getValue());
		}
		Genres_FindAllById sql1 = new Genres_FindAllById();
		new SalesDao(sql1);
		for(Genres item:sql1.recordList){
			fx_combo_genres_id.getItems().add(item.idProperty().getValue()+":"+item.nameProperty().getValue());
		}
		Customers_FindAll sql2 = new Customers_FindAll();
		new SalesDao(sql2);
		for(Customers item:sql2.recordList){
			fx_combo_customers_id.getItems().add(item.idProperty().getValue()+":"+item.nameProperty().getValue());
		}
		fx_text_profit.textProperty().bind(Bindings.subtract(
				new StringDoubleBinding(fx_text_total_sale.textProperty()),
				new StringDoubleBinding(fx_text_total_expense.textProperty())).asString());

	}
	@FXML
	protected void OnShowDetailButtonClick(){
		StageGenerator generator =  new StageGenerator();
		Stage stage = generator.createStage("sales_detail.fxml",new BorderPane());
		stage.setTitle("売上詳細登録");
		int index = fx_combo_customers_id.getValue().indexOf(':');
		SalesDetailCRUDController.vendor_id = fx_combo_customers_id.getValue().substring(0,index);
		SalesDetailCRUDController.vendor_name = fx_combo_customers_id.getValue().substring(index+1);
		
		Sales_Max_Id sql = new Sales_Max_Id();
		new SalesDao(sql);
		SalesDetailCRUDController.sales_id = sql.result+1;
		SalesDetailCRUDController controller = generator.fxmlLoader.getController();
		controller.setLabels();
		controller.refreshSumLabel();
		fx_text_total_expense.textProperty().bind(controller.total_pay);
	}
	@FXML
	protected void OnAddButtonClick(){
		//TODO add insert function
		System.out.println("新規売上登録:button click.");
		Sales_Insert sql = new Sales_Insert
		(
				"name", //name
				5L, //status_id
				3L, //customer_id
				6L, //genres_id
				"確定", //invoice_status 請求状況
				"memo", //memo 覚書
				"income_date", // income_date
				"billing_date", // billing_date
				"distribute_sale", //distribute_sale
				"distribute_config", //distribute_coding
				"distribute_design", //distribute_design
				"distribute_system", //distribute_system
				1000L, //distribute_sale_price
				500L,  //distribute_coding_price
				600L,  //distribute_design
				700L   //distribute_system
				);
//		ps.setString(1,this.name);
//		ps.setLong(2,this.status_id);
//		ps.setLong(3,this.customer_id);
//		ps.setLong(4,this.genres_id);
//		ps.setString(5,this.invoice_status);
//		ps.setString(6,this.memo);
//		ps.setString(7,this.income_date);
//		ps.setString(8,this.billing_date);
//		ps.setString(9,this.distribute_sale);
//		ps.setString(10, this.distribute_coding);
//		ps.setString(11, this.distribute_system);
//		ps.setString(12, this.distribute_design);
//		ps.setLong(13,this.distribute_sale_price);
//		ps.setLong(14, this.distribute_coding_price);
//		ps.setLong(15, this.distribute_system_price);
//		ps.setLong(16, this.distribute_design_price);	


		new SalesDao(sql);
		
	}
	
}
