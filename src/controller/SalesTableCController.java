package controller;

import java.net.URL;
import java.util.ResourceBundle;

import application.SalesDao;
import enums.Settle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import model.Customers;
import model.Genres;
import model.Statuses;
import sql_crud.Customers_FindAll;

public class SalesTableCController  implements Initializable
{
	@FXML private ComboBox<String> fx_combo_settle;
	@FXML private ComboBox<Genres> fx_combo_genres_id;
	@FXML private ComboBox<String> fx_combo_customers_id;
	@FXML private ComboBox<Statuses> fx_invoice_statuses_id;
	@FXML private DatePicker fx_picker_billing_date;
	@FXML private TextField fx_text_total_sale;
	@FXML private TextField fx_text_total_expense;
	@FXML private TextField fx_text_profit;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		for(Settle item:Settle.values()){
			fx_combo_settle.getItems().add(item.getValue());
		}

		Customers_FindAll sql = new Customers_FindAll();
		new SalesDao(sql);
		for(Customers item:sql.recordList){
			fx_combo_customers_id.getItems().add(item.idProperty().getValue()+":"+item.nameProperty().getValue());
		}
		
	}
	@FXML
	protected void OnAddButtonClick(){
		
	}
}
