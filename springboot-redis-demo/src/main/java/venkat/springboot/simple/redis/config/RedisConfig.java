package venkat.springboot.simple.redis.config;

import java.time.Duration;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisPassword;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettucePoolingClientConfiguration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericToStringSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import io.lettuce.core.ClientOptions;
import io.lettuce.core.resource.ClientResources;
import venkat.springboot.simple.redis.config.properties.RedisConfigProperties;

@Configuration
public class RedisConfig {

	@Autowired
	private RedisConfigProperties redisConfigProps;

	private GenericObjectPoolConfig<Object> getPoolConfig() {

		GenericObjectPoolConfig<Object> poolConfig = new GenericObjectPoolConfig<Object>();
		poolConfig.setMinIdle(redisConfigProps.getConnectionPoolConfig().getMinimumIdle());
		poolConfig.setMaxIdle(redisConfigProps.getConnectionPoolConfig().getMaximumIdle());
		poolConfig.setMaxTotal(redisConfigProps.getConnectionPoolConfig().getMaximumConnection());
		return poolConfig;
	}

	@Bean
	public ClientOptions clientOptions() {
		return ClientOptions.builder().disconnectedBehavior(ClientOptions.DisconnectedBehavior.REJECT_COMMANDS)
				.autoReconnect(true).build();
	}

	@Bean
	LettucePoolingClientConfiguration lettuceMessagePoolConfig(ClientOptions options, ClientResources dcr) {
		return LettucePoolingClientConfiguration.builder().clientOptions(options).poolConfig(getPoolConfig())
		        .clientResources(dcr)
		        .commandTimeout(Duration.ofMinutes(redisConfigProps.getConnectionPoolConfig().getTimeoutMinutes()))
		        .build();
	}

	@Bean
	public LettuceConnectionFactory getLettuceConnectionFactory(LettucePoolingClientConfiguration lettucePoolConfig) {
		RedisStandaloneConfiguration redisConf = new RedisStandaloneConfiguration();
		redisConf.setHostName(redisConfigProps.getHost());
		redisConf.setPort(redisConfigProps.getPort());
		redisConf.setDatabase(redisConfigProps.getDb());
		redisConf.setPassword(RedisPassword.of(redisConfigProps.getPassword()));

		return new LettuceConnectionFactory(redisConf, lettucePoolConfig);
	}

	@Bean
	public RedisTemplate<String, Object> redisTemplate(LettucePoolingClientConfiguration lettucePoolConfig) {
		final RedisTemplate<String, Object> template = new RedisTemplate<String, Object>();
		template.setKeySerializer(new StringRedisSerializer());
		template.setConnectionFactory(getLettuceConnectionFactory(lettucePoolConfig));
		template.setValueSerializer(new GenericToStringSerializer<Object>(Object.class));
		return template;
	}

}
