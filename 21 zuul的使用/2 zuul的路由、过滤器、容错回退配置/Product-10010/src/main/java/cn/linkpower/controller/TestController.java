package cn.linkpower.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/product")
public class TestController {
	
	@Value("${server.port}")
	private String port;
	
	@RequestMapping("/getProduct")
	public String getTest1(HttpServletRequest request){
		String name = request.getParameter("name");
		if("error".equalsIgnoreCase(name)){
			throw new NullPointerException();
		}
		return "this is product project getProduct name = "+String.valueOf(name)+",port="+port;
	}
}
