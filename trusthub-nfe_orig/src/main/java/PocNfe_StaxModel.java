import java.io.*;
import javax.xml.stream.*;
import javax.xml.stream.events.XMLEvent;

public class PocNfe_StaxModel {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			new PocNfe_StaxModel().process();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
    public void process() throws FileNotFoundException, XMLStreamException {
            // Use  reference implementation
            System.setProperty(
               "javax.xml.stream.XMLInputFactory",
               "com.bea.xml.stream.MXParserFactory");
            // Create the XML input factory
            XMLInputFactory factory = XMLInputFactory.newInstance();
            // Create event reader
            FileReader reader = new FileReader("teste.xml");
            XMLEventReader eventReader = factory.createXMLEventReader(reader);
            // Create a filtered reader
            XMLEventReader filteredEventReader =
               factory.createFilteredReader(eventReader, new EventFilter() {
               public boolean accept(XMLEvent event) {
                  // Exclude PIs
                  return (!event.isProcessingInstruction());
               }
            });
            // Main event loop
            while (filteredEventReader.hasNext()) {
               XMLEvent e = (XMLEvent)filteredEventReader.next();
               System.out.println(e);
            }    	
    	
    }
}
