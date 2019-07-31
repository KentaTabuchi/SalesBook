package controller;

import java.net.URL;
import java.time.LocalDateTime;
import java.util.ResourceBundle;

import application.SalesDao;
import command.Message;
import command.StageGenerator;
import command.StringLongBinding;
import command.StringSeparator;
import command.TextFieldValidator;
import enums.InvoiceStatuses;
import enums.Settle;
import javafx.beans.binding.Bindings;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
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
	protected final String NO_PERSON = "0:該当者なし";
	@FXML private ComboBox<String> fx_combo_settle;
	@FXML private ComboBox<String> fx_combo_genres_id;
	@FXML private ComboBox<String> fx_combo_customers_id;
	@FXML private ComboBox<String> fx_invoice_statuses;
	
	@FXML private ComboBox<String> fx_combo_staff_director;
	@FXML private ComboBox<String> fx_combo_staff_sale;
	@FXML private ComboBox<String> fx_combo_staff_design;
	@FXML private ComboBox<String> fx_combo_staff_coding;
	@FXML private ComboBox<String> fx_combo_staff_system;
	
	@FXML private ComboBox<String> fx_combo_year;
	@FXML private ComboBox<String> fx_combo_month;
	
	@FXML private ComboBox<String> fx_combo_charge_person;
	
	@FXML private DatePicker fx_picker_billing_date;
	@FXML private DatePicker fx_picker_pay_date;
	
	@FXML private TextField fx_text_total_sale;
	@FXML private Label fx_text_total_expense;
	@FXML private Label fx_text_total_profit;
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
	public static Label total_expense;
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		setComboBox();
		bindTextField();
		validation();
		setInitialValue();
	}
	protected void setInitialValue(){
		fx_combo_staff_director.setValue(NO_PERSON);
		fx_combo_staff_sale.setValue(NO_PERSON);
		fx_combo_staff_design.setValue(NO_PERSON);
		fx_combo_staff_coding.setValue(NO_PERSON);
		fx_combo_staff_system.setValue(NO_PERSON);
		
	}
	protected void bindTextField(){
		fx_text_total_profit.textProperty().bind(Bindings.subtract(
				new StringLongBinding(fx_text_total_sale.textProperty()),
				new StringLongBinding(fx_text_total_expense.textProperty())).asString());
	}
	protected void setComboBox(){
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
		
		
		fx_combo_staff_director.getItems().add(NO_PERSON);
		fx_combo_staff_sale.getItems().add(NO_PERSON);
		fx_combo_staff_design.getItems().add(NO_PERSON);
		fx_combo_staff_coding.getItems().add(NO_PERSON);
		fx_combo_staff_system.getItems().add(NO_PERSON);
		fx_combo_charge_person.getItems().add(NO_PERSON);
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
		for(int year = 2015 ; year < 2099 ; year++){
			fx_combo_year.getItems().add(String.valueOf(year));
		}
		for(int month = 1 ; month <= 12 ; month++){
			if(month <10){
				fx_combo_month.getItems().add("0" + String.valueOf(month));
			}else{
			fx_combo_month.getItems().add(String.valueOf(month));
			}
		}
		int month2 = LocalDateTime.now().getMonth().getValue();
		if(month2 < 10){
			fx_combo_month.setValue("0" + String.valueOf(month2));
		}else{
			fx_combo_month.setValue(String.valueOf(month2));
		}
		int year2 = LocalDateTime.now().getYear();
		fx_combo_year.setValue(String.valueOf(year2));
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
	protected void complementNullText(){
		
		if(fx_text_total_sale.getText().isEmpty()){
			fx_text_total_sale.setText("0");
		}
		if(fx_text_director_price.getText().isEmpty()){
			fx_text_director_price.setText("0");
		}
		if(fx_text_sale_price.getText().isEmpty()){
			fx_text_sale_price.setText("0");
		}
		if(fx_text_design_price.getText().isEmpty()){
			fx_text_design_price.setText("0");
		}
		if(fx_text_coding_price.getText().isEmpty()){
			fx_text_coding_price.setText("0");
		}
		if(fx_text_system_price.getText().isEmpty()){
			fx_text_system_price.setText("0");
		}
	}
	
	protected String createErrorMessage(){
		StringBuilder sb = new StringBuilder();
		sb.append(fx_combo_year.getValue() == null ? "売上月の年が未入力です。" : "");
		sb.append(fx_combo_month.getValue() == null ? "売上月の月が未入力です。" : "");
		sb.append(fx_picker_billing_date.getValue() == null ? "請求日が未入力です。\n" : "");
		sb.append(fx_combo_settle.getValue() == null ? "ステータスが未入力です。\n" : "");
		sb.append(fx_combo_charge_person.getValue() == null ? "担当者が未入力です。\n" : "");
		sb.append(fx_invoice_statuses.getValue() == null ? "請求が未入力です。\n" : "");
		sb.append(fx_combo_genres_id.getValue() == null ? "ジャンルが未入力です。\n" : "");
		sb.append(fx_combo_customers_id.getValue() == null ? "顧客が未入力です。\n" : "");
		return sb.toString();
	}
	
	@FXML
	protected void OnAddButtonClick(){
		complementNullText();
		try{
		Sales_Insert sql = new Sales_Insert
		(
				fx_text_name.getText(), //name
				fx_combo_year.getValue() + "-" + fx_combo_month.getValue(),
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
				"ダミー", // billing_date
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
			e.printStackTrace();
			new Message().showAlert("未入力項目があります", "下記の項目の選択が必要です。",createErrorMessage() );
			
		}
	}
	
	@FXML
	private void OnCancelButtonClick(){
		fx_cancel_button.getScene().getWindow().hide();
	}
}
