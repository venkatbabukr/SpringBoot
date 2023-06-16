package venkat.springboot.simple.chatgpt.endpoint;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/gptbot")
public class ChatgptBotEndpoint {

	@GetMapping(path = "/send", produces = MediaType.TEXT_PLAIN_VALUE)
	public String sendMessage(String message) {
		return "Will send this to GPT! " + message;
	}

}
