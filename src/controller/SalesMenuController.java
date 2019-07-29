package controller;

import command.StageGenerator;
import javafx.fxml.FXML;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class SalesMenuController {
	@FXML
	protected void OnMenuButton1Click(){
		Stage stage = new StageGenerator().createStage("main_view-RD.fxml",new BorderPane());	
		stage.setTitle("売上一覧");
	}
	@FXML
	protected void OnMenuButton2Click(){
		Stage stage = new StageGenerator().createStage("sales_table-C.fxml",new BorderPane());	
		stage.setTitle("新規売上登録");
	}
	@FXML
	protected void OnMenuButton3Click(){
		Stage stage = new StageGenerator().createStage("aggregate.fxml",new BorderPane());	
		stage.setTitle("月別集計");
	}
	@FXML
	protected void OnMenuButton4Click(){
		Stage stage = new StageGenerator().createStage("pl_C.fxml",new BorderPane());	
		stage.setTitle("月次費用登録");
	}
	@FXML
	protected void OnMenuButton5Click(){

	}
	@FXML
	protected void OnMenuButton6Click(){

	}
	
}
