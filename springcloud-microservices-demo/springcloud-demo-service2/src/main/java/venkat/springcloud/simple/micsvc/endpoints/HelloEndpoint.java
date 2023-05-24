package venkat.springcloud.simple.micsvc.endpoints;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/svc2")
public class HelloEndpoint {

    @Value("${spring.application.name}")
    private String applicationName;

    @RequestMapping(path = "/hello", method = RequestMethod.GET, produces = MediaType.TEXT_PLAIN_VALUE)
    public String sayHello() {
        return String.format("%s says hello!", applicationName);
    }

}
