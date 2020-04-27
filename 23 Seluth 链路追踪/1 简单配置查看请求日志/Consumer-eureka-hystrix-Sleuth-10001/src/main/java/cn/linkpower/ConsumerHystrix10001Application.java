package cn.linkpower;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
//@EnableEurekaClient
@EnableHystrix
public class ConsumerHystrix10001Application {
	private static Logger log = LoggerFactory.getLogger(ConsumerHystrix10001Application.class);
	public static void main(String[] args) {
		try {
			SpringApplication.run(ConsumerHystrix10001Application.class, args);
		} catch (Exception e) {
			log.info("ConsumerHystrix10001Application start exception--->{}", e);
		}
	}
	
	@Bean
	@LoadBalanced
	public RestTemplate getRestTemplate(){
		return new RestTemplate();
	}
}
