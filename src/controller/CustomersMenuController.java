package controller;

import command.StageGenerator;
import javafx.fxml.FXML;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class CustomersMenuController {
	@FXML
	protected void OnMenuButton1Click(){
		System.out.println("CustomersMenuController:OnMenuButton1Click invoke");
		Stage stage = new StageGenerator().createStage("customers_table-R.fxml",new BorderPane());
		stage.setTitle("ステータス設定");
	}
	@FXML
	protected void OnMenuButton2Click(){
	//	Stage stage = new StageGenerator().createStage("config_genres-RUD.fxml",new BorderPane());	
	//	stage.setTitle("ジャンル設定");
	}
	@FXML
	protected void OnMenuButton3Click(){
		//Stage stage = new StageGenerator().createStage("config_menu.fxml",new BorderPane());
		//stage.setTitle("");
	}
	@FXML
	protected void OnMenuButton4Click(){
		//Stage stage = new StageGenerator().createStage("config_menu.fxml",new BorderPane());
		//stage.setTitle("");
	}
	@FXML
	protected void OnMenuButton5Click(){
		//Stage stage = new StageGenerator().createStage("config_menu.fxml",new BorderPane());
		//stage.setTitle("");
	}
	@FXML
	protected void OnMenuButton6Click(){
		//Stage stage = new StageGenerator().createStage("config_menu.fxml",new BorderPane());
		//stage.setTitle("");
	}
}
