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

public class PocNfe {


	public static void main(String[] args) {
		String fileName = "/Users/pankaj/employee.xml";
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
				XMLEvent xmlEvent = xmlEventReader.nextEvent();
				if (xmlEvent.isStartElement()){
					StartElement startElement = xmlEvent.asStartElement();
					if(startElement.getName().getLocalPart().equals("Nfe")){
						emp = new Nfe();
						//Get the 'id' attribute from Nfe element
						Attribute idAttr = startElement.getAttributeByName(new QName("id"));
						if(idAttr != null){
							emp.setId(Integer.parseInt(idAttr.getValue()));
						}
					}
					//set the other varibles from xml elements
					else if(startElement.getName().getLocalPart().equals("age")){
						xmlEvent = xmlEventReader.nextEvent();
						emp.setAge(Integer.parseInt(xmlEvent.asCharacters().getData()));
					}else if(startElement.getName().getLocalPart().equals("name")){
						xmlEvent = xmlEventReader.nextEvent();
						emp.setName(xmlEvent.asCharacters().getData());
					}else if(startElement.getName().getLocalPart().equals("gender")){
						xmlEvent = xmlEventReader.nextEvent();
						emp.setGender(xmlEvent.asCharacters().getData());
					}else if(startElement.getName().getLocalPart().equals("role")){
						xmlEvent = xmlEventReader.nextEvent();
						emp.setRole(xmlEvent.asCharacters().getData());
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


	//	public static void main(String[] args){
	//		System.out.println("inicio");
	//		new PocNfe().processarNota("\\christian\\M18\\notas\\BR\\Notas_Brasil_NFE\\35130944031201000121550010000734061080004062-procNfe.xml");
	//		System.out.println("fim");
	//	}
	//
	//	void processarNota(String pathFile) {
	//		FileInputStream crunchifyInputStream = null;
	//		File crunchifyFile = new File(pathFile);
	//		byte[] crunchifyByteStream = new byte[(int) crunchifyFile.length()];
	//		try {
	//			crunchifyInputStream = new FileInputStream(crunchifyFile);
	//			crunchifyInputStream.read(crunchifyByteStream);
	//			crunchifyInputStream.close();
	//
	//			for (int counter = 0; counter < crunchifyByteStream.length; counter++) {
	//				System.out.print((char) crunchifyByteStream[counter]);
	//			}
	//			TNfeProc tNfeProc = new NfeFactory().recuperaDeXml(crunchifyByteStream);
	//			System.out.println("\n\nTask Finished");
	//		} catch (Exception e) {
	//			e.printStackTrace();
	//		}
	//	}

}
