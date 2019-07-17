package controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import application.SalesDao;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Statuses;
import sql_crud.Statuses_FindAllById;


public class ConfigStatusController implements Initializable {
	
	@FXML private TableView<Statuses> fx_table = new TableView<>();
	@FXML private TableColumn<Statuses,Long> fx_column_id;
	@FXML private TableColumn<Statuses,String> fx_column_name;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		setCellValueFactoryes();
		//TODO:change DB data with following mock data.--------------
		fx_table.getItems().add(new Statuses(10L,"test1"));
		fx_table.getItems().add(new Statuses(20L,"test2"));
		Statuses_FindAllById sql = new Statuses_FindAllById();
		new SalesDao(sql);
		for(Statuses record:sql.recordList){
			fx_table.getItems().add(record);
		}
		//----------------------------------------------------------
	}
	
	private void setCellValueFactoryes(){
		fx_column_id.setCellValueFactory(new PropertyValueFactory<Statuses,Long>("id"));
		fx_column_name.setCellValueFactory(new PropertyValueFactory<Statuses,String>("name"));
		
	}



}
