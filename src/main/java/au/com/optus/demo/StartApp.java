package au.com.optus.demo;

import org.apache.log4j.spi.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;


@SpringBootApplication
@ComponentScan(basePackages = { "au.com.optus.controllers" })
public class StartApp {
	
	//private static final Logger log = LoggerFactory.getLogger(StartApp.class);

    public static void main(String[] args) {
        SpringApplication.run(StartApp.class, args);
    }
    
    
}
