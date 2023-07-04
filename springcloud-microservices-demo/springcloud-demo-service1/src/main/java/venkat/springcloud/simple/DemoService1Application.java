package venkat.springcloud.simple;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

import venkat.springcloud.simple.feign.client.Service2Client;

@SpringBootApplication
@EnableFeignClients(clients = Service2Client.class)
public class DemoService1Application {

	public static void main(String[] args) {
		SpringApplication.run(DemoService1Application.class, args);
	}

}
