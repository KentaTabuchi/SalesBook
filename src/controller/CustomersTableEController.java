package controller;

import java.net.URL;
import java.util.ResourceBundle;

import application.SalesDao;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import model.Customers;
import sql_crud.Customers_Insert;
import sql_crud.Customers_UpdateById;

public class CustomersTableEController implements Initializable{
	
	static Customers customers;
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
		Customers_UpdateById sql = new Customers_UpdateById
		(fx_text_name.getText(),fx_text_kana_name.getText(),fx_text_tel.getText(),fx_text_address1.getText(),
		 fx_text_address2.getText(),fx_text_address3.getText(),fx_text_zip.getText(),
		 fx_text_email.getText(),fx_text_person_in_charge.getText());
		new SalesDao(sql);
		    	
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		fx_text_name.setText(customers.nameProperty().getValue());
		fx_text_kana_name.setText(customers.name_kanaProperty().getValue());
		fx_text_tel.setText(customers.tesProperty().getValue());
		fx_text_address1.setText(customers.address1Property().getValue());
		fx_text_address2.setText(customers.address2Property().getValue());
		fx_text_address3.setText(customers.address3Property().getValue());
		fx_text_zip.setText(customers.zipProperty().getValue());;
		fx_text_email.setText(customers.emailProperty().getValue());;
		fx_text_person_in_charge.setText(customers.person_in_chargeProperty().getValue());;
		
	}
	 
	 
}
