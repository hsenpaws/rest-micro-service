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
import org.springframework.web.bind.annotation.RestController;

import au.com.optus.repositories.PojoRepo;

@RestController
public class TopController {
	
	PojoRepo prepo;
	
	@RequestMapping(value = {"/top", "top/{id}"}, method = RequestMethod.POST)
	@ExceptionHandler
	public int top( @PathVariable Optional<Integer> id) throws IOException {
				 
		if (id.isPresent() && id.get() != 0) {
			prepo.wordCount(id.get());
		}
		else { 
			 prepo.wordCount(1);
		}
		
		return 1;
	}
	

	    
}