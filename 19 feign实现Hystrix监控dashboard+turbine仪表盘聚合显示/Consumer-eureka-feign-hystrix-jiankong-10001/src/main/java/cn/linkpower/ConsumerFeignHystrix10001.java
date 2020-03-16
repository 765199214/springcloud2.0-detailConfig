package cn.linkpower;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
//@EnableHystrix feign中包含有Hystrix，若设置feign.hystrix.enabled=true 则无需额外开启
@EnableCircuitBreaker //文本形式展示监控信息   访问采取  url/hystrix.stream
@EnableHystrixDashboard //图像化形式展示监控信息，采取  url/hystrix 
//@SpringCloudApplication

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
