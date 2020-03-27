package cn.linkpower;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableEurekaClient
@EnableZuulProxy //开启Zuul代理
public class SpringCloudZuul2000 {
	public static void main(String[] args) {
		SpringApplication.run(SpringCloudZuul2000.class, args);
	}
}
