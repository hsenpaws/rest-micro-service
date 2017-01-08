package au.com.optus.controllers;

import java.util.ArrayList;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

import javax.xml.ws.RequestWrapper;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import au.com.optus.models.Greeting;


@RestController
public class SearchTextController {
	
	// Search for words in text file and returns counts of word
	// Also work with list of words
	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public  int searchText(@RequestBody Map <String, ArrayList<String>> searchText) {
	//public  int searchText(@RequestBody SearchText searchText) {	
	
//		searchText.forEach((i,j) -> {
//			j.forEach( (k) -> System.out.println(k));
//			
//			});
		
		return 1;
	}
	
	

    
}