package venkat.springboot.simple.redis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import venkat.springboot.simple.redis.config.properties.RedisConfigProperties;

@SpringBootApplication
@EnableConfigurationProperties(RedisConfigProperties.class)
public class RedisDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(RedisDemoApplication.class, args);
	}

}
