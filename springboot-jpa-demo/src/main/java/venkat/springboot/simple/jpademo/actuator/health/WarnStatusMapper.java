package venkat.springboot.simple.jpademo.actuator.health;

import org.springframework.boot.actuate.endpoint.web.WebEndpointResponse;
import org.springframework.boot.actuate.health.HttpCodeStatusMapper;
import org.springframework.boot.actuate.health.SimpleHttpCodeStatusMapper;
import org.springframework.boot.actuate.health.Status;
import org.springframework.stereotype.Component;

@Component
public class WarnStatusMapper extends SimpleHttpCodeStatusMapper implements HttpCodeStatusMapper {

	@Override
	public int getStatusCode(Status status) {
		return Constants.WARN.equals(status) ? WebEndpointResponse.STATUS_TOO_MANY_REQUESTS
					: super.getStatusCode(status);
	}

}
