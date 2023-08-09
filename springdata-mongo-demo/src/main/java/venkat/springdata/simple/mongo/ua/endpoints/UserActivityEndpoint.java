package venkat.springdata.simple.mongo.ua.endpoints;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import venkat.springdata.simple.mongo.ua.endpoints.services.UserActivityService;
import venkat.springdata.simple.mongo.ua.model.UserActivity;
import venkat.springdata.simple.mongo.ua.model.UserActivityByDay;

@RestController
@RequestMapping(path = "/ua")
public class UserActivityEndpoint {
	
	@Autowired
	private UserActivityService uaSvc;

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public UserActivity logActivity(@RequestBody UserActivity ua) {
		return uaSvc.logActivity(ua);
	}

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<UserActivityByDay> getForYearMonth(@RequestParam("y") int year, @RequestParam("m") int month) {
		return uaSvc.getForYearMonth(year, month);
	}

}
