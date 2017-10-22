package junitpoc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ServicesPocApp {

	private static final Logger logger = LoggerFactory.getLogger(ServicesPoc.class);	
	
	public static void main(String[] args) {
		logger.info("iniciando app ServicesPoc.");
		SpringApplication.run(ServicesPocApp.class, args);
		logger.info("iniciado ServicesPoc com sucesso.");
	}

}
