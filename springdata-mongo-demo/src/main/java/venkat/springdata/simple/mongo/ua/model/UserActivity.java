package venkat.springdata.simple.mongo.ua.model;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Document("useractivities")
@Accessors(chain = true)
public class UserActivity {

	@Id
	private UUID uuid;
	private String userEmail;
	private String site;
	private String activityDesc;
	private LocalDateTime activityTime;

}
