package cn.linkpower;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
//@EnableEurekaClient
@EnableDiscoveryClient
public class SpringCloudConfigClient4000 {
	public static void main(String[] args) {
		SpringApplication.run(SpringCloudConfigClient4000.class, args);
	}
}
