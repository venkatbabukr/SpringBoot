package venkat.springboot.simple.jpademo.actuator.health;

import org.springframework.boot.actuate.endpoint.web.WebEndpointResponse;
import org.springframework.boot.actuate.health.SimpleHttpCodeStatusMapper;
import org.springframework.boot.actuate.health.Status;
import org.springframework.stereotype.Component;

import venkat.springboot.simple.jpademo.actuator.health.Constants.CustomStatus;

/*
 * This will come into picture when we access localhost:8080/actuator/health/rand
 */
@Component
public class WarnStatusMapper extends SimpleHttpCodeStatusMapper {

	@Override
	public int getStatusCode(Status status) {
		return CustomStatus.WARN.equals(status) ? WebEndpointResponse.STATUS_TOO_MANY_REQUESTS
					: super.getStatusCode(status);
	}

}
