package dev.louiiuol.etin;

import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration.AccessLevel;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**  <p> Main application class providing spring boot main method and configuration elements. <p>
 * @see org.springframework.boot.SpringApplication;
 * @see org.modelmapper.ModelMapper;
 * @see org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration
 * @see org.springframework.validation.beanvalidation.LocalValidatorFactoryBean; */
@SpringBootApplication(scanBasePackages = "dev.louiiuol")
public class EtinApplication {

	/** <p> Main method running the entire application. </p>
	 * @param*/
	public static void main(String[] args) {
		SpringApplication.run(EtinApplication.class, args);
	}

	/** <p> Default {@code LocalValidatorFactoryBean} to ease messages and tests. </p>
	 * <li>Tell Spring to use the application {@code messages.properties}.</li>
	 * <li>Give convenient validator bean to test DTO validation annotations.</li>
	 * @param
	 * @return a validator factory */
	@Bean
	protected LocalValidatorFactoryBean validator(MessageSource messageSource) {
		LocalValidatorFactoryBean validatorFactoryBean = new LocalValidatorFactoryBean();
		validatorFactoryBean.setValidationMessageSource(messageSource);
		return validatorFactoryBean;
	}

	/** <p> Default {@code ModelMapper} bean that configures mapping between DTO and entities. </p>
	 * <i> field matching is enabled with private access and standard matching strategy. </i>
	 * @return an instance of {@code ModelMapper} */
	@Bean
	protected ModelMapper modelMapper() {
		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration().setFieldMatchingEnabled(true).setFieldAccessLevel(AccessLevel.PRIVATE).setMatchingStrategy(MatchingStrategies.STANDARD);
		return mapper;
	}

	/** <p> The password encoder bean for the application. Used for client and users. </p>
     * @return a password encoder */
    @Bean
	protected PasswordEncoder passwordEncoder() { return new BCryptPasswordEncoder(); }

	@Bean
public CorsFilter corsFilter() {
    final UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
    final CorsConfiguration corsConfiguration = new CorsConfiguration();
    corsConfiguration.setAllowCredentials(true);
    corsConfiguration.addAllowedOrigin("*");
    corsConfiguration.addAllowedHeader("*");
    corsConfiguration.addAllowedMethod("*");
    urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);
    return new CorsFilter(urlBasedCorsConfigurationSource);
}

}