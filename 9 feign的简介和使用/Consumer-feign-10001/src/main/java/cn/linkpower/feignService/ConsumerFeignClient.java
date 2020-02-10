package cn.linkpower.feignService;

import javax.servlet.http.HttpServletRequest;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

//添加feignClient注解并引用对应的别名
@FeignClient("app-bunana-product")
public interface ConsumerFeignClient {
	
	@RequestMapping("/product/getProduct")
	public String getTest1ByFeign(@RequestParam("name") String name);
}
