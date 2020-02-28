package cn.linkpower.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

import cn.linkpower.uo.ServiceCommand;

@RestController
public class TestController {
	
	private Logger log = LoggerFactory.getLogger(TestController.class);
	
	@Autowired
	private RestTemplate restTemplate;
	
	@RequestMapping("/test1")
	@HystrixCommand(fallbackMethod="testfallback")
	public String test1(@RequestParam String name){
		log.info("请求调用 --- test1 --- name ===={}",String.valueOf(name));
		String memberUrl = "http://app-bunana-product/product/getProduct?name="+String.valueOf(name);
		String result = restTemplate.getForObject(memberUrl, String.class);
		return "this is Consumer,get result is ==="+String.valueOf(result);
	}
	
	//@RequestParam 此处也可以不加这个注解
	public String testfallback(@RequestParam String name){
		return "请求异常，请联系开发者";
	}
	
	@RequestMapping("/test2")
	public String test2(@RequestParam String name){
		//这里的key可以任意取名，只是这种方式必须传递这个参数而已
		ServiceCommand serviceCommand = new ServiceCommand("random", restTemplate, name);
		return serviceCommand.execute();
	}
	
	/**
	 * 用于限流操作的配置
	 * @param name
	 * @return
	 */
	@RequestMapping("/test3")
	@HystrixCommand(fallbackMethod="testfallback3",
					groupKey="test3",//组名称
					threadPoolKey="test3ThreadPool", //配置全局唯一标识线程池的名称
					threadPoolProperties={	//配置线程池的参数信息
							@HystrixProperty(name="coreSize",value="2") //coreSize配置核心线程池的大小和线程池最大大小(默认10，超过这个数后直接降级)
							//,@HystrixProperty(name="keepAliveTimeMinutes",value="60000") //keepAliveTimeMinutes配置线程池中空闲线程的生存时间，不配置则无作用
							//,@HystrixProperty(name="maxQueueSize",value="1") //maxQueueSize线程池队列最大大小
							//,@HystrixProperty(name="queueSizeRejectionThreshold",value="6") //限定当前队列大小
					}
				)
	public String test3(@RequestParam String name){
		log.info("请求调用 --- test3 --- name ===={}",String.valueOf(name));
		String memberUrl = "http://app-bunana-product/product/getProduct?name="+String.valueOf(name);
		String result = restTemplate.getForObject(memberUrl, String.class);
		return "this is Consumer,get result is ==="+String.valueOf(result);
	}
	
	//Hystrix的失败回调函数
	public String testfallback3(String name){
		return "异常了。。。。";
	}
}
