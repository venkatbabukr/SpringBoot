package venkat.springboot.simple.kafka.config.properties;

import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;

import jakarta.annotation.PostConstruct;
import lombok.Data;
import lombok.Setter;

@Setter
@ConfigurationProperties(prefix = "app.kafka.props")
public class KafkaConfigProperties {
	
	private Map<String, String> common;

	private Map<String, String> consumer;

	private Map<String, String> producer;

	@PostConstruct
	public void init() {
		consumer.putAll(common);
		producer.putAll(common);
	}

	public Map<String, String> getProducerProps() {
		return producer;
	}

	public Map<String, String> getConsumerProps() {
		return consumer;
	}

}
