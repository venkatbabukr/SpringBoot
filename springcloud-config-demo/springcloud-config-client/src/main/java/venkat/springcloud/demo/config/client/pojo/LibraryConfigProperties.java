package venkat.springcloud.demo.config.client.pojo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;

import lombok.Data;

@Data
@ConfigurationProperties(prefix = "library")
@RefreshScope
public class LibraryConfigProperties {

	private Integer numShelves;

	private Integer numSections;

}
