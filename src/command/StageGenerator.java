package command;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class StageGenerator {
	public Stage createBoderPaneStage(String fxmlFileName,Pane pane){
		Stage stage = new Stage();
	
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/"+ fxmlFileName));
			pane = (BorderPane) loader.load();
			Scene scene = new Scene(pane);
			stage.setScene(scene);
			stage.show();
			return stage;

		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
}
