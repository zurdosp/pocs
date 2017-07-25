

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class LocalDateTimeAdapter extends XmlAdapter<String, LocalDateTime> {

	DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss:SSS");
	
	public LocalDateTime unmarshal(String date) throws Exception {
		return LocalDateTime.parse(date, dateFormatter);
	}

	public String marshal(LocalDateTime date) throws Exception {
		return date.format(dateFormatter);
	}

}