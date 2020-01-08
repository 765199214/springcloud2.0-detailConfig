package cn.linkpower.config;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Configuration;

import cn.config.RibbonRandomConfig;

/**
 * 我想针对 app-bunana-product 服务进行随机负载均衡的策略
 * @author 765199214
 *
 */
@Configuration
// 将指定的哪些服务 使用什么样的负载均衡方式 关联
@RibbonClient(name="app-bunana-product",configuration = RibbonRandomConfig.class)
public class ProductRandomRibbonConfig {

}
