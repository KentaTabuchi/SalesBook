package command;

import javafx.beans.binding.DoubleBinding;
import javafx.beans.value.ObservableStringValue;

public class StringDoubleBinding extends DoubleBinding {
    
	private final ObservableStringValue source;

    public StringDoubleBinding(ObservableStringValue s) {
        super.bind(s);
        this.source = s;
    }
	@Override
	protected double computeValue() {
        try {
            return Double.parseDouble(source.getValue());
        } catch (NumberFormatException ex) {
            return 0;
        }
    }

}
