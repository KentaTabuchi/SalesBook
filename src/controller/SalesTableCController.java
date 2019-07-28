package controller;

import java.net.URL;
import java.util.ResourceBundle;

import application.SalesDao;
import command.Message;
import command.StageGenerator;
import command.StringDoubleBinding;
import command.StringLongBinding;
import command.StringSeparator;
import command.TextFieldValidator;
import enums.InvoiceStatuses;
import enums.Settle;
import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import model.Customers;
import model.Genres;
import model.Statuses;
import sql_crud.Customers_FindAll;
import sql_crud.Genres_FindAll;
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
	@FXML private DatePicker fx_picker_pay_date;
	
	@FXML private TextField fx_text_total_sale;
	@FXML private TextField fx_text_total_expense;
	@FXML private TextField fx_text_total_profit;
	@FXML private TextField fx_text_name;
	@FXML private TextField fx_text_memo;
	@FXML private TextField fx_text_director_price;
	@FXML private TextField fx_text_sale_price;   //distribute
	@FXML private TextField fx_text_design_price;
	@FXML private TextField fx_text_coding_price;
	@FXML private TextField fx_text_system_price;
	@FXML private Button fx_cancel_button;
	//----------------------------------------------------
	//for carry over to SalesDetailCRUDController.java
	//----------------------------------------------------
	public static Long vendor_id;
	public static String vendor_name;
	public static TextField total_expense;
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		for(Settle item:Settle.values()){
			fx_combo_settle.getItems().add(item.getValue());
		}
		for(InvoiceStatuses item:InvoiceStatuses.values()){
			fx_invoice_statuses.getItems().add(item.getValue());
		}
		Genres_FindAll sql1 = new Genres_FindAll();
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
			fx_combo_staff_sale.getItems().add(item.idProperty().getValue()+":"+item.nameProperty().getValue());
			fx_combo_staff_design.getItems().add(item.idProperty().getValue()+":"+item.nameProperty().getValue());
			fx_combo_staff_coding.getItems().add(item.idProperty().getValue()+":"+item.nameProperty().getValue());
			fx_combo_staff_system.getItems().add(item.idProperty().getValue()+":"+item.nameProperty().getValue());
			fx_combo_charge_person.getItems().add(item.idProperty().getValue()+":"+item.nameProperty().getValue());
		}

		fx_text_total_profit.textProperty().bind(Bindings.subtract(
				new StringLongBinding(fx_text_total_sale.textProperty()),
				new StringLongBinding(fx_text_total_expense.textProperty())).asString());
		validation();	
	}

	private void validation(){
		TextFieldValidator.addNumberValidator(fx_text_total_sale);
		TextFieldValidator.addNumberValidator(fx_text_director_price);
		TextFieldValidator.addNumberValidator(fx_text_sale_price);
		TextFieldValidator.addNumberValidator(fx_text_design_price);
		TextFieldValidator.addNumberValidator(fx_text_coding_price);
		TextFieldValidator.addNumberValidator(fx_text_system_price);
	}
	@FXML
	protected void OnShowDetailButtonClick(){
		
		try{
		total_expense = this.fx_text_total_expense;
		vendor_id = Long.valueOf(new StringSeparator().getFoward(fx_combo_customers_id.getValue(), ':'));
		vendor_name = new StringSeparator().getBack(fx_combo_customers_id.getValue(), ':');
		StageGenerator generator =  new StageGenerator();
		generator.createStage("sales_detail.fxml",new BorderPane());
		}catch(NullPointerException e){
			new Message().showAlert("例外の検出","記述漏れ","この先に進むには顧客情報の選択が必要です。");
		}
	
	}
	@FXML
	protected void OnAddButtonClick(){

		try{
		Sales_Insert sql = new Sales_Insert
		(
				fx_text_name.getText(), //name
				Long.valueOf(fx_text_total_profit.getText()), 
				
				Long.valueOf(fx_text_total_expense.getText()), //OK
				Long.valueOf(fx_text_total_sale.getText()), //OK
				fx_combo_settle.getValue(), //  OK
				Long.valueOf(new StringSeparator().getFoward(fx_combo_charge_person.getValue(),':')),//status_id担当者 OK
				Long.valueOf(new StringSeparator().getFoward(fx_combo_customers_id.getValue(),':')), //customer_id OK
				Long.valueOf(new StringSeparator().getFoward(fx_combo_genres_id.getValue(),':')), //genres_id OK
				fx_invoice_statuses.getValue(), //invoice_status 請求列 OK
				fx_text_memo.getText(), //memo 覚書 OK
				fx_picker_billing_date.getValue().toString(), // income_date OK
				fx_picker_pay_date.getValue().toString(), // billing_date
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

		new SalesDao(sql);
		new Message().showAlert("処理の完了", "書き込み成功", "DBに登録しました。");
		}catch(Exception e){
			new Message().showAlert("例外の検出", "入力漏れ", "未入力項目があるためDBに反映されませんでした。");
		}
	}
	
	@FXML
	private void OnCancelButtonClick(){
		fx_cancel_button.getScene().getWindow().hide();
	}
}
