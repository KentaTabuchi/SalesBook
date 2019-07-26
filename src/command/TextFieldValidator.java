package command;

import java.awt.Toolkit;

import javafx.beans.value.ObservableValue;
import javafx.scene.control.TextField;

public class TextFieldValidator {
	
	public static void addNumberValidator(TextField textField){
	      textField.lengthProperty().addListener((ObservableValue<? extends Number> observable, Number oldValue, Number newValue) -> {
	            if (newValue.intValue() > oldValue.intValue()) {
	                char ch = textField.getText().charAt(oldValue.intValue());
	                if (!(ch >= '0' && ch <= '9')) {  //ここの条件がヴァリデーション。
	                    Toolkit.getDefaultToolkit().beep();
	                    textField.setText(textField.getText().substring(0, textField.getText().length() - 1));
	                }
	            }
	        });
	}
}
