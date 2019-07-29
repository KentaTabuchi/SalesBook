package controller;

import java.net.URL;
import java.util.ResourceBundle;

import application.SalesDao;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Aggregate;
import model.SalesDetails;
import sql_aggregate.Aggregate_FindAll;
import sql_crud.SalesDetails_FindAll;

public class AggregateController implements Initializable{

	@FXML TableView<Aggregate> fx_table;
	@FXML TableColumn<Aggregate,String> fx_column_month;
	@FXML TableColumn<Aggregate,Long> fx_column_profit;
	@FXML TableColumn<Aggregate,Long> fx_column_sales;
	@FXML TableColumn<Aggregate,Long> fx_column_expense;
	
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		setCellValueFactoryes();
		findAll();
	}
	protected void findAll(){
    	for ( int i = 0; i<fx_table.getItems().size(); i++) {
    	    fx_table.getItems().clear();
    	}
		Aggregate_FindAll sql = new Aggregate_FindAll();
		new SalesDao(sql);
		for(Aggregate record:sql.recordList){
			fx_table.getItems().add(record);
		}
	}
	private void setCellValueFactoryes(){
		fx_column_month.setCellValueFactory(new PropertyValueFactory<Aggregate,String>("year_month"));
		fx_column_sales.setCellValueFactory(new PropertyValueFactory<Aggregate,Long>("sum_sales"));
		fx_column_profit.setCellValueFactory(new PropertyValueFactory<Aggregate,Long>("sum_profit"));
		fx_column_expense.setCellValueFactory(new PropertyValueFactory<Aggregate,Long>("sum_expense"));
	}

}
