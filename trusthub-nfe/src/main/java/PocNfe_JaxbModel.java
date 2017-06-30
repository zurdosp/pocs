import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class PocNfe_JaxbModel {

	public static void main(String[] args) {
		new PocNfe_JaxbModel().process();

	}

	private void process() {
		File file = new File( "countries.xml" );
		JAXBContext jaxbContext;
//		try {
//			jaxbContext = JAXBContext.newInstance( Countries.class );
//
//			/**
//			 * the only difference with the marshaling operation is here
//			 */
//			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
//			Countries countres = (Countries)jaxbUnmarshaller.unmarshal( file );
//			System.out.println( countres );
//		} catch (JAXBException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

	}

}
