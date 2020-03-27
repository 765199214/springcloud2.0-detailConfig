## SpringCloud-Zuul 中的pom依赖问题
>涉及到需要考虑Springcloud和Springboot版本兼容性问题，本次的Zuul的配置中的pom采用的是：
>2.0.2.RELEASE  springboot
>Finchley.M7    springcloud

## 由于Zuul默认引用了Hystrix，使用Hystrix.stream查看依旧为404时，需要在Zuul微服务中增加如下config：
```java
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;

@Configuration
public class HystrixConfiguration {
	@Bean
    public ServletRegistrationBean<HystrixMetricsStreamServlet> getServlet(){
        HystrixMetricsStreamServlet hystrixMetricsStreamServlet = new HystrixMetricsStreamServlet();
        ServletRegistrationBean<HystrixMetricsStreamServlet> servletRegistrationBean = new ServletRegistrationBean();
        servletRegistrationBean.setServlet(hystrixMetricsStreamServlet);
        servletRegistrationBean.addUrlMappings("/hystrix.stream");
        servletRegistrationBean.setName("HystrixMetricsStreamServlet");
        return servletRegistrationBean;
    }
}
```
再进行 localhost:zuul的port/hystrix.stream 请求即可！

## Zuul默认使用了Ribbon做了负载均衡操作，请求时的规则为：
>localhost:zuul的port/小写微服务别名/处理映射
>这里的服务别名一定要求小写！

