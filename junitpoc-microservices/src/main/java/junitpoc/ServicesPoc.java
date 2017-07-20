package junitpoc;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import junitpoc.services.Service1;

@RestController(value = "/testepoc")
public class ServicesPoc {

	@Autowired
	private Service1 service1;

	@RequestMapping(value = "/students/{studentId}", method = GET)
	public String retrieveCoursesForStudent(@PathVariable String studentId) {
		if (service1.getNomeFull().equalsIgnoreCase("christian tejada")) {
			return "eu";
		} else {
			return "nao sou eu";
		}
	}

}
