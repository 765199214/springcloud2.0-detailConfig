package com.linkpower.feignService;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import feign.Feign;

/**
 * 在不需要使用Feign中Hystrix的接口上增加其注解
 * 
 * @author 7651
 *
 */
@Configuration
public class NoFeignHystrixConfig {

	@Bean
	@Scope("prototype")
	public Feign.Builder feignBuilder() {
		//feignBuilder方法默认返回HystrixFeign.Builder也就是说Feign默认支持Hystrix
        //现在改成Feign.Builder就禁用了Hystrix的支持
		return Feign.builder();
	}
}
