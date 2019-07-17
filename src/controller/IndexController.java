package controller;

import command.StageGenerator;
import javafx.fxml.FXML;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class IndexController {
	@FXML
	protected void OnMenuButton1Click(){
		System.out.println("index.fxml:menu_button_1 clicked");
		Stage stage = new StageGenerator().createBoderPaneStage("sales_menu.fxml",new BorderPane());
		stage.setTitle("売上メニュー");
	}
	@FXML
	protected void OnMenuButton2Click(){
		System.out.println("index.fxml:menu_button2_ clicked");
	}
	@FXML
	protected void OnMenuButton3Click(){
		System.out.println("index.fxml:menu_button_3 clicked");
	}
	

}
