package junitpoc.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import junitpoc.ServicesPoc;

@Repository
public class ServicesRepository {
	
	private static final Logger logger = LoggerFactory.getLogger(ServicesPoc.class);
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	  @Transactional(readOnly=true)
	    public void findAll() {
		  logger.info("Executing select * from potluck");
		  jdbcTemplate.execute("select * from potluck");
	    }
	 
}
