package au.com.optus.demo;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import au.com.optus.repositories.PojoRepo;


@SpringBootApplication
@ComponentScan(basePackages = { "au.com.optus.controllers" })
public class StartApp {
	
	//private static final Logger log = LoggerFactory.getLogger(StartApp.class);	
	
    public static void main(String[] args) {
    	
    	SpringApplication.run(StartApp.class, args);
//    	StartApp startapp = new StartApp();
//    	System.out.println("\ntestconfig\n");
//    	startapp.testconfig();
       
    }
    
//    public void testconfig () {
//    	
//    	PojoRepo prepo = new PojoRepo();
//    	try {
//			System.out.println(prepo.totalWordCount());
//		} catch (IOException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//    	
//    	try {
//    		StringBuilder b = new StringBuilder();
//			prepo.wordCount(10).forEach(b::append);
//			
//			System.out.println(b.toString());
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		};
//    	
//    }
    
}
