package br.com.trusthub.parser.model;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import br.com.trusthub.parser.adapters.LocalDateAdapter;
import br.com.trusthub.parser.adapters.LocalDateTimeAdapter;


@XmlRootElement( name = "Country" )
@XmlType( propOrder = { "dob", "population", "capital", "importance", "name", "birthday"} )
public class Country
{
	private LocalDate dob;	
	private LocalDateTime birthday;
	int population;
	String capital;
	int importance;
	String name;

	@XmlElement(name = "birthDateTime")
	@XmlJavaTypeAdapter(LocalDateTimeAdapter.class)
	public LocalDateTime getBirthday() {
		return birthday;
	}

	public void setBirthday(LocalDateTime birthday) {
		this.birthday = birthday;
	}

	@XmlElement(name = "birthDate")
	@XmlJavaTypeAdapter(LocalDateAdapter.class)
	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	
	

	public void setPopulation( int population ){
		this.population = population;
	}

	@XmlElement (name = "Country_Population")
	public int getPopulation() {
		return population;
	}

	@XmlElement( name = "Country_Capital" )
	public String getCapital() {
		return capital;
	}

	@XmlAttribute( name = "importance", required = true )
	public int getImportance() {
		return importance;
	}


	@XmlElement( name = "Country_Name" )
	public String getName() {
		return name;
	}


	public void setName( String name )
	{
		this.name = name;
	}

	public void setCapital( String capital )
	{
		this.capital = capital;
	}

	public void setImportance( int importance )
	{
		this.importance = importance;
	}
}