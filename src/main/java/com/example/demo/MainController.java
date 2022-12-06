package com.example.demo;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collections;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

@Controller
@RequestMapping(value="/")
public class MainController {

	
	@GetMapping(value="home")
	public ResponseEntity<Object> getMessage() throws URISyntaxException {
		
		
		RestTemplate restTemplate = new RestTemplate();
	     //
		final String baseUrl = "https://api.agify.io?name=bella";
		URI uri = new URI(baseUrl);
		     
		HttpHeaders headers = new HttpHeaders();
		//headers.set("X-COM-LOCATION", "USA");
		 
		//HttpEntity<Employee> requestEntity = new HttpEntity<>(null, headers);
		 
		//restTemplate.exchange(uri, HttpMethod.GET, requestEntity, String.class);
		ResponseEntity<Employee> e=restTemplate.getForEntity(uri,Employee.class);
		Employee em=e.getBody();
		System.out.println(em.getName());
		
		
		MetaData metaData=new MetaData();
		metaData.setAge(em.getAge());
		metaData.setName(em.getName());
		
		return new ResponseEntity<Object>(metaData, HttpStatus.OK);
	}
	
}
