package au.com.optus.controllers;

import java.util.Map;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SearchTextController {
	
	@RequestMapping(value = "/searchText",
			method = RequestMethod.POST,
			
			produces = MediaType.APPLICATION_JSON_VALUE)
	private int searchText(@RequestBody Map<String, Object> payload) {
		
		System.out.println(payload);
		
		return 1;
	}

}
