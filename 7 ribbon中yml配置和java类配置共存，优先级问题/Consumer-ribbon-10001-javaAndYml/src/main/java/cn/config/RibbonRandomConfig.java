package cn.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;

/**
 * 此类为 Ribbon 的配置类；<br>
 * 注意：该类不在SpringbootApplication启动类的默认扫描路径下(@ComponentScan)
 * @author 7651
 *
 */
@Configuration
public class RibbonRandomConfig {
	
	@Bean
	public IRule ribbonRule(){
		// 将默认的 轮询  更改为  随机
		return new RandomRule();
	}
}
