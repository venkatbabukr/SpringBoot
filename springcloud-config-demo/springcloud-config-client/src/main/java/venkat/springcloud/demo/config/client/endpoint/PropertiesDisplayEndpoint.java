package venkat.springcloud.demo.config.client.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import venkat.springcloud.demo.config.client.pojo.LibraryConfigProperties;

@RestController
@RequestMapping(path = "/config")
@RefreshScope
public class PropertiesDisplayEndpoint {

	@Autowired
	private LibraryConfigProperties libraryProps;

	@RequestMapping(path = "/library", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public LibraryConfigProperties libraryProps() {
		return libraryProps;
	}

}
