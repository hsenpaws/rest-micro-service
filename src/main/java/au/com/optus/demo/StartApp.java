package au.com.optus.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan(basePackages = { "au.com.optus.controllers" })
public class StartApp {
	
	//private static final Logger log = LoggerFactory.getLogger(StartApp.class);

    public static void main(String[] args) {
        SpringApplication.run(StartApp.class, args);
    }
    
    
}
