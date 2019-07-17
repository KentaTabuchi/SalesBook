package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Statuses;


public class ConfigStatusController implements Initializable {
	
	@FXML private TableView<Statuses> config_status_table = new TableView<>();
	@FXML private TableColumn<Statuses,Long> fx_column_id;
	@FXML private TableColumn<Statuses,String> fx_column_name;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		setCellValueFactoryes();
		config_status_table.getItems().add(new Statuses(10L,"test1"));
		config_status_table.getItems().add(new Statuses(20L,"test2"));
	}
	
	private void setCellValueFactoryes(){
		//引数の"id","date"などの文字列がPropertyBeansクラスのTradeLogRecordのprivate変数名と完全一致させると
		//TableViewと関連づけられる。文字列を間違えるとデータを表示できない。
		fx_column_id.setCellValueFactory(new PropertyValueFactory<Statuses,Long>("id"));
		fx_column_name.setCellValueFactory(new PropertyValueFactory<Statuses,String>("name"));
		
	}



}
