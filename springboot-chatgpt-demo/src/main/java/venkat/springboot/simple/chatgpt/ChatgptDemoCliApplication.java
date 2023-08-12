package venkat.springboot.simple.chatgpt;

import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.ConfigurableApplicationContext;

import venkat.springboot.simple.chatgpt.constants.CliApplicationConstants;

@SpringBootApplication
@ConditionalOnProperty(name = "app.standalone", havingValue = "true")
public class ChatgptDemoCliApplication implements CommandLineRunner {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(ChatgptDemoCliApplication.class, args);
		ctx.close();
	}

	public String getUserInputMessage() {
		System.out.println(CliApplicationConstants.USER_INPUT_PROMPT);
		Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
	}

	@Override
	public void run(String... args) throws Exception {
		String userInput = getUserInputMessage();
		while (!CliApplicationConstants.EXIT_USER_INPUT.equalsIgnoreCase(userInput)) {
			System.out.println("Will send this to ChatGPT: " + userInput);
			userInput = getUserInputMessage();
		}
	}

}
