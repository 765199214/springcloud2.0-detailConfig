package cn.linkpower.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope //添加这个注解的类会在配置更改时得到特殊的处理
public class TestController {
	
	@Value("${foo}")
	private String foo;
	
	@RequestMapping("/test")
	public String getProfiles(){
		return foo;
	}
}
