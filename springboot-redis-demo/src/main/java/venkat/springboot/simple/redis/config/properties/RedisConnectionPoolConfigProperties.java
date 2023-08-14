package venkat.springboot.simple.redis.config.properties;

import lombok.Data;

@Data
public class RedisConnectionPoolConfigProperties {

    private int maximumConnection;
    private int minimumIdle;
    private int maximumIdle;
    private int timeoutMinutes;

}
