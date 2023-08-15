package venkat.springboot.simple.redis.event.listeners;

import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.listener.KeyspaceEventMessageListener;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.Topic;
import org.springframework.stereotype.Component;

@Component
public class LpushEventMessageListener extends KeyspaceEventMessageListener {

	private static final Topic TOPIC_LPUSH_KEYEVENTS = new PatternTopic("__keyevent@*:lpush");

	public LpushEventMessageListener(RedisMessageListenerContainer listenerContainer) {
		super(listenerContainer);
	}

	/**
	 * Register instance within the container.
	 *
	 * @param container never {@literal null}.
	 */
	protected void doRegister(RedisMessageListenerContainer listenerContainer) {
		listenerContainer.addMessageListener(this, TOPIC_LPUSH_KEYEVENTS);
	}

	@Override
	protected void doHandleMessage(Message message) {
		System.out.println("Venkat lisener doHandleMessage!");
	}

}
