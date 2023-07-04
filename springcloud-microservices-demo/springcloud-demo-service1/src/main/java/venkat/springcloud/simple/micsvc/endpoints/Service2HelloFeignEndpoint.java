package venkat.springcloud.simple.micsvc.endpoints;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import venkat.springcloud.simple.feign.client.Service2Client;

@RestController
public class Service2HelloFeignEndpoint {
	
    @Value("${spring.application.name}")
    private String applicationName;
    
    @Autowired
    private Service2Client svc2Client;

    @RequestMapping(path = "/hello2", method = RequestMethod.GET, produces = MediaType.TEXT_PLAIN_VALUE)
    public String sayHello() {
    	String svc2HelloResponse = svc2Client.sayHello();
        return String.format("%s forwarded request to svc2, response from svc2: %s", applicationName, svc2HelloResponse);
    }

}
