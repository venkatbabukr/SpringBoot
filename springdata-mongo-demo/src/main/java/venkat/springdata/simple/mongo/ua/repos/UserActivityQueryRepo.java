package venkat.springdata.simple.mongo.ua.repos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserActivityQueryRepo {

	private final MongoTemplate queryTemplate;
	
	@Autowired
	public UserActivityQueryRepo(MongoTemplate template) {
		this.queryTemplate = template;
	}

}
