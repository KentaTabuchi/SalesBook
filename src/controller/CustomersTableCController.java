package controller;

import java.net.URL;
import java.util.ResourceBundle;

import application.SalesDao;
import command.Message;
import command.TextFieldValidator;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import sql_crud.Customers_Insert;

public class CustomersTableCController implements Initializable{
	@FXML private  TextField fx_text_name;
	@FXML private  TextField fx_text_kana_name;
	@FXML private  TextField fx_text_tel;
	@FXML private  TextField fx_text_address1;
	@FXML private  TextField fx_text_address2;
	@FXML private  TextField fx_text_address3;
	@FXML private  TextField fx_text_zip;
	@FXML private  TextField fx_text_email;
	@FXML private  TextField fx_text_person_in_charge;

	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		TextFieldValidator.addPhoneValidator(fx_text_tel);
		TextFieldValidator.addZipValidator(fx_text_zip);
		TextFieldValidator.addEmailValidator(fx_text_email);
		
	}	
	
	@FXML
	public void OnAddButtonClick(){
		System.out.println("CustomersTableCController: OnAddButtonClick invoke");
		try{
		Customers_Insert sql = new Customers_Insert
		(fx_text_name.getText(),fx_text_kana_name.getText(),fx_text_tel.getText(),fx_text_address1.getText(),
		 fx_text_address2.getText(),fx_text_address3.getText(),fx_text_zip.getText(),
		 fx_text_email.getText(),fx_text_person_in_charge.getText());
		new SalesDao(sql);
		new Message().showAlert("処理の完了", "書き込み成功", "DBに登録しました。 ");
		}catch(Exception e){
			new Message().showAlert("例外の検出", "入力漏れ", "DBに登録できませんでした。\n 入力内容をご確認ください。 ");
		}
	} 
	 
}
