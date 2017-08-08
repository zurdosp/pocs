package producer.services;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import producer.KafkaProducerConfig;
import producer.repository.ServicesRepository;

@RestController()
public class ServicesPocProducerServices {

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
		return "nao sou eu";
	}

}
