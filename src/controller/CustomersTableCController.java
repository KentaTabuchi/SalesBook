package controller;

import application.SalesDao;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import sql_crud.Customers_Insert;

public class CustomersTableCController {
	@FXML private  TextField fx_text_name;
	@FXML private  TextField fx_text_kana_name;
	@FXML private  TextField fx_text_tel;
	@FXML private  TextField fx_text_address1;
	@FXML private  TextField fx_text_address2;
	@FXML private  TextField fx_text_address3;
	@FXML private  TextField fx_text_zip;
	@FXML private  TextField fx_text_email;
	@FXML private  TextField fx_text_person_in_charge;

	@FXML
	public void OnAddButtonClick(){
		System.out.println("CustomersTableCController: OnAddButtonClick invoke");
		Customers_Insert sql = new Customers_Insert
		(fx_text_name.getText(),fx_text_kana_name.getText(),fx_text_tel.getText(),fx_text_address1.getText(),
		 fx_text_address2.getText(),fx_text_address3.getText(),fx_text_zip.getText(),
		 fx_text_email.getText(),fx_text_person_in_charge.getText());
		new SalesDao(sql);
		    	
	}
	 
	 
}
