package controller;

import java.net.URL;
import java.util.ResourceBundle;

import command.PathGenerator;
import command.StageGenerator;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class IndexController implements Initializable{
	@FXML
	private Label fx_dirPath;
	
	@FXML
	protected void OnMenuButton1Click(){
		
		Stage stage = new StageGenerator().createStage("sales_menu.fxml",new BorderPane());
		stage.setTitle("売上メニュー");
	}
	@FXML
	protected void OnMenuButton2Click(){
		Stage stage = new StageGenerator().createStage("customers_menu.fxml",new BorderPane());	
		stage.setTitle("顧客メニュー");
	}
	@FXML
	protected void OnMenuButton3Click(){
		Stage stage = new StageGenerator().createStage("config_menu.fxml",new BorderPane());
		stage.setTitle("設定メニュー");
	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {

		fx_dirPath.setText(PathGenerator.getCurrentJarPath());
	
	}
	

}
