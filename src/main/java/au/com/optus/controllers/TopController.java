package au.com.optus.controllers;

import java.util.Optional;

import org.springframework.boot.ApplicationArguments;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import au.com.optus.handlers.GlobalExceptionHandler;


@RestController
public class TopController {
	
	@RequestMapping(value = {"/top", "top/{id}"})
	//@ResponseBody
	@ExceptionHandler
	public int top( @PathVariable Optional<Integer> id) {
		
		if (id.isPresent()) { return 1; }
		else { return 2; }
		
	}
	

}
