package command;

import javafx.beans.binding.LongBinding;
import javafx.beans.value.ObservableStringValue;

public class StringLongBinding extends LongBinding{

	private final ObservableStringValue source;

    public StringLongBinding(ObservableStringValue s) {
        super.bind(s);
        this.source = s;
    }
	
	@Override
	protected long computeValue() {
        try {
            return Long.parseLong(source.getValue());
        } catch (NumberFormatException ex) {
            return 0;
        }
	}

}
