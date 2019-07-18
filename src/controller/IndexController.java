package controller;

import command.StageGenerator;
import javafx.fxml.FXML;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class IndexController {
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
	

}
