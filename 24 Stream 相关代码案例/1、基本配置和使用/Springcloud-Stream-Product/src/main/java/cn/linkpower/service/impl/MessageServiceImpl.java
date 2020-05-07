package cn.linkpower.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import cn.linkpower.service.IMessageService;


@EnableBinding(Source.class) //定义消息的推送管道
public class MessageServiceImpl implements IMessageService {
	
	private static Logger log = LoggerFactory.getLogger(MessageServiceImpl.class);
	
	//消息发送管道
	@Autowired
	private MessageChannel output; 
	
	@Override
	public String send(String msg) {
		output.send(MessageBuilder.withPayload(msg).build());
		log.info("****  send msg：{}",msg);
		return null;
	}

}
