package controller;

import command.StageGenerator;
import javafx.fxml.FXML;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class ConfigMenuController {
	@FXML
	protected void OnMenuButton1Click(){
		System.out.println("button1");
		Stage stage = new StageGenerator().createStage("config_status-CRUD.fxml",new BorderPane());
		stage.setTitle("ステータス設定");
	}
	@FXML
	protected void OnMenuButton2Click(){
		Stage stage = new StageGenerator().createStage("config_genres-CRUD.fxml",new BorderPane());	
		stage.setTitle("ジャンル設定");
	}
	@FXML
	protected void OnMenuButton3Click(){
		//Stage stage = new StageGenerator().createStage("config_menu.fxml",new BorderPane());
		//stage.setTitle("");
	}
}
