package venkat.springboot.simple.redis.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/listops")
public class RedisListOperations {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

	@GetMapping(path = "/lpush/{list-name}/{value}")
	public String lpush(@PathVariable("list-name") String listName, @PathVariable("value") String value) {
		redisTemplate.opsForList().leftPush(listName, value);
		return value;
	}

	@GetMapping(path = "/rpop/{list-name}")
	public String rpop(@PathVariable("list-name") String listName) {
		return (String) redisTemplate.opsForList().rightPop(listName);
	}

}
