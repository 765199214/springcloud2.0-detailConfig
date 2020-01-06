package cn.linkpower.controller;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/test")
public class TestController {
	
	private static Logger log = LoggerFactory.getLogger(TestController.class);
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private DiscoveryClient discoveryClient;
	
	public static int requestCount = 0;
	
	@RequestMapping("/test1")
	public String getTest1(String name){
		String getUrl = getService();
		if( getUrl == null){
			return "根据指定的别名，无法获取指定的请求地址信息";
		}
		String memberUrl = getUrl+"/product/getProduct?name="+String.valueOf(name);
		String result = restTemplate.getForObject(memberUrl, String.class);
		return "this is consumer project ,get product result = "+String.valueOf(result);
	}
	
	private String getService(){
		List<ServiceInstance> serviceInstanceLists = discoveryClient.getInstances("app-bunana-product");
		if(serviceInstanceLists == null || serviceInstanceLists.size() == 0){
			return null;
		}
		//获取此时该“别名”对应的请求地址的个数信息
		int size = serviceInstanceLists.size();
		//获取当前的请求下标信息
		int index = requestCount % size;
		//请求数递增
		requestCount ++;
		//通过计算得到的下标，获取对应需要请求的地址和端口信息
		ServiceInstance serviceInstance = serviceInstanceLists.get(index);
		log.info("获取ServiceInstance对象，他的信息是:{}", serviceInstance.toString());
		String getUrl = serviceInstance.getUri().toString();
		log.info("获取ServiceInstance对象，url是:{}", getUrl);
		return getUrl;
	}
}
