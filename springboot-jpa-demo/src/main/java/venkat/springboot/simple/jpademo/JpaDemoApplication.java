package venkat.springboot.simple.jpademo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

import venkat.springboot.simple.jpademo.constants.ApplicationConstants.SecurityConstants;

@SpringBootApplication
@ConfigurationPropertiesScan
public class JpaDemoApplication {

	public static void main(String[] args) {
		// SpringApplication.run(JpaDemoApplication.class, args);
		SpringApplication application = new SpringApplication(JpaDemoApplication.class);
        application.setAdditionalProfiles(SecurityConstants.SECURITY_PROFILE_NAME);
        application.run(args);
	}

}
