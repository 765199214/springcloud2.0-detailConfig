package cn.linkpower.feignService;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import cn.linkpower.feignService.ConsumerFeignClient;

@Component 
public class FallbackHystrix implements ConsumerFeignClient {

	@Override
	public String getTest1ByFeign(String name) {
		return "服务错误，请联系开发者";
	}

}
