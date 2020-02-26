package cn.linkpower.feignService;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient(value="app-bunana-product",fallback=FallbackHystrix.class)
public interface ConsumerFeignClient {
	@RequestMapping("/product/getProduct")
	public String getTest1ByFeign(@RequestParam("name") String name);
}
