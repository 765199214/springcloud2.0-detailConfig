package cn.linkpower.uo;

import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

public class ServiceCommand extends HystrixCommand<String> {
	
	//请求操作，需要携带的参数信息
	private RestTemplate restTemplate;
	private String name;
	
	public ServiceCommand(String key, RestTemplate restTemplate, String name) {
		super(HystrixCommandGroupKey.Factory.asKey(key));
		this.restTemplate = restTemplate;
		this.name = name;
	}
	
	@Override
	protected String run() throws Exception {
		String memberUrl = "http://app-bunana-product/product/getProduct?name="+String.valueOf(name);
		return restTemplate.getForObject(memberUrl, String.class);
	}
	
	@Override
	protected String getFallback() {
		//返回默认信息，或者失败的提示信息
		return "请求调用失败";
	}
}
