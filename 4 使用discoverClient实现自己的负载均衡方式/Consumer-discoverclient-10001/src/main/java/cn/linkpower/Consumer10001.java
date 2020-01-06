package cn.linkpower;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
//@EnableEurekaClient
@EnableDiscoveryClient
public class Consumer10001 {
   public static void main(String[] args) {
	SpringApplication.run(Consumer10001.class, args);
   }
   
   @Bean
   //@LoadBalanced //开启负载均衡
   public RestTemplate restTemplate(){
	   return new RestTemplate();
   }
}
