package au.com.optus.repositories;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

//Pojo search/top functions - implemented for single file
@Component
@PropertySource(value = "application.properties")
public class PojoRepo {

	private  String prepo = "/tmp/afile";
	private  Stream<String> fileStream;
	
	

	//Count total number of words in a file
	public long totalWordCount() throws IOException {
		
		return (Files.lines(Paths.get(prepo)).parallel().flatMap(
				l -> Arrays.stream(l.split("\\s+"))).map(w -> w.replaceAll("[,.]$" , ""))
				.count());
		
	}
	
	//count each word & it's frequency in a file
	//un-sorted list
	public Stream<Entry<String, Integer>> wordCount (Integer limit) throws IOException {
				
//		return (Files.lines(Paths.get(prepo)).map(w -> w.split("\\s+"))
//                .flatMap(Arrays::stream)
//                .map(w -> w.replaceAll("[,.]$" , ""))
//                .map(String::toLowerCase)
//                .collect(
//                        Collectors.groupingBy(Function.identity(),
//                                Collectors.counting())));
		
		return Files.lines(Paths.get(prepo))
	     .flatMap(line -> Stream.of(line.split("\\s+")))
	     .map(w -> w.replaceAll("[,.]$" , ""))
	     .map(String::toLowerCase)
	     .collect(Collectors.toMap(word -> word, word -> 1, Integer::sum))
	     .entrySet()
	     .stream()
	     .sorted((a, b) -> a.getValue() == b.getValue() ? a.getKey().compareTo(b.getKey()) : b.getValue() - a.getValue())
	     .limit(limit);
	     
	    // .forEach(System.out::println);
                                
	}
}
