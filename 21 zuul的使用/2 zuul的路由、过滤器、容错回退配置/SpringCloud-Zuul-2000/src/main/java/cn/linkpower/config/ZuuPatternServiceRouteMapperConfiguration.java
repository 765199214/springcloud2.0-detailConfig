//package cn.linkpower.config;
//
//import org.springframework.cloud.netflix.zuul.filters.discovery.PatternServiceRouteMapper;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
///**
// * 自动化配置：<br>
// * 不想逐个去配置各项微服务的替代别名时，可以依据正则的方式代替；<br>
// * 配置二选一！！
// * @author 7651
// *
// */
//@Configuration
//public class ZuuPatternServiceRouteMapperConfiguration {
//	
//	/**
//	 * 有版本号的配置方式
//	 * @return
//	 */
//	/*@Bean
//	public PatternServiceRouteMapper serviceRouteMapper() {
//	    return new PatternServiceRouteMapper(
//	        "(?<name>^.+)-(?<version>v.+$)",
//	        "${version}/${name}");
//	}*/
//	
//	/**
//	 * 无版本号的配置方式
//	 * @return
//	 */
//    @Bean
//    public PatternServiceRouteMapper patternServiceRouteMapper(){
//        return new PatternServiceRouteMapper("(?<version>v.*$)","${name}");
//    }
//}
