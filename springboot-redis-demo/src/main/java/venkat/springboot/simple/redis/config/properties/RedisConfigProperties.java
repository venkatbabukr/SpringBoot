package venkat.springboot.simple.redis.config.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Data;

@Data
@ConfigurationProperties(prefix = "app.redis")
public class RedisConfigProperties {

	private String host;
	private int port;
	private String password;
	private Integer db;

	private RedisConnectionPoolConfigProperties connectionPoolConfig;

}
