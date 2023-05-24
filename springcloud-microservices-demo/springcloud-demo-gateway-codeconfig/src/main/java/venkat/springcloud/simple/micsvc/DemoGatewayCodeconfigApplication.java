package venkat.springcloud.simple.micsvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoGatewayCodeconfigApplication {

    @Bean
    public RouteLocator appRoutes(RouteLocatorBuilder rlb) {
        return rlb.routes()
                .route(r1 -> r1.path("/svc1/**").uri("http://localhost:8081/"))
                .route(r2 -> r2.path("/svc2/**").uri("http://localhost:8082/"))
                .build();
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoGatewayCodeconfigApplication.class, args);
    }

}