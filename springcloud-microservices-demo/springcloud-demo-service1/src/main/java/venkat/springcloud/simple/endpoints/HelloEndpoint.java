package venkat.springcloud.simple.endpoints;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/hello")
public class HelloEndpoint {

    @RequestMapping(path = "/msg", method = RequestMethod.GET, produces = MediaType.TEXT_PLAIN_VALUE)
    public String sayHello() {
        return "Demo Service1 says hello!";
    }

}
