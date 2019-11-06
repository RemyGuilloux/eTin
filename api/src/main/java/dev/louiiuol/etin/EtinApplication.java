package dev.louiiuol.etin;

import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration.AccessLevel;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

/**
 * Main application class providing spring boot main method and configuration
 * elements.
 */
@SpringBootApplication(exclude = { UserDetailsServiceAutoConfiguration.class })
public class EtinApplication {

	/**
	 * Main method running the entire application.
	 * 
	 * @param args optional arguments.
	 */
	public static void main(String[] args) {
		SpringApplication.run(EtinApplication.class, args);
	}

	/**
	 * Default {@code LocalValidatorFactoryBean} to ease messages and tests.
	 * <p>
	 * <ul>
	 * <li>Tell Spring to use the application {@code messages.properties}.</li>
	 * <li>Give convenient validator bean to test DTO validation annotations.</li>
	 *
	 * @param messageSource a message source strategy
	 * @return a validator factory
	 */
	@Bean
	protected LocalValidatorFactoryBean validator(MessageSource messageSource) {
		LocalValidatorFactoryBean validatorFactoryBean = new LocalValidatorFactoryBean();
		validatorFactoryBean.setValidationMessageSource(messageSource);
		return validatorFactoryBean;
	}

	/**
	 * Default {@code ModelMapper} bean that configures mapping between DTO and
	 * entities.
	 * <p>
	 * field matching is enabled with private access and standard matching strategy.
	 * 
	 * @return an instance of {@code ModelMapper}
	 */
	@Bean
	protected ModelMapper modelMapper() {
		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration().setFieldMatchingEnabled(true).setFieldAccessLevel(AccessLevel.PRIVATE)
				.setMatchingStrategy(MatchingStrategies.STANDARD);
		return mapper;
	}

	/**
	 * Default {@code PasswordEncoder} bean that encode a given password
	 * 
	 * @return an instance of {@code PasswordEncoder}
	 */
	@Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
