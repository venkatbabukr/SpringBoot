package venkat.springboot.simple.jpademo.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
@ConditionalOnProperty(name = "app.security.config", havingValue = "AppBasicSecurityConfig")
// @ConditionalOnExpression("${app.security.enabled:false} and '${app.security.config}'.equals('AppBasicSecurityConfig')")
@EnableWebSecurity
public class AppBasicSecurityConfig {

	@Autowired
	private AppSecurityProperties securityProperties;

	@Bean
    public PasswordEncoder passwordEncoder() {
        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        return encoder;
    }

	@Bean
	public InMemoryUserDetailsManager userDetailsService(PasswordEncoder passwordEncoder) {
	    UserDetails user = User.withUsername("user")
	            .password(passwordEncoder.encode("password"))
	            .roles("USER")
	            .build();
	    log.debug("Adding UserDetails user/password=user/password");

	    UserDetails admin = User.withUsername("admin")
	            .password(passwordEncoder.encode("admin"))
	            .roles("USER", "ADMIN")
	            .build();
	    log.debug("Adding UserDetails user/password=admin/admin");

	    return new InMemoryUserDetailsManager(user, admin);
	}

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    	log.debug("Sec enabled? {} ", securityProperties.isEnabled());
    	
    	// Required to get h2-console working... as h2-console works using frames...
    	http.headers().frameOptions().sameOrigin();

    	if (securityProperties.isEnabled()) {
	    	http.csrf()
	    	    // This repository is sufficient and will work even whith stateless sessions.
	    	    // Two common CSRF tokens:
	    	    //    1. Session-based tokens: Tokens tied to User session management
	    	    //    2. Stateless tokens: Compare the token present in cookie with the token sent in header.
	    	    //           Works simply because an attacker site can't generate the header in their
	    	    //           embedded pages on the fly.
	    		.csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());
	
	    	http.sessionManagement()
	    	        .sessionCreationPolicy(SessionCreationPolicy.STATELESS);

	    	String[] permitUrls = securityProperties.getPermitUrls();
	    	if (permitUrls != null && permitUrls.length > 0) {
	    		http.csrf().ignoringAntMatchers(permitUrls);
	    		http.authorizeRequests().antMatchers(permitUrls).permitAll();
	    	}
	    	http.authorizeRequests()
	                .anyRequest()
	                .authenticated()
	                .and()
	                .httpBasic();
    	} else {
    		http.csrf().disable();
    		http.authorizeRequests().anyRequest().permitAll();
    	}
        return http.build();
    }
	
}
