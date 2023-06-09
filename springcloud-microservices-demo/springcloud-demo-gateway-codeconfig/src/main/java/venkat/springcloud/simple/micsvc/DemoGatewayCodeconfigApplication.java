package venkat.springcloud.simple.micsvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.StripPrefixGatewayFilterFactory;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
public class DemoGatewayCodeconfigApplication {

	// TODO: Need to see why this is not working...
//	@Bean
//	public GatewayFilter stripPrefixFilter() {
//		StripPrefixGatewayFilterFactory.Config prefixFilterConfig = new StripPrefixGatewayFilterFactory.Config();
//		prefixFilterConfig.setParts(1);
//		return new StripPrefixGatewayFilterFactory().apply(prefixFilterConfig);
//	}

    @Bean
    public RouteLocator appRoutes(RouteLocatorBuilder rlb) {
        return rlb.routes()
                .route(r1 -> r1.path("/svc1/**")
                                   .filters(f -> f.stripPrefix(1))
                		           .uri("lb://springcloud-demo-service1"))
                .route(r2 -> r2.path("/svc2/**")
                                   .filters(f -> f.stripPrefix(1))
                                   .uri("lb://springcloud-demo-service2"))
                .build();
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoGatewayCodeconfigApplication.class, args);
    }

}
