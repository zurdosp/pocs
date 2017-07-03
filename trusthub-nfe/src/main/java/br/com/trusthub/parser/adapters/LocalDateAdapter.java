package br.com.trusthub.parser.adapters;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class LocalDateAdapter extends XmlAdapter<String, LocalDate> {

	DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	
	public LocalDate unmarshal(String date) throws Exception {
		return LocalDate.parse(date, dateFormatter);
	}

	public String marshal(LocalDate date) throws Exception {
		return date.format(dateFormatter);
	}

}