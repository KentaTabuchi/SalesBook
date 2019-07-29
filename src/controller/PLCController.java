package controller;

import java.net.URL;
import java.util.ResourceBundle;

import application.SalesDao;
import command.Message;
import command.TextFieldValidator;
import enums.Settle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import sql_crud.Customers_Insert;

public class PLCController implements Initializable{
	@FXML private  ComboBox<String> fx_combo_year;
	@FXML private  ComboBox<String> fx_combo_month;
	@FXML private TextField fx_text_bonus_allowance;
	@FXML private TextField fx_text_provision_of_bonus_allowance;
	@FXML private TextField fx_text_commuter_traffic_expenses;
	@FXML private TextField fx_text_communication_cost;
	@FXML private TextField fx_text_back_log;
	@FXML private TextField fx_text_lease_fee;
	@FXML private TextField fx_text_rent_fee;
	@FXML private TextField fx_text_repair_costs;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
//		TextFieldValidator.addPhoneValidator(fx_text_tel);
//		TextFieldValidator.addZipValidator(fx_text_zip);
//		TextFieldValidator.addEmailValidator(fx_text_email);
//		
		setComboBox();
	}	
	private void setComboBox(){
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
	}
	
	@FXML
	public void OnAddButtonClick(){
//		System.out.println("CustomersTableCController: OnAddButtonClick invoke");
//		try{
//		Customers_Insert sql = new Customers_Insert
//		(fx_text_name.getText(),fx_text_kana_name.getText(),fx_text_tel.getText(),fx_text_address1.getText(),
//		 fx_text_address2.getText(),fx_text_address3.getText(),fx_text_zip.getText(),
//		 fx_text_email.getText(),fx_text_person_in_charge.getText());
//		new SalesDao(sql);
//		new Message().showAlert("処理の完了", "書き込み成功", "DBに登録しました。 ");
//		}catch(Exception e){
//			new Message().showAlert("例外の検出", "入力漏れ", "DBに登録できませんでした。\n 入力内容をご確認ください。 ");
//		}
	} 
	 
}
