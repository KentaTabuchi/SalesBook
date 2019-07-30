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
import model.PL;
import sql_crud.Customers_Insert;
import sql_crud.PL_Insert;

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
	@FXML private TextField fx_text_maintenance_fee;
	@FXML private TextField fx_text_insurance_fee;
	@FXML private TextField fx_text_recruiting_expenses;
	@FXML private TextField fx_text_fees;
	@FXML private TextField fx_text_newspaper_book_expenses;
	@FXML private TextField fx_text_miscellaneous_expenses;
	
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

		try{
		PL pl = new  PL();
		pl.setMonth(fx_combo_year.getValue() + "-" + fx_combo_month.getValue());
		pl.setbonus_allowance(Long.valueOf(fx_text_bonus_allowance.getText()));
		pl.setProvision_of_bonus_allowance(Long.valueOf(fx_text_provision_of_bonus_allowance.getText()));
		pl.setCommuter_traffic_expenses(Long.valueOf(fx_text_commuter_traffic_expenses.getText()));
		pl.setCommunication_cost(Long.valueOf(fx_text_communication_cost.getText()));
		pl.setBack_log(Long.valueOf(fx_text_back_log.getText()));
		pl.setRent_fee(Long.valueOf(fx_text_rent_fee.getText()));
		pl.setLease_fee(Long.valueOf(fx_text_lease_fee.getText()));
		pl.setRepair_costs(Long.valueOf(fx_text_repair_costs.getText()));
		pl.setMaintenance_fee(Long.valueOf(fx_text_maintenance_fee.getText()));
		pl.setInsurance_fee(Long.valueOf(fx_text_insurance_fee.getText()));
		pl.setRecruiting_expenses(Long.valueOf(fx_text_recruiting_expenses.getText()));
		pl.setFees(Long.valueOf(fx_text_fees.getText()));
		pl.setNewspaper_book_expenses(Long.valueOf(fx_text_newspaper_book_expenses.getText()));
		pl.setmiscellaneous_expenses(Long.valueOf(fx_text_miscellaneous_expenses.getText()));
		//TODO ここにplオブジェクトへビューのフィールドの値を書き込む。
		PL_Insert sql = new PL_Insert(pl);
		
		new SalesDao(sql);
		new Message().showAlert("処理の完了", "書き込み成功", "DBに登録しました。 ");
		}catch(Exception e){
			new Message().showAlert("例外の検出", "入力漏れ", "DBに登録できませんでした。\n 入力内容をご確認ください。 ");
		}
	} 
	 
}
