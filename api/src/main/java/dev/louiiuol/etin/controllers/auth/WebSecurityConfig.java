package dev.louiiuol.etin.controllers.auth;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    /** <p> Defines as Spring bean the authentication manager for this application. </p>
     * @return the authentication manager
     * @see AuthenticationManager#authenticate(org.springframework.security.core.Authentication) */
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception { return super.authenticationManagerBean(); }
}
