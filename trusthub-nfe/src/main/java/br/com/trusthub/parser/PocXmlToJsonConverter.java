package br.com.trusthub.parser;
import java.io.File;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import br.com.trusthub.parser.adapters.gson.GsonLocalDateAdapter;
import br.com.trusthub.parser.adapters.gson.GsonLocalDateTimeAdapter;
import br.com.trusthub.parser.model.Countries;
import br.com.trusthub.parser.model.Country;

public class PocXmlToJsonConverter {

	public static void main(String[] args) {
		int countGeral = 0;
		while (countGeral++ < 20){
			int a = 0;
			LocalDateTime now_from = LocalDateTime.now();
			LocalDateTime now_to = LocalDateTime.now();
			System.out.println("inicio");
			while((now_to.getSecond() - now_from.getSecond()) < 1){
				new PocXmlToJsonConverter().process();
				a++;
				now_to = LocalDateTime.now();
			}
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
			//System.out.println(serialized);
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 


	}

}
