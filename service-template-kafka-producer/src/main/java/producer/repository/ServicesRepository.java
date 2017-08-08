package producer.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class ServicesRepository {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	  @Transactional(readOnly=true)
	    public void findAll() {
		  jdbcTemplate.execute("select * from potluck");
	    }
	 
}
