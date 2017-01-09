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
	
	@RequestMapping(value = {"/top", "top/{id}"}, produces = "text/csv")
	@ResponseBody
	public String top( @PathVariable Optional<Integer> id) {
		
		//Pojo Repo for search & topCount operatins
		PojoRepo prepo = new PojoRepo();
		
		long limit;
		StringBuilder csvList = new StringBuilder();
		
		//set limit=1, if null or zero
		if (id.isPresent() && id.get() != 0) {
			 limit = id.get();
		} else { 
			limit = 1;
		}
		
		try {
		   prepo.wordCount(limit).forEach(w -> { 
			   csvList.append(w);
			   csvList.append(",");
		   });
		} catch (IOException e) {
			//print to logs when it's configured
			//return generic message - internal error
			e.printStackTrace();
		} catch (Exception ex) {
			System.out.println(ex.getCause());
		}
		System.out.println(csvList.toString());
		return csvList.length() > 0 ? csvList.substring(0, csvList.length() - 1): "";

	}
	    
}