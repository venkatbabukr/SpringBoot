package venkat.springboot.simple.jpademo.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@ConditionalOnProperty(name = "app.security.config", havingValue = "AppBasicSecurityConfig")
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

	    UserDetails admin = User.withUsername("admin")
	            .password(passwordEncoder.encode("admin"))
	            .roles("USER", "ADMIN")
	            .build();

	    return new InMemoryUserDetailsManager(user, admin);
	}

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    	System.out.println("Venkat app sec enabled? " + securityProperties.isEnabled());
        http.authorizeRequests()
            .anyRequest()
            .authenticated()
            .and()
            .httpBasic();
        return http.build();
    }
	
}
