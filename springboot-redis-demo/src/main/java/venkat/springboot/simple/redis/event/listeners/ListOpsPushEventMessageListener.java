package venkat.springboot.simple.redis.event.listeners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.KeyspaceEventMessageListener;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.Topic;
import org.springframework.stereotype.Component;

/*
 * If enabling notify-keyspace-events doesn't work from KeyspaceEventMessageListener, then use redis-cli
 * and execute command: config set notify-keyspace-events KEA
 */
@Component
public class ListOpsPushEventMessageListener extends KeyspaceEventMessageListener {

	private static final Topic TOPIC_LISTOPS_PUSH_KEYEVENTS = new PatternTopic("__keyevent@*:*push");

	@Autowired
	private RedisTemplate<String, Object> redisTemplate;

	public ListOpsPushEventMessageListener(RedisMessageListenerContainer listenerContainer) {
		super(listenerContainer);
	}

	/**
	 * Register instance within the container.
	 *
	 * @param container never {@literal null}.
	 */
	protected void doRegister(RedisMessageListenerContainer listenerContainer) {
		listenerContainer.addMessageListener(this, TOPIC_LISTOPS_PUSH_KEYEVENTS);
	}

	@Override
	protected void doHandleMessage(Message message) {
		System.out.format("Got message: {channel: %s, body: %s}%n", new String(message.getChannel()), new String(message.getBody()));
		String listName = new String(message.getBody());
		System.out.format("%s=%s%n", listName, redisTemplate.opsForList().range(listName, 0, -1));
	}

}
