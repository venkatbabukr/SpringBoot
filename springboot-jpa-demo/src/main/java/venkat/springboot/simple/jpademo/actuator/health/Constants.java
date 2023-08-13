package venkat.springboot.simple.jpademo.actuator.health;

import org.springframework.boot.actuate.health.Status;

public final class Constants {
	
	private Constants() { };

	public static final class CustomStatus {
		public static final Status WARN = new Status("WARN", "Our own warning status code!");
	}

}
