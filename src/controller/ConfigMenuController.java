package controller;

import command.StageGenerator;
import javafx.fxml.FXML;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class ConfigMenuController {
	@FXML
	protected void OnMenuButton1Click(){
		System.out.println("button1");
		Stage stage = new StageGenerator().createStage("config_status-RUD.fxml",new BorderPane());
		stage.setTitle("ステータス設定");
	}
	@FXML
	protected void OnMenuButton2Click(){
		//Stage stage = new StageGenerator().createStage("customer_menu.fxml",new BorderPane());	
		//stage.setTitle("");
	}
	@FXML
	protected void OnMenuButton3Click(){
		//Stage stage = new StageGenerator().createStage("config_menu.fxml",new BorderPane());
		//stage.setTitle("");
	}
}
