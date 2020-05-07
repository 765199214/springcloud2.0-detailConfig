package cn.linkpower.mq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/**
 * 监听消息队列中的消息，并进行消息的打印操作
 * @author 765199214
 *
 */
@Component
@EnableBinding(Sink.class)
public class ReceviverMessageListener {
	
	private static Logger log = LoggerFactory.getLogger(ReceviverMessageListener.class);
	
	@Value("${server.port}")
	private String port;
	
	@StreamListener(Sink.INPUT)
	public void input(Message<String> message){
		log.info("接受消息：{},该服务端口信息为：{}",message.getPayload(),port);
	}
	
}
