package cn.linkpower.config.filter;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.context.annotation.Configuration;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

/**
 * 处理前的拦截过滤操作
 * @author 765199214
 *
 */
@Configuration
public class ZuulPreRequestFilter extends ZuulFilter {
	
	private static Logger log = LoggerFactory.getLogger(ZuulPreRequestFilter.class);
	
	/**
	 * 返回过滤器的类型。<br>
	 * 有 pre、 route、 post、 error等几种取值，<br>
	 * 分别对应上文的几种过滤器。<br>
	 * 详细可以参考 com.netflix.zuul.ZuulFilter.filterType()中的注释。
	 */
	@Override
	public String filterType() {
		return FilterConstants.PRE_TYPE;
	}
	
	/**
	 * 过滤器执行的顺序，不同的过滤器数字可以一样
	 */
	@Override
	public int filterOrder() {
		return FilterConstants.PRE_DECORATION_FILTER_ORDER - 1;
	}
	
	/**
	 * 返回一个boolean值来判断是否需要执行；<br>
	 * reture true 表示需要执行；<br>
	 * return false 表示不需要执行；<br>
	 */
	@Override
	public boolean shouldFilter() {
		return true;
	}
	
	/**
	 * 过滤器的具体执行逻辑，此处只用来打印请求信息，也可以用来做身份校验等；
	 */
	@Override
	public Object run() throws ZuulException {
		RequestContext currentContext = RequestContext.getCurrentContext();
		HttpServletRequest request = currentContext.getRequest();
		log.info(String.format("send %s request to %s", 
				request.getMethod(),
				request.getRequestURL().toString()));
		return null;
	}


}
