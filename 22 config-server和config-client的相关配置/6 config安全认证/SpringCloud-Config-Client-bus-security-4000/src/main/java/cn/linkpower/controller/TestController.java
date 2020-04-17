package cn.linkpower.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope  //在需要刷新缓存的 控制器上，增加此项注解
public class TestController {
	
	@Value("${foo}")
	private String foo;
	
	@RequestMapping("/test")
	public String getProfiles(){
		return foo;
	}
}
