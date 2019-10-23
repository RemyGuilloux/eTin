package dev.louiiuol.etin;

import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration.AccessLevel;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EtinApplication {

	public static void main(String[] args) {
		System.out.println("Application STARTING");
		SpringApplication.run(EtinApplication.class, args);
	}

	@Bean
    public ModelMapper mapper() {
		ModelMapper mapper = new ModelMapper(); 
		mapper.getConfiguration().setFieldMatchingEnabled(true).setFieldAccessLevel(AccessLevel.PRIVATE).setMatchingStrategy(MatchingStrategies.STRICT); 
		return mapper;
    }
}
