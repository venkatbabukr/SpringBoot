package venkat.springdata.simple.mongo.ua.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import lombok.Data;

@Data
public class UserActivityByDay {

	private String userId;
	private LocalDate activityDate;
	private LocalDateTime loginTime;
	private LocalDateTime logoutTime;
	private List<UserActivity> activities;

}
