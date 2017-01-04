package au.com.optus.models;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

//@JsonIgnoreProperties(ignoreUnknown = true)
public class SearchText {
	
	//@JsonProperty("searchText")
    //private final Map <String, ArrayList<String>> searchText;
	private Map <String, Object> searchText;
    
    public SearchText(Map <String, Object> searchText) {
    	this.searchText = searchText;
    }
    



	public Map <String, Object> getSearchText() {
		return searchText;
	}
	
    
    
}
