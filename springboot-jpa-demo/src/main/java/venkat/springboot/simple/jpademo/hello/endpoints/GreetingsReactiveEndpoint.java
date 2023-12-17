package venkat.springboot.simple.jpademo.hello.endpoints;

import java.time.Duration;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;

@RestController
@RequestMapping(path = "/greet")
public class GreetingsReactiveEndpoint {

    @RequestMapping(method = RequestMethod.GET, path = "/hello-stream", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<String> greet() {
        return Flux.interval(Duration.ofSeconds(1))
                    .map(sequence -> String.format("Hello %d", sequence));
    }

}
