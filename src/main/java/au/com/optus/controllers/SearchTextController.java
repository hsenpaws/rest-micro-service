package au.com.optus.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import au.com.optus.repositories.PojoRepo;


@RestController
public class SearchTextController {
	
	private static HashMap<String, Integer> wordHashMap;
	
	// Search for words in text file and returns counts of word
	// Also work with list of words
	@RequestMapping(value = "/search", method = RequestMethod.POST
			 ,produces = "application/json" )
	public Map<String, Integer> searchText(@RequestBody Map <String, ArrayList<String>> searchText) {
		List<String> searchWords = new ArrayList<String>();
		searchText.forEach((i,j) -> j.forEach( (k) -> {
			searchWords.add(k.toString());
		}));

		PojoRepo prepo = new PojoRepo();
		Map<String , Integer> returnHashMap = new HashMap<String, Integer>();
	
		try {
			Map<Object, Object> wordMap = prepo.wordCountAll().collect(
					Collectors.toMap(
				            e -> e.getKey(),
				            e -> e.getValue()
					));
			
			for (String tmpString : searchWords) {
				Integer value = (Integer) wordMap.get(tmpString.toLowerCase());
				System.out.print("tmpString=" + tmpString.toString() + "value=" + value);
				returnHashMap.put(tmpString, value == null ? 0 : value);
			}
//			
			returnHashMap.forEach((i,j) -> System.out.println("i=" + i.toString() + "j=" + j.toString()));
			} catch (IOException e) {
				e.printStackTrace();
			} catch (Exception ex) {
				System.out.println(ex.getCause());
			} 
			return returnHashMap;		
	}
	
	
    
}