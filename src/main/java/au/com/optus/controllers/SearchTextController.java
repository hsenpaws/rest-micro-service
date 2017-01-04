package au.com.optus.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import au.com.optus.handlers.GlobalExceptionHandler;
import au.com.optus.models.SearchText;

@RestController
public class SearchTextController {
	
	@RequestMapping(value = "/search",
			method = RequestMethod.POST)
	public  int searchText(@RequestBody Map <String, ArrayList<String>> searchText) {
	//public  int searchText(@RequestBody SearchText searchText) {	
	
		searchText.forEach((i,j) -> {
			j.forEach( (k) -> System.out.println(k));
			
			});
		
		return 1;
	}
	

}