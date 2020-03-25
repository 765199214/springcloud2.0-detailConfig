package cn.linkpower.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;




/**
 * 有Hystrix降级
 * @author 7651
 *
 */
@FeignClient(value="app-bunana-product",
		fallback=ConsumerFallbackHystrix.class)
public interface ConsumerFeignClient {
	@RequestMapping("/product/getProduct")
	public String getTest1ByFeign(@RequestParam("name") String name);
}

@Component
class ConsumerFallbackHystrix  implements ConsumerFeignClient {
	
	@Override
	public String getTest1ByFeign(String name) {
		return "服务错误，请联系开发者";
	}
	
}
