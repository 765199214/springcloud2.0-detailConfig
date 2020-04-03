package cn.linkpower.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * 接收 http://localhost:2000/api/test/test2 的转发处理  转变为 http://localhost:2000/api/testforward/test2
 * @author 765199214
 *
 */
@RestController
public class TsetController {
	
	@RequestMapping("/testforward/test2")
	public String test(){
		return "66666 ---testforward--- 7777";
	}
	
	@Autowired
	private RestTemplate restTemplate;
	
	@RequestMapping("/juheTest/{name}")
	public Map<String,Object> juheTest(@PathVariable String name){
		Map<String,Object> returnMaps = new HashMap<>();
		//请求product微服务
		String productVal = restTemplate
					.getForObject("http://app-bunana-product/product/getProduct?name="+name, String.class);
		//请求user微服务
		String userVal = restTemplate
					.getForObject("http://user-test/user/test1", String.class);
		//合并消息返回
		returnMaps.put("product", productVal);
		returnMaps.put("user", userVal);
		return returnMaps;
	}
}
