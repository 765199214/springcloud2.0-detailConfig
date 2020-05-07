package cn.linkpower.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.linkpower.service.IMessageService;

@RestController
public class TestController {
	
	private static Logger log = LoggerFactory.getLogger(TestController.class);
	
	@Autowired
	private IMessageService messageServiceImpl;
	
	@RequestMapping("/test/{msg}")
	public String test(@PathVariable("msg") String msg){
		log.info("接收到的url数据：{}",String.valueOf(msg));
		messageServiceImpl.send(msg);
		return msg;
	}
}
