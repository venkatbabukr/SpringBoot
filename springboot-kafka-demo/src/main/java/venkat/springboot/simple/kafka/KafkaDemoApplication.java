package venkat.springboot.simple.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.ConfigurableApplicationContext;

import venkat.springboot.simple.kafka.config.properties.KafkaConfigProperties;

@SpringBootApplication
@ConfigurationPropertiesScan
public class KafkaDemoApplication implements CommandLineRunner {

	@Autowired
	private KafkaConfigProperties kafkaProps;

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(KafkaDemoApplication.class);
		ConfigurableApplicationContext ctx = app.run(args);
		ctx.close();
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Hi Venkat here are props:");
		System.out.println("Producer props: " + kafkaProps.getProducerProps());
		System.out.println("Consumer props: " + kafkaProps.getConsumerProps());
	}

}
