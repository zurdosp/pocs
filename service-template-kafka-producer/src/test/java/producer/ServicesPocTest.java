package producer;

import java.util.HashMap;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class ServicesPocTest {

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void teste111() {
		Assert.assertTrue(1 == 1);
	}

	@Test
	public void test() {
		ResponseEntity<String> response = restTemplate.getForEntity("/students/111", String.class, new HashMap<>());
		Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
		Assert.assertTrue(response.getBody().equals("nao sou eu"));
	}
}