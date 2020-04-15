package cn.linkpower.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
	
	@Value("${foo}")
	private String foo;
	
	@RequestMapping("/test")
	public String getProfiles(){
		return foo;
	}
}
