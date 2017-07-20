package br.com.trusthub.parser;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.sax.SAXSource;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import br.com.trusthub.parser.adapters.gson.GsonLocalDateAdapter;
import br.com.trusthub.parser.adapters.gson.GsonLocalDateTimeAdapter;
import br.com.trusthub.parser.filter.NamespaceFilterXMLReader;
import br.com.trusthub.parser.model.Countries;
//import br.com.trusthub.parser.filter.NamespaceFilterXMLReader;

public class PocXmlToJsonConverter {

	public static void main(String[] args) {
		int countGeral = 0;
		PocXmlToJsonConverter pocXmlToJsonConverter = new PocXmlToJsonConverter();
		while (countGeral++ < 1){
			int a = 0;
			LocalDateTime now_from = LocalDateTime.now();
			LocalDateTime now_to = LocalDateTime.now();
			System.out.println("inicio");
			//while((now_to.getSecond() - now_from.getSecond()) < 1){
			//pocXmlToJsonConverter.process();
			try {
				pocXmlToJsonConverter.unmarshallWithFilter();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JAXBException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			a++;
			now_to = LocalDateTime.now();
			//}
			System.out.println("fim, a count: " + a);		
		}
	}

	private void process() {
		JAXBContext jaxbContext;
		try {
			jaxbContext = JAXBContext.newInstance( Countries.class );
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			Countries countres = (Countries)jaxbUnmarshaller.unmarshal( new File("countries.xml") );
			//			for (Country country : countres.getCountries()){
			//				System.out.println( "cap: " + country.getCapital() 
			//				 + ", id: " + country.getDob() + ", time: " + country.getBirthday());				
			//			}
			//String serialized = new Gson().toJson(countres);
			Gson gson = new GsonBuilder().
					registerTypeAdapter(LocalDate.class, new GsonLocalDateAdapter()).
					registerTypeAdapter(LocalDateTime.class, new GsonLocalDateTimeAdapter()).create();
			String serialized = gson.toJson(countres);
			System.out.println(serialized);
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

	public void unmarshallWithFilter() throws FileNotFoundException, JAXBException {
		JAXBContext jaxbContext;
		FileReader fr = null;
		try {
			jaxbContext = JAXBContext.newInstance( Countries.class );
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			fr = new FileReader("countries.xml");
			XMLReader reader = new NamespaceFilterXMLReader();
			InputSource is = new InputSource(fr);
			SAXSource ss = new SAXSource(reader, is);
			Countries countres = (Countries)jaxbUnmarshaller.unmarshal(ss);
			
			Gson gson = new GsonBuilder().
					registerTypeAdapter(LocalDate.class, new GsonLocalDateAdapter()).
					registerTypeAdapter(LocalDateTime.class, new GsonLocalDateTimeAdapter()).create();
			String serialized = gson.toJson(countres);
			System.out.println(serialized);
			
		} catch (SAXException e) {
			//not technically a jaxb exception, but close enough
			throw new JAXBException(e);
		} catch (ParserConfigurationException e) {
			//not technically a jaxb exception, but close enough
			throw new JAXBException(e);
		} finally {
		}
	}


}
