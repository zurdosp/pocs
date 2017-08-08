package producer;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;

@Component
@PropertySources({ @PropertySource(value = "classpath:service.properties"),
		@PropertySource(value = "classpath:database.properties") })
public class ServiceConfig {

	@Value("${server.port}")
	private String servicePort;

	@Value("${kafka.topic.name}")
	private String kafkaTopicName;

	@Value("${kafka.server.config}")
	private String kafkaServerConfig;

	public String getServicePort() {
		return servicePort;
	}

	public void setServicePort(String servicePort) {
		this.servicePort = servicePort;
	}

	@Bean
	public JdbcTemplate jdbcTemplate(DataSource dataSource) {
		return new JdbcTemplate(dataSource);
	}

	@Bean
	@Autowired
	public PlatformTransactionManager transactionManager(DataSource dataSource) {
		return new DataSourceTransactionManager(dataSource);
	}
	//
	// @Bean
	// public DataSource dataSource(@Value("${database.host}") String host,
	// @Value("${database.port}") Integer port,
	// @Value("${database.username}") String username,
	// @Value("${database.password}") String password,
	// @Value("${database.name}") String database,
	// @Value("${database.instance.name}") String instanceName,
	// @Value("${database.pool}") Integer pool) {
	//
	// DriverManagerDataSource dataSource = new DriverManagerDataSource();
	// dataSource.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	// dataSource.setUrl(host + "" + port);
	// dataSource.setUsername(username);
	// dataSource.setPassword(password);
	// return dataSource;
	// }

	public String getKafkaTopicName() {
		return kafkaTopicName;
	}

	public void setKafkaTopicName(String kafkaTopicName) {
		this.kafkaTopicName = kafkaTopicName;
	}

	public String getKafkaServerConfig() {
		return kafkaServerConfig;
	}

	public void setKafkaServerConfig(String kafkaServerConfig) {
		this.kafkaServerConfig = kafkaServerConfig;
	}

}
