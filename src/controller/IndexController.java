package controller;

import java.io.IOException;

import command.StageGenerator;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class IndexController {
	@FXML
	protected void OnMenuButton1Click(){
		System.out.println("index.fxml:menu_button_1 clicked");
		createBoderPaneStage("sales_menu.fxml");
		
	}
	@FXML
	protected void OnMenuButton2Click(){
		System.out.println("index.fxml:menu_button_ clicked");
	}
	@FXML
	protected void OnMenuButton3Click(){
		System.out.println("index.fxml:menu_button_1 clicked");
	}
	
	private Stage createBoderPaneStage(String fxmlFileName){
		Stage stage = new Stage();
	
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/"+ fxmlFileName));
			BorderPane root = (BorderPane) loader.load();
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
			return stage;

		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
}
