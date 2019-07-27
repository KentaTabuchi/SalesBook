package command;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class StringDateConverter {
	
	static public LocalDate getLocalDate(String strDate){
		final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		return LocalDate.parse(strDate, formatter);
	}
}
