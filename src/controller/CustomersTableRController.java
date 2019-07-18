package controller;

import java.net.URL;
import java.util.ResourceBundle;
import application.SalesDao;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Customers;
import sql_crud.Customers_FindAllById;


public class CustomersTableRController implements Initializable {
	
	@FXML private TableView<Customers> fx_table = new TableView<>();
	@FXML private TableColumn<Customers,Long>   fx_column_id;
	@FXML private TableColumn<Customers,String> fx_column_name;
	@FXML private TableColumn<Customers,String> fx_column_name_kana;
	@FXML private TableColumn<Customers,String> fx_column_tel;
	@FXML private TableColumn<Customers,String> fx_column_address1;
	@FXML private TableColumn<Customers,String> fx_column_address2;
	@FXML private TableColumn<Customers,String> fx_column_address3;
	@FXML private TableColumn<Customers,String> fx_column_zip;
	@FXML private TableColumn<Customers,String> fx_column_email;
	@FXML private TableColumn<Customers,String> fx_column_person_in_charge;
	@FXML private TableColumn<Customers,String> fx_column_created_at;
	@FXML private TableColumn<Customers,String> fx_column_update_at;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		setCellValueFactoryes();
		Customers_FindAllById sql = new Customers_FindAllById();
		new SalesDao(sql);
		for(Customers record:sql.recordList){
			fx_table.getItems().add(record);
		}
	}
	
	private void setCellValueFactoryes(){
		fx_column_id.setCellValueFactory(new PropertyValueFactory<Customers,Long>("id"));
		fx_column_name.setCellValueFactory(new PropertyValueFactory<Customers,String>("name"));
		fx_column_name_kana.setCellValueFactory(new PropertyValueFactory<Customers,String>("name_kana"));
		fx_column_tel.setCellValueFactory(new PropertyValueFactory<Customers,String>("tel"));
		fx_column_address1.setCellValueFactory(new PropertyValueFactory<Customers,String>("address1"));
		fx_column_address2.setCellValueFactory(new PropertyValueFactory<Customers,String>("address2"));
		fx_column_address3.setCellValueFactory(new PropertyValueFactory<Customers,String>("address3"));
		fx_column_zip.setCellValueFactory(new PropertyValueFactory<Customers,String>("zip"));
		fx_column_email.setCellValueFactory(new PropertyValueFactory<Customers,String>("email"));
		fx_column_person_in_charge.setCellValueFactory(new PropertyValueFactory<Customers,String>("person_in_charge"));
		fx_column_created_at.setCellValueFactory(new PropertyValueFactory<Customers,String>("created_at"));
		fx_column_update_at.setCellValueFactory(new PropertyValueFactory<Customers,String>("update_at"));
	}	
}
