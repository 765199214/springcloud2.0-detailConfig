package cn.linkpower;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer  //表明这是一个  config server
public class SpringCloudConfigApplication3000 {
	public static void main(String[] args) {
		SpringApplication.run(SpringCloudConfigApplication3000.class, args);
	}
}
