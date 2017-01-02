package au.com.optus.repositories;


import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName="words", type  = "words", replicas = 0, shards = 1)
public class Documents {
	
}
