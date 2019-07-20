package controller;

import command.StageGenerator;
import javafx.fxml.FXML;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class SalesMenuController {
	@FXML
	protected void OnMenuButton1Click(){

	}
	@FXML
	protected void OnMenuButton2Click(){
		Stage stage = new StageGenerator().createStage("sales_table-C.fxml",new BorderPane());	
		stage.setTitle("新規売上登録");
	}
	@FXML
	protected void OnMenuButton3Click(){

	}
	@FXML
	protected void OnMenuButton4Click(){

	}
	@FXML
	protected void OnMenuButton5Click(){

	}
	@FXML
	protected void OnMenuButton6Click(){

	}
	
}
