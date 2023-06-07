package venkat.springcloud.demo.config.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import venkat.springcloud.demo.config.client.pojo.LibraryConfigProperties;

@SpringBootApplication
@EnableConfigurationProperties(LibraryConfigProperties.class)
public class ConfigClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfigClientApplication.class, args);
	}

}
