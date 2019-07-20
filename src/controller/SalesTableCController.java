package controller;

import java.net.URL;
import java.util.ResourceBundle;

import application.SalesDao;
import enums.InvoiceStatuses;
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
import sql_crud.Genres_FindAllById;

public class SalesTableCController  implements Initializable
{
	@FXML private ComboBox<String> fx_combo_settle;
	@FXML private ComboBox<String> fx_combo_genres_id;
	@FXML private ComboBox<String> fx_combo_customers_id;
	@FXML private ComboBox<String> fx_invoice_statuses_id;
	@FXML private DatePicker fx_picker_billing_date;
	@FXML private TextField fx_text_total_sale;
	@FXML private TextField fx_text_total_expense;
	@FXML private TextField fx_text_profit;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		for(Settle item:Settle.values()){
			fx_combo_settle.getItems().add(item.getValue());
		}
		for(InvoiceStatuses item:InvoiceStatuses.values()){
			fx_invoice_statuses_id.getItems().add(item.getValue());
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
		
	}
	@FXML
	protected void OnAddButtonClick(){
		
	}
}
