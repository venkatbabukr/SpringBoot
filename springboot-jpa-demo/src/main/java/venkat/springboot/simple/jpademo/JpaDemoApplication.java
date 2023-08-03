package venkat.springboot.simple.jpademo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import venkat.springboot.simple.jpademo.common.entity.audit.AppAuditorAwareImpl;
import venkat.springboot.simple.jpademo.constants.ApplicationConstants.SecurityConstants;

@SpringBootApplication
@ConfigurationPropertiesScan
@ComponentScan(basePackages = {"venkat.common", "venkat.springboot.simple.jpademo"})
@EnableJpaAuditing(auditorAwareRef = "auditorAware", modifyOnCreate = false)
@EnableJpaRepositories
// @EnableAspectJAutoProxy
public class JpaDemoApplication {

	public static void main(String[] args) {
		// SpringApplication.run(JpaDemoApplication.class, args);
		SpringApplication application = new SpringApplication(JpaDemoApplication.class);
        application.setAdditionalProfiles(SecurityConstants.SECURITY_PROFILE_NAME);
        application.run(args);
	}

	@Bean
	public AuditorAware<String> auditorAware() {
		return new AppAuditorAwareImpl();
	}

}
