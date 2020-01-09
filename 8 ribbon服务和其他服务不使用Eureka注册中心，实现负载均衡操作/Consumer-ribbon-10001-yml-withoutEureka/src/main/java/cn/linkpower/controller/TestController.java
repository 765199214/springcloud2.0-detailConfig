package cn.linkpower.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class TestController {
	
	private static final Logger logger = LoggerFactory.getLogger(TestController.class);
	
	@Autowired
	private RestTemplate restTemplate;
	
	 @Autowired
	private LoadBalancerClient loadBalancerClient;
	
	/**
	 * 随机负载
	 * @param name
	 * @return
	 */
	@RequestMapping("/product/{name}")
	public String getTest1(@PathVariable String name){
		String memberUrl = "http://app-bunana-product/product/getProduct?name="+String.valueOf(name);
		String result = restTemplate.getForObject(memberUrl, String.class);
		return "this is consumer project ,get product result = "+String.valueOf(result);
	}
	
	@RequestMapping("/productUser/{name}")
	public String productUser(@PathVariable String name){
		String memberUrl = "http://app-bunana-user/productUser/getProduct?name="+String.valueOf(name);
		String result = restTemplate.getForObject(memberUrl, String.class);
		//ServiceInstance serviceInstance = this.loadBalancerClient.choose("app-bunana-user");
		//logger.info("{}:{}:{}", serviceInstance.getServiceId(), serviceInstance.getHost(), serviceInstance.getPort());
		return "this is consumer project ,get user result = "+String.valueOf(result);
	}
}
