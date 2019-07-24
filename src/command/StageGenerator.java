package command;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * @author misskabu
 * @param String fxmlFileName : file name without /fxml/ 
 * @param Pane pane : new Pane for setting to new Stage. 
 * @return pointer of new Stage.
 */
public class StageGenerator {
	public FXMLLoader fxmlLoader;
	public Stage createStage(String fxmlFileName,Pane pane){
		Stage stage = new Stage();
	
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/"+ fxmlFileName));
			pane = (BorderPane) loader.load();
			Scene scene = new Scene(pane);
			stage.setScene(scene);
			stage.show();
			//scene.getStylesheets().add(getClass().getResource("../css/styles.css").toExternalForm());
			scene.getStylesheets().add(getClass().getResource("../application/application.css").toExternalForm());
			this.fxmlLoader = loader;
			return stage;

		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
}
