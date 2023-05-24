package venkat.springcloud.simple.micsvc.endpoint;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/gateway")
public class GatewayFallbackEndpoint {

    @RequestMapping(path = "/fallback", method = RequestMethod.GET, produces = MediaType.TEXT_PLAIN_VALUE)
    public String fallbackMessage() {
        return "Gateway fall back...";
    }

}
