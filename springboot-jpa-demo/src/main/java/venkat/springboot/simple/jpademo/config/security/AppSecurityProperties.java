package venkat.springboot.simple.jpademo.config.security;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Data;

@ConfigurationProperties(prefix = "app.security")
@Data
public class AppSecurityProperties {

	private boolean enabled;

	private String[] permitUrls;

}
