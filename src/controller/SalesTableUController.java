package controller;

import java.net.URL;
import java.time.LocalDateTime;
import java.util.ResourceBundle;

import application.SalesDao;
import command.Message;
import command.StageGenerator;
import command.StringDateConverter;
import command.StringLongBinding;
import command.StringSeparator;
import command.TextFieldValidator;
import enums.InvoiceStatuses;
import enums.Settle;
import javafx.beans.binding.Bindings;
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
import model.Sales;
import model.Statuses;
import sql_crud.Customers_FindAll;
import sql_crud.Genres_FindAll;
import sql_crud.Sales_UpdateById;
import sql_crud.Statuses_FindAll;

public class SalesTableUController  implements Initializable
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
	
	@FXML private ComboBox<String> fx_combo_charge_person;
	
	@FXML private ComboBox<String> fx_combo_year;
	@FXML private ComboBox<String> fx_combo_month;
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
	@FXML private Label fx_id_label;
	//----------------------------------------------------
	//for carry over to SalesDetailCRUDController.java
	//----------------------------------------------------
	public static Long vendor_id;
	public static String vendor_name;
	public static Label total_expense;

	public static Sales sales; //Substitute from edit button of MainView.
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		setComboBox();
		setValuesToViewBySalesID();
		fx_text_total_profit.textProperty().bind(Bindings.subtract(
				new StringLongBinding(fx_text_total_sale.textProperty()),
				new StringLongBinding(fx_text_total_expense.textProperty())).asString());
		validation();	
		fx_id_label.setText(sales.idProperty().getValue().toString());
	}

	private void setValuesToViewBySalesID(){
		fx_combo_settle.setValue(sales.settleProperty().getValue());
		fx_combo_genres_id.setValue(sales.genres_idProperty().getValue() + ":" + sales.genres_nameProperty().getValue());
		fx_combo_customers_id.setValue(sales.customer_idProperty().getValue() + ":" + sales.customers_nameProperty().getValue());
		fx_invoice_statuses.setValue(sales.invoice_statusProperty().getValue());
		fx_combo_charge_person.setValue(sales.status_idProperty().getValue() +":" + sales.charge_personProperty().getValue());

		fx_picker_billing_date.setValue(StringDateConverter.getLocalDate(sales.income_dateProperty().getValue()));
		
		fx_text_total_sale.setText(sales.total_saleProperty().getValue().toString());
		fx_text_total_expense.setText(sales.total_expenseProperty().getValue().toString());
		fx_text_total_profit.setText(sales.total_profitProperty().getValue().toString());
		
		fx_text_name.setText(sales.nameProperty().getValue());
		fx_text_memo.setText(sales.memoProperty().getValue());
		
		fx_text_director_price.setText(sales.distribute_director_priceProperty().getValue().toString());
		fx_text_sale_price.setText(sales.distribute_sale_priceProperty().getValue().toString());
		fx_text_design_price.setText(sales.distribute_design_priceProperty().getValue().toString());
		fx_text_coding_price.setText(sales.distribute_coding_priceProperty().getValue().toString());
		fx_text_system_price.setText(sales.distribute_system_priceProperty().getValue().toString());
		
		try{
			fx_combo_staff_director.setValue(sales.staff_director_idProperty().getValue().toString()+":"+ sales.staff_director_nameProperty().getValue().toString());
			fx_combo_staff_sale.setValue(sales.staff_sale_idProperty().getValue().toString() +":"+ sales.staff_sale_nameProperty().getValue().toString());
			fx_combo_staff_design.setValue(sales.staff_design_idProperty().getValue().toString()+":"+ sales.staff_design_nameProperty().getValue().toString());
			fx_combo_staff_coding.setValue(sales.staff_coding_idProperty().getValue().toString() +":"+ sales.staff_coding_nameProperty().getValue().toString());
			fx_combo_staff_system.setValue(sales.staff_system_idProperty().getValue().toString()+":"+ sales.staff_system_nameProperty().getValue().toString());
		}catch(Exception e){
			fx_combo_staff_director.setValue(NO_PERSON);
			fx_combo_staff_sale.setValue(NO_PERSON);
			fx_combo_staff_design.setValue(NO_PERSON);
			fx_combo_staff_coding.setValue(NO_PERSON);
			fx_combo_staff_system.setValue(NO_PERSON);
			
		}
	}
	private void setComboBox(){
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
		generator.createStage("sales_detail2.fxml",new BorderPane());
		
		}catch(NullPointerException e){
			new Message().showAlert("例外の検出","記述漏れ","この先に進むには顧客情報の入力が必要です。");
		}
	
	}
	@FXML
	protected void OnAddButtonClick(){
		
		try{
		sales.setName(fx_text_name.getText());
		sales.setTotal_profit(Long.valueOf(fx_text_total_profit.getText()));
		sales.setTotal_expense(Long.valueOf(fx_text_total_expense.getText()));
		sales.setTotal_sale(Long.valueOf(fx_text_total_sale.getText()));
		sales.setSettle(fx_combo_settle.getValue());
		sales.setStatus_id(Long.valueOf(new StringSeparator().getFoward(fx_combo_charge_person.getValue(),':')));
		sales.setCustomer_id(Long.valueOf(new StringSeparator().getFoward(fx_combo_customers_id.getValue(),':')));
		sales.setGenres_id(Long.valueOf(new StringSeparator().getFoward(fx_combo_genres_id.getValue(),':')));
		sales.setInvoice_status(fx_invoice_statuses.getValue());
		sales.setMemo(fx_text_memo.getText());
		sales.setIncome_date(fx_picker_billing_date.getValue().toString());
		sales.setBilling_date("廃止");
		sales.setStaff_director_id(Long.valueOf(new StringSeparator().getFoward(fx_combo_staff_director.getValue(),':')));
		sales.setStaff_sale_id(Long.valueOf(new StringSeparator().getFoward(fx_combo_staff_sale.getValue(),':')));
		sales.setStaff_coding_id(Long.valueOf(new StringSeparator().getFoward(fx_combo_staff_coding.getValue(),':')));
		sales.setStaff_design_id(Long.valueOf(new StringSeparator().getFoward(fx_combo_staff_design.getValue(),':')));
		sales.setStaff_system_id(Long.valueOf(new StringSeparator().getFoward(fx_combo_staff_system.getValue(),':')));
		sales.setDistribute_director_price(Long.valueOf(fx_text_director_price.getText()));
		sales.setDistribute_sale_price(Long.valueOf(fx_text_sale_price.getText()));
		sales.setDistribute_design_price(Long.valueOf(fx_text_design_price.getText()));
		sales.setDistribute_coding_price(Long.valueOf(fx_text_coding_price.getText()));
		sales.setDistribute_system_price(Long.valueOf(fx_text_system_price.getText()));
		sales.setSales_month(fx_combo_year.getValue() + "-" + fx_combo_month.getValue());
		
		Sales_UpdateById sql = new Sales_UpdateById (sales);
		new SalesDao(sql);
		MainViewRDController.mainViewRDController.findAll();
		new Message().showAlert("処理の完了", "書き込み成功", "DBを更新しました。");
		}catch(Exception e){
			new Message().showAlert("例外の検出", "未入力項目", "DBを更新できませんでした。\n入力をご確認ください。");
		}
	}
	
	@FXML
	private void OnCancelButtonClick(){
		fx_cancel_button.getScene().getWindow().hide();
	}
}
