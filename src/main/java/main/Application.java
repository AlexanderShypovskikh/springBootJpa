package main;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class Application {
    
	 private static final Logger log =  LoggerFactory.getLogger(Application.class);
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class);
	}
	
	@Bean
	public CommandLineRunner demo(CustomerRepository repository) {
		return (args) -> {
			repository.save(new Customer("Jack", "Bauer"));
			repository.save(new Customer("Chloe", "Briayan"));
			repository.save(new Customer("Kim", "Palmer"));
			repository.save(new Customer("David", "Dessler"));
		
		  
			for(Customer customer : repository.findAll()) {
				System.out.println(customer.toString());
			} 
			
			repository.findById(1L)
			          .ifPresent(customer ->{
			        	  log.info("Customer found with findById (1L)");
			        	  log.info("_________________________________");
			        	  log.info(customer.toString());
			          });
			
      	  System.out.println("Customer found with findByLastName ('Dessler')");
      	  repository.findByLastName("Dessler").forEach(dessler ->{
      		log.info(dessler.toString());
      	  }); 
			
      	System.out.println("Customer found with findByFirstName ('Kim')");
    	  repository.findByFirstName("Kim").forEach(kim ->{
    		log.info(kim.toString());
    	  }); 
			
		};
	}
}
























