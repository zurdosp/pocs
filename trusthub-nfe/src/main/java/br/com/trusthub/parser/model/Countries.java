package br.com.trusthub.parser.model;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement( name = "Countries" )
public class Countries {
	
	List<Country> countries;

	public void setCountries( List<Country> countries ){
		this.countries = countries;
	}

	@XmlElement( name = "Country" )
	public List<Country> getCountries() {
		return countries;
	}
	
	

}
