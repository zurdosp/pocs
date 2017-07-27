package junitpoc;

import java.util.HashMap;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import junitpoc.services.Service1;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class ServicesPocTest {

	@Autowired
	private TestRestTemplate restTemplate;

	@Autowired
	private Service1 service1;

	@Test
	public void test() {
		Mockito.when(service1.getNomeFull()).thenReturn("1234");

		ResponseEntity<String> response = restTemplate.getForEntity("/students/christian", String.class,
				new HashMap<>());
		Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
		Assert.assertTrue(response.getBody().equals("eu"));
	}
}