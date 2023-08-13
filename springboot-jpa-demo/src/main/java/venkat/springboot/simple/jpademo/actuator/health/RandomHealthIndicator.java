package venkat.springboot.simple.jpademo.actuator.health;

import java.util.concurrent.ThreadLocalRandom;

import org.springframework.boot.actuate.autoconfigure.health.ConditionalOnEnabledHealthIndicator;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

import venkat.springboot.simple.jpademo.actuator.health.Constants.CustomStatus;

/*
 * 
 * Reference https://www.baeldung.com/spring-boot-health-indicators
 * 
 */
@Component("rand")
@ConditionalOnEnabledHealthIndicator("rand")
public class RandomHealthIndicator implements HealthIndicator {

	@Override
	public Health health() {
        Health.Builder status = Health.up();
        
        double downChance = ThreadLocalRandom.current().nextDouble();
        if (downChance > 0.9) {
        	status = Health.status(CustomStatus.WARN)
        						.withException(new RuntimeException("Bad luck!"));
        }
		return status
			.withDetail("description", "This is a custom random health indicator created inside app!")
			.withDetail("downChance", downChance)
			.build();
	}

}
