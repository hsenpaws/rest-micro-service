package au.com.optus.repositories;

import java.util.List;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface DocumentRepository extends ElasticsearchRepository<Documents, String> {
	
	public Documents findByText(String text);
	public List<Documents> findTopXByName(String name, int limit);

}
