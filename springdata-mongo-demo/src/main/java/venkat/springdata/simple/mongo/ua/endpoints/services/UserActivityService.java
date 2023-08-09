package venkat.springdata.simple.mongo.ua.endpoints.services;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import venkat.springdata.simple.mongo.ua.model.UserActivity;
import venkat.springdata.simple.mongo.ua.model.UserActivityByDay;
import venkat.springdata.simple.mongo.ua.repos.UserActivityRepo;

@Service
public class UserActivityService {

	@Autowired
	UserActivityRepo uaRepo;

	public UserActivity logActivity(UserActivity ua) {
		//ua.setUuid(UUID.randomUUID().toString());
		ua.setUuid(UUID.randomUUID());
		ua.setActivityTime(LocalDateTime.now());
		return uaRepo.save(ua);
	}

	public List<UserActivityByDay> getForYearMonth(int year, int month) {
		YearMonth ym = YearMonth.of(year, month);
		return uaRepo.findBetweenDates(ym.atDay(1), ym.atEndOfMonth());
	}

}
