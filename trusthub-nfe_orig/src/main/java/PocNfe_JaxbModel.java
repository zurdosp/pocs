import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class PocNfe_JaxbModel {

	public static void main(String[] args) {
		new PocNfe_JaxbModel().process();

	}

	private void process() {
		JAXBContext jaxbContext;
		try {
			jaxbContext = JAXBContext.newInstance( Countries.class );
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			Countries countres = (Countries)jaxbUnmarshaller.unmarshal( new File("countries.xml") );
			for (Country country : countres.getCountries()){
				System.out.println( "cap: " + country.getCapital() 
				 + ", id: " + country.getDob());				
			}
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		

	}

}
