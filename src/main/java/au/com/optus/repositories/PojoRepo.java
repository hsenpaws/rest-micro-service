package au.com.optus.repositories;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

//Pojo search/top functions - implemented for single file
@Component
public class PojoRepo {
	
	//FiePath to Read Article from
	//This should be a Object which can handle File/Directory etc.
	private static String prepo;
	
	public PojoRepo() {
		if(prepo == null) setPrepo();
	}

	
	//Count total number of words in a file
	public long totalWordCount() throws IOException {
		
		return (Files.lines(Paths.get(prepo)).parallel().flatMap(
				l -> Arrays.stream(l.split("\\s+"))).map(w -> w.replaceAll("[,.]$" , ""))
				.count());
		
	}
	
	//count each word & it's frequency in a file
	//sorted list		
	public Stream<Entry<String, Integer>> wordCount (long limit) throws IOException {
			
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
	
	//count all words
	public Stream<Entry<String, Integer>> wordCountAll () throws IOException {
		
		//System.out.println(prepo.toString());
		
		return Files.lines(Paths.get(prepo))
				.flatMap( (l) -> Stream.of(l.split("\\s+")))
				.map((w) -> w.replaceAll("[,.]$", ""))
				.map(String::toLowerCase)
				.collect(Collectors.toMap((w) -> (w), (w) -> 1, Integer::sum))
				.entrySet()
				.stream();
			                                 
	}
	
	//Getter-Setter - Setting filepath as static value
	public static void setPrepo() {
		Properties prop = new Properties();
		try {
			prop.load(PojoRepo.class.getClassLoader().getResourceAsStream("application.properties"));
		} catch (IOException e) {
			// 
			System.out.println("ERROR: application.properties not in classpath" + e.getMessage());
		}
		PojoRepo.prepo = prop.getProperty("app.file.path");
	}
	
	public String getPrepo() {
		return prepo;
	}
}
