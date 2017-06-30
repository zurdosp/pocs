import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

public class PocNfe_StaxNaMao {


	public static void main(String[] args) {
		String fileName = "/home/christian/christian/work/git/pocs/trusthub-nfe/docs/br/31130908237189000142550010000414841002263608-nfe.xml";
		List<Nfe> empList = parseXML(fileName);
		for(Nfe emp : empList){
			System.out.println(emp.toString());
		}
	}

	private static List<Nfe> parseXML(String fileName) {
		List<Nfe> empList = new ArrayList<Nfe>();
		Nfe emp = null;
		XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
		try {
			XMLEventReader xmlEventReader = xmlInputFactory.createXMLEventReader(new FileInputStream(fileName));
			while(xmlEventReader.hasNext()){
				Nfe nfe = new Nfe();
				XMLEvent xmlEvent = xmlEventReader.nextEvent();
				//System.out.println(xmlEvent);
				if (xmlEvent.toString().contains("xml version")){
					continue;
				}
				if (xmlEvent.isStartElement()){
					StartElement startElement = xmlEvent.asStartElement();
					startElement.getNamespaces();
					 if (startElement.getName().getLocalPart().equals("ide")){
						xmlEvent = xmlEventReader.nextEvent();		
						if (xmlEvent.asStartElement().getName().getLocalPart().equals("cUF")){						
							xmlEvent = xmlEventReader.nextEvent();
							System.out.println("cUF:" + xmlEvent.asCharacters());
						}
					}
					 if (xmlEvent.isStartElement() && 
							 xmlEvent.asStartElement().getName().getLocalPart().equals("cobr")){						
						 xmlEvent = xmlEventReader.nextEvent();
						 System.out.println("duplicata:" + xmlEvent.asStartElement().getName());
					 }						
				}
				//if Nfe end element is reached, add Nfe object to list
				if(xmlEvent.isEndElement()){
					EndElement endElement = xmlEvent.asEndElement();
					if(endElement.getName().getLocalPart().equals("Nfe")){
						empList.add(emp);
					}
				}
			}

		} catch (FileNotFoundException | XMLStreamException e) {
			e.printStackTrace();
		}
		return empList;
	}

}
