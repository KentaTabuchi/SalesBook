package command;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TimeStamper {
	public String getNowJapanese(){
		return DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH時mm分ss秒E曜日").format(LocalDateTime.now());
	}
}
