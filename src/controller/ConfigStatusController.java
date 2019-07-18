package controller;

import java.net.URL;
import java.util.ResourceBundle;

import application.SalesDao;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Statuses;
import sql_crud.Statuses_FindAllById;
import sql_crud.Statuses_Insert;


public class ConfigStatusController implements Initializable {
	
	@FXML private TableView<Statuses> fx_table = new TableView<>();
	@FXML private TableColumn<Statuses,Long> fx_column_id;
	@FXML private TableColumn<Statuses,String> fx_column_name;
	@FXML private TextField fx_text_name;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		setCellValueFactoryes();
		Statuses_FindAllById sql = new Statuses_FindAllById();
		new SalesDao(sql);
		for(Statuses record:sql.recordList){
			fx_table.getItems().add(record);
		}
	}
	
	private void setCellValueFactoryes(){
		fx_column_id.setCellValueFactory(new PropertyValueFactory<Statuses,Long>("id"));
		fx_column_name.setCellValueFactory(new PropertyValueFactory<Statuses,String>("name"));
		
	}
	
	@FXML
	public void OnAddButtonClick(){
		System.out.println("addbuttonClick");
		Statuses_Insert sql = new Statuses_Insert(fx_text_name.getText());
		new SalesDao(sql);
		
    	for ( int i = 0; i<fx_table.getItems().size(); i++) {
    	    fx_table.getItems().clear();
    	}
    	
		Statuses_FindAllById sql2 = new Statuses_FindAllById();
		new SalesDao(sql2);
		for(Statuses record:sql2.recordList){
			fx_table.getItems().add(record);
		
	}


	}
}
