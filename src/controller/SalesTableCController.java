package controller;

import enums.Settle;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import model.Customers;
import model.Genres;
import model.Statuses;

public class SalesTableCController {
	@FXML private ComboBox<Settle> fx_combo_settle;
	@FXML private ComboBox<Genres> fx_combo_genres_id;
	@FXML private ComboBox<Customers> fx_combo_customers_id;
	@FXML private ComboBox<Statuses> fx_invoice_statuses_id;
	@FXML private DatePicker fx_picker_billing_date;
	@FXML private TextField fx_text_total_sale;
	@FXML private TextField fx_text_total_expense;
	@FXML private TextField fx_text_profit;
	
	@FXML
	protected void OnAddButtonClick(){
		
	}
}
