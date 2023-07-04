package venkat.springcloud.simple.feign.client;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import feign.FeignException.BadGateway;
import feign.FeignException.ServiceUnavailable;

@FeignClient(contextId="fc1", name="springcloud-demo-service2", fallbackFactory = Service2ClientFallBackFactory.class)
//@FeignClient(contextId="fc1", name="springcloud-demo-service2", fallback = Service2ClientFallBack.class)
public interface Service2Client {

	@RequestMapping(path = "/hello", method = RequestMethod.GET, consumes = MediaType.TEXT_PLAIN_VALUE)
	String sayHello();

}

//@Component
//class Service2ClientFallBack implements Service2Client {
//
//	@Override
//	public String sayHello() {
//		// TODO Auto-generated method stub
//		return "hello from fc1 feign client fallback!";
//	}
//
//}

@Component
class Service2ClientFallBackFactory implements FallbackFactory<Service2Client> {

	private Map<Class<? extends Throwable>, String> exceptionRspMsgMap;

	public Service2ClientFallBackFactory() {
		exceptionRspMsgMap = new HashMap<>();
		exceptionRspMsgMap.put(ServiceUnavailable.class, "Service is unavailable!");
		exceptionRspMsgMap.put(BadGateway.class, "Bad gateway for call!");
	}

	@Override
	public Service2Client create(Throwable cause) {
		return new Service2Client() {

			@Override
			public String sayHello() {
				return String.format("Feign call failed due to {%s}",
						Optional
							.ofNullable(exceptionRspMsgMap.get(cause.getClass()))
								.orElse("exception - " + cause.getMessage()));
			}
			
		};
	}
	
}
