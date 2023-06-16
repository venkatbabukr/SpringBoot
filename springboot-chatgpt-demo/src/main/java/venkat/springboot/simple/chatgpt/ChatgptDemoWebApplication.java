package venkat.springboot.simple.chatgpt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;

@SpringBootApplication
@ConditionalOnProperty(name = "app.webapp", havingValue = "true")
public class ChatgptDemoWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChatgptDemoWebApplication.class, args);
	}

}
