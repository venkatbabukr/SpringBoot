package venkat.springdata.simple.mongo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class SpringdataMongoDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringdataMongoDemoApplication.class, args);
	}

}
