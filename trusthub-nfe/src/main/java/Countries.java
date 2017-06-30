import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement( name = "Countries" )
public class Countries {
	List<Country> countries;

	/**
	 * element that is going to be marshaled in the xml
	 */
	@XmlElement( name = "Country" )
	public void setCountries( List<Country> countries )
	{
		this.countries = countries;
	}

}
