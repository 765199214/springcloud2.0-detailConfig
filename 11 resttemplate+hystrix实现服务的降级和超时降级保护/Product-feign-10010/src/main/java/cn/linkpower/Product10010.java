package cn.linkpower;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
public class Product10010 {
   public static void main(String[] args) {
	SpringApplication.run(Product10010.class, args);
   }
   /*
   @Bean
   //@LoadBalanced //开启负载均衡
   public RestTemplate restTemplate(){
	   return new RestTemplate();
   }*/
}
