package junitpoc;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import junitpoc.repository.ServicesRepository;
import junitpoc.services.Service1;

@RestController()
public class ServicesPocProducer {

	@Autowired
	private Service1 service1;

	@Autowired
	private ServiceConfig serviceConfig;

	@Autowired
	private ServicesRepository servicesRepository;
	
	@Autowired
	private KafkaProducerConfig kafkaProducerConfig;
	
	@RequestMapping(value = "/students/{studentId}", method = GET)
	public String retrieveCoursesForStudent(@PathVariable String studentId) {
		servicesRepository.findAll();
		String dataString = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date());
		kafkaProducerConfig.sendMessage(dataString);
		System.out.println("Message produced: " + dataString);
		if (service1.getNomeFull().equalsIgnoreCase("christian tejada")) {
			return serviceConfig.getDatabase1();
		} else {
			return "nao sou eu";
		}
	}

}
