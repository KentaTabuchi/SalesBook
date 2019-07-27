package command;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class Message {
	public void showAlert(String message){
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.getDialogPane().setContentText(message);
		alert.showAndWait();
	}
	public void showAlert(String title,String header,String body){
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle(title);
		alert.getDialogPane().setHeaderText(header);
		alert.getDialogPane().setContentText(body);
		alert.showAndWait();
	}
	public void showAlert(int message){
		Alert alert = new Alert(AlertType.INFORMATION);
		//alert.setTitle(title);
		//alert.getDialogPane().setHeaderText(header);
		alert.getDialogPane().setContentText(String.valueOf(message));
		alert.showAndWait();
	}
	public void showAlert(long message){
		Alert alert = new Alert(AlertType.INFORMATION);
		//alert.setTitle(title);
		//alert.getDialogPane().setHeaderText(header);
		alert.getDialogPane().setContentText(String.valueOf(message));
		alert.showAndWait();
	}
}
