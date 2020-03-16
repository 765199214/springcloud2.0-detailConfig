package cn.linkpower;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

@SpringBootApplication
//@EnableEurekaClient
@EnableDiscoveryClient
@EnableTurbine //开启turbine
@EnableHystrixDashboard   // 开启Hystrix仪表盘功能
public class HystrixTurbine8031 {
	public static void main(String[] args) {
		SpringApplication.run(HystrixTurbine8031.class, args);
	}
}
