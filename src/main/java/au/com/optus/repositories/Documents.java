package au.com.optus.repositories;


import java.util.List;

import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.client.ElasticsearchClient;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;

@Document(indexName="resource", type  = "files", replicas = 0, shards = 1)
public class Documents {
	
	public int searchByText (String text) {
        
		SearchRequestBuilder searchRequestBuilder = new SearchRequestBuilder(null, null);
		return 1;
		
	}
	

}
