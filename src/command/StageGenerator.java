package command;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class StageGenerator {
	public Stage createStage(String fxmlFileName,String title){
		Stage stage = new Stage();
		BorderPane root;
		try {
			root = (BorderPane)FXMLLoader.load(getClass().getResource("/fxml/" + fxmlFileName));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			stage.setScene(scene);
			stage.show();
			stage.setTitle(title);
			return stage;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
}
