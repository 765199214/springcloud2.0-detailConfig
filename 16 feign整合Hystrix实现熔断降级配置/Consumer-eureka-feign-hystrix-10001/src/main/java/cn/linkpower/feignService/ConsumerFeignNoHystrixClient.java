package cn.linkpower.feignService;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.linkpower.feignService.NoFeignHystrixConfig;


/**
 * 无Hystrix降级
 * @author 765199214
 *
 */
@FeignClient(value="app-bunana-product-1",
		fallback=ConsumerFallbackNoHystrix.class,
		configuration=NoFeignHystrixConfig.class)
public interface ConsumerFeignNoHystrixClient {
	@RequestMapping("/product/getProduct")
	public String getTest1ByFeign(@RequestParam("name") String name);
}

@Component
class ConsumerFallbackNoHystrix  implements ConsumerFeignNoHystrixClient {
	
	@Override
	public String getTest1ByFeign(String name) {
		return "服务错误，请联系开发者";
	}
	
}
