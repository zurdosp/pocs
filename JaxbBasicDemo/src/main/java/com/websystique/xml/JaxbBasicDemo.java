package com.websystique.xml;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.joda.time.LocalDate;

import com.websystique.xml.model.Student;
import com.websystique.xml.model.University;

public class JaxbBasicDemo {

	private static final String XML_FILE = "education_centers.xml";

	public static void main(String[] args) throws JAXBException,
			FileNotFoundException {

		// create JAXB context
		JAXBContext context = JAXBContext.newInstance(University.class);
		System.out.println("<!---------------Generating the Java objects from XML Input-------------->");
		// UnMarshalling [Generate JAVA from XML]
		// Instantiate Unmarshaller via context
		Unmarshaller um = context.createUnmarshaller();
		// Unmarshall the provided XML into an object
		University unif = (University) um.unmarshal(new FileReader(XML_FILE));
		List<Student> studentsList = unif.getStudents();
		for (Student s : studentsList) {
			System.out.println("Student : " + s);
		}
	}

}
