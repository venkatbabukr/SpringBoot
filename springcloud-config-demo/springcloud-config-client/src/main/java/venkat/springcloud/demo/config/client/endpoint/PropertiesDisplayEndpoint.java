package venkat.springcloud.demo.config.client.endpoint;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/config")
public class PropertiesDisplayEndpoint {

	@Value("${demo.prop1}")
	private String prop1;
	
	@Value("${demo.prop2}")
	private String prop2;

	@RequestMapping(path = "/library", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Map<String, String> libraryProps() {
		Map<String, String> props = new HashMap<>();
		props.put("prop1", prop1);
		props.put("prop2", prop2);
		return props;
	}

}
