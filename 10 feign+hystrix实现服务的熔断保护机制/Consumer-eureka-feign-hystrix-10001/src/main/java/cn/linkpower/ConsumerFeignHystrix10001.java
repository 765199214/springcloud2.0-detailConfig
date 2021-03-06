package cn.linkpower;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableEurekaClient
@EnableFeignClients
@EnableHystrix
//@SpringCloudApplication
@SpringBootApplication

public class ConsumerFeignHystrix10001 {
	private static Logger log = LoggerFactory.getLogger(ConsumerFeignHystrix10001.class);
	
	public static void main(String[] args) {
		try {
			SpringApplication.run(ConsumerFeignHystrix10001.class, args);
		} catch (Exception e) {
			log.info("ConsumerFeignHystrix10001 Application exception-->{}",e);
		}
	}
}
