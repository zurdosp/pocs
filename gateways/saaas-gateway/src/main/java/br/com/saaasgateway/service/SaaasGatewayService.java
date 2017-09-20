package br.com.saaasgateway.service;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.saaasgateway.domain.TransactionaData;

@SpringBootApplication
@RestController
public class SaaasGatewayService {

	
	@RequestMapping(value="/saaas/transaction", method = RequestMethod.POST)
	@ResponseBody
	public TransactionaData postExample(@RequestBody TransactionaData transacionData) {
		System.out.println(transacionData);
		transacionData.setNome("christian");
		return transacionData;
	}
	
	
	// TESTES INICIO
	
	@RequestMapping(value="/hello/{name}", method = RequestMethod.GET)
	@ResponseBody
	public String hi(@PathVariable(value="name") String name) {
		String json = "{\"nome\" : \"" + name + "\"}";
		System.out.println("json:" + json);
		return json;
	}

	@RequestMapping(value="/method8/{id}/{name}")
	@ResponseBody
	public String method8(@PathVariable("id") long id, @PathVariable("name") String name){
		return "method8 with id= "+id+" and name="+name;
	}
	
	@RequestMapping(value="/method7")
	@ResponseBody
	public String method8(@RequestParam("name") String name){
		return "name=" + name;
	}
	
	// TESTES FIM
}
