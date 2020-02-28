package cn.linkpower.controller;

import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/product")
public class TestController {
	
	private static Logger log = LoggerFactory.getLogger(TestController.class);
	
	@Value("${server.port}")
	private String port;
	
	@RequestMapping("/getProduct")
	public String getTest1(String name) throws InterruptedException{
		//int timeout = new Random().nextInt(3000);
		//log.info("此时的超时时间--->{}",String.valueOf(timeout));
		//Thread.sleep(timeout);
		
		//此处 我们模拟 当 name = "1" 时，出现业务报错
		if("1".equalsIgnoreCase(name)){
			throw new NullPointerException();
		}
		return "this is product project getProduct name = "+String.valueOf(name)+",port="+port;
	}
}
