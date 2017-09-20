package com.example.demo;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	//@Test
//	public void testePostWithModel() {
//	        /**
//	         *
//	         * This is going to setup the REST server configuration in the applicationContext
//	         * you can see that I am using the new Spring's Java Configuration style and not some OLD XML file
//	         *
//	         */
//	        ApplicationContext context = new AnnotationConfigApplicationContext(RESTConfiguration.class);
//	        /**
//	         *
//	         * We now get a RESTServer bean from the ApplicationContext which has all the data we need to
//	         * log into the REST service with.
//	         *
//	         */
//	        RESTServer mRESTServer = context.getBean(RESTServer.class);
//	        /**
//	         *
//	         * Setting up data to be sent to REST service
//	         *
//	         */
//	        Map<String, String> vars = new HashMap<String, String>();
//	        vars.put("id", "JS01");
//	        /**
//	         *
//	         * Doing the REST call and then displaying the data/user object
//	         *
//	         */
//	        try
//	        {
//	            /*
//	                This is code to post and return a user object
//	             */
//	            RestTemplate rt = new RestTemplate();
//	            rt.getMessageConverters().add(new MappingJacksonHttpMessageConverter());
//	            rt.getMessageConverters().add(new StringHttpMessageConverter());
//	            String uri = new String("http://" + mRESTServer.getHost() + ":8080/springmvc-resttemplate-test/api/{id}");
//	            
//	            TransactionaData returns = rt.postForObject(uri, u, TransactionaData.class, vars);
//	            LOGGER.debug("User:  " + u.toString());
//	        }
//	        catch (HttpClientErrorException e)
//	        {
//	            /**
//	             *
//	             * If we get a HTTP Exception display the error message
//	             */
//	            LOGGER.error("error:  " + e.getResponseBodyAsString());
//	            ObjectMapper mapper = new ObjectMapper();
//	            ErrorHolder eh = mapper.readValue(e.getResponseBodyAsString(), ErrorHolder.class);
//	            LOGGER.error("error:  " + eh.getErrorMessage());
//	        }
//	        catch(Exception e)
//	        {
//	            LOGGER.error("error:  " + e.getMessage());
//	        }
//	    }
//	}
	
	

}
