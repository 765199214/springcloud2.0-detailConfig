package cn.linkpower.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/user")
public class TestController {
	
	@Value("${server.port}")
	private String port;
	
	@RequestMapping("/test1")
	public String getTest1(HttpServletRequest request){
		return "this is usertest project getTest1 port="+port;
	}
}
