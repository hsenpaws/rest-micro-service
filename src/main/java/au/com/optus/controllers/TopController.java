package au.com.optus.controllers;

import java.io.IOException;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import au.com.optus.repositories.PojoRepo;

@RestController
public class TopController {
	
	PojoRepo prepo;
	
	@RequestMapping(value = {"/top", "top/{id}"}, method = RequestMethod.POST) //, produces = "text/csv")
	//@ResponseBody
	public String top( @PathVariable Optional<Integer> id) {
		
		
		Stream<Entry<String, Integer>> result = null;
		Integer limit;
		
		if (id.isPresent() && id.get() != 0) {
			 limit = id.get();
		}
		else { 
			limit = 1;
		}
		
		try {
		 result = prepo.wordCount(limit);
		} catch (IOException e) {
			//print to logs when it's configured
			//return generic message - internal error
			e.printStackTrace();
		} catch (Exception ex) {
			System.out.println(ex.getCause());
		}
		
		StringBuilder csvList = new StringBuilder();
		result.forEach(csvList::append);
		return csvList.toString();
	}
	    
}