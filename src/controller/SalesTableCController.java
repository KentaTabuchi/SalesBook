package controller;

import java.net.URL;
import java.util.ResourceBundle;

import application.SalesDao;
import command.StageGenerator;
import command.StringDoubleBinding;
import command.StringSeparator;
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
import model.Statuses;
import sql_calc.Sales_Max_Id;
import sql_crud.Customers_FindAll;
import sql_crud.Genres_FindAllById;
import sql_crud.Sales_Insert;
import sql_crud.Statuses_FindAll;

public class SalesTableCController  implements Initializable
{
	@FXML private ComboBox<String> fx_combo_settle;
	@FXML private ComboBox<String> fx_combo_genres_id;
	@FXML private ComboBox<String> fx_combo_customers_id;
	@FXML private ComboBox<String> fx_invoice_statuses;
	
	@FXML private ComboBox<String> fx_combo_staff_director;
	@FXML private ComboBox<String> fx_combo_staff_sale;
	@FXML private ComboBox<String> fx_combo_staff_design;
	@FXML private ComboBox<String> fx_combo_staff_coding;
	@FXML private ComboBox<String> fx_combo_staff_system;
	
	@FXML private ComboBox<String> fx_combo_charge_person;
	
	@FXML private DatePicker fx_picker_billing_date;
	@FXML private TextField fx_text_total_sale;
	@FXML private TextField fx_text_total_expense;
	@FXML private TextField fx_text_total_profit;
	@FXML private TextField fx_text_name;
	@FXML private TextField fx_text_memo;
	@FXML private TextField fx_text_director_price;
	@FXML private TextField fx_text_sale_price;
	@FXML private TextField fx_text_design_price;
	@FXML private TextField fx_text_coding_price;
	@FXML private TextField fx_text_system_price;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		for(Settle item:Settle.values()){
			fx_combo_settle.getItems().add(item.getValue());
		}
		for(InvoiceStatuses item:InvoiceStatuses.values()){
			fx_invoice_statuses.getItems().add(item.getValue());
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
		Statuses_FindAll sql3 = new Statuses_FindAll();
		new SalesDao(sql3);
		for(Statuses item:sql3.recordList){
			fx_combo_staff_director.getItems().add(item.idProperty().getValue()+":"+item.nameProperty().getValue());
		}
		Statuses_FindAll sql4 = new Statuses_FindAll();
		new SalesDao(sql4);
		for(Statuses item:sql4.recordList){
			fx_combo_staff_sale.getItems().add(item.idProperty().getValue()+":"+item.nameProperty().getValue());
		}
		Statuses_FindAll sql5 = new Statuses_FindAll();
		new SalesDao(sql5);
		for(Statuses item:sql5.recordList){
			fx_combo_staff_design.getItems().add(item.idProperty().getValue()+":"+item.nameProperty().getValue());
		}
		Statuses_FindAll sql6 = new Statuses_FindAll();
		new SalesDao(sql6);
		for(Statuses item:sql6.recordList){
			fx_combo_staff_coding.getItems().add(item.idProperty().getValue()+":"+item.nameProperty().getValue());
		}
		Statuses_FindAll sql7 = new Statuses_FindAll();
		new SalesDao(sql7);
		for(Statuses item:sql7.recordList){
			fx_combo_staff_system.getItems().add(item.idProperty().getValue()+":"+item.nameProperty().getValue());
		}
		Statuses_FindAll sql8 = new Statuses_FindAll();
		new SalesDao(sql8);
		for(Statuses item:sql8.recordList){
			fx_combo_charge_person.getItems().add(item.idProperty().getValue()+":"+item.nameProperty().getValue());
		}
		fx_text_total_profit.textProperty().bind(Bindings.subtract(
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
		System.out.println(Long.valueOf(fx_text_sale_price.getText()));
		Sales_Insert sql = new Sales_Insert
		(
				fx_text_name.getText(), //name
				Long.valueOf(new StringSeparator().getFoward(fx_text_total_profit.getText(),'.')),
				Long.valueOf(fx_text_total_expense.getText()),
				Long.valueOf(fx_text_total_sale.getText()),
				fx_combo_settle.getValue(), // enumのSettleにDBから差し替え
				Long.valueOf(new StringSeparator().getFoward(fx_combo_charge_person.getValue(),':')),//status_id担当者
				Long.valueOf(new StringSeparator().getFoward(fx_combo_customers_id.getValue(),':')), //customer_id OK
				Long.valueOf(new StringSeparator().getFoward(fx_combo_genres_id.getValue(),':')), //genres_id 書き込み○
				fx_invoice_statuses.getValue(), //invoice_status 請求列 OK
				fx_text_memo.getText(), //memo 覚書 OK
				fx_picker_billing_date.getValue().toString(), // income_date OK
				"billing_date", // billing_date
				Long.valueOf(new StringSeparator().getFoward(fx_combo_staff_director.getValue(),':')), //staff_director_id OK
				Long.valueOf(new StringSeparator().getFoward(fx_combo_staff_sale.getValue(),':')), //staff_sale_id OK
				Long.valueOf(new StringSeparator().getFoward(fx_combo_staff_coding.getValue(),':')), //staff_coding_id OK
				Long.valueOf(new StringSeparator().getFoward(fx_combo_staff_design.getValue(),':')), //staff_design_id OK
				Long.valueOf(new StringSeparator().getFoward(fx_combo_staff_system.getValue(),':')), //staff_system_id OK
				Long.valueOf(fx_text_director_price.getText()),   //distribute_system OK
				Long.valueOf(fx_text_sale_price.getText()), //distribute_sale_price OK
				Long.valueOf(fx_text_design_price.getText()),  //distribute_coding_price OK
				Long.valueOf(fx_text_coding_price.getText()),  //distribute_design OK
				Long.valueOf(fx_text_system_price.getText())   //distribute_system OK
				);
		
//		public Sales_Insert(String name,String settle,Long status_id,Long customer_id,Long genres_id,String invoice_status,
//				String memo,String income_date,String billing_date,String distribute_sale,String distribute_design,String distribute_coding,
//				String distribute_system,Long distribute_sale_price,Long distribute_design_price,
//				Long distribute_coding_price,Long distribute_system_price
//				){	

		new SalesDao(sql);
		
	}
	
}
