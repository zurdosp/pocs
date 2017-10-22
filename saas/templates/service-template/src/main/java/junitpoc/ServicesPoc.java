package junitpoc;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import junitpoc.repository.ServicesRepository;
import junitpoc.services.Service1;

@RestController()
public class ServicesPoc {

	private static final Logger logger = LoggerFactory.getLogger(ServicesPoc.class);

	
	@Autowired
	private Service1 service1;

	@Autowired
	private ServiceConfig serviceConfig;

	@Autowired
	private ServicesRepository servicesRepository;
	
	@RequestMapping(value = "/students/{studentId}", method = GET)
	public String retrieveCoursesForStudent(@PathVariable String studentId) {
		logger.debug(serviceConfig.getDatabase1());
		logger.debug(serviceConfig.getServicePort());
		servicesRepository.findAll();
		if (service1.getNomeFull().equalsIgnoreCase("christian tejada")) {
			return serviceConfig.getDatabase1();
		} else {
			return "nao sou eu";
		}
	}

}
