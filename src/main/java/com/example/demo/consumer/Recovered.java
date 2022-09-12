package com.example.demo.consumer;

import com.example.demo.model.Banco;
import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@Slf4j
public class Recovered {
	
//	@RabbitListener(queues = "filasuzana")
//	public void received(final Message message){
//		log.info("A mensagem é: {}", new String(message.getBody()));
//	}
	
	@RabbitListener(queues = "filasuzana")
	public void received(@Payload final Banco banco, @Header(AmqpHeaders.CHANNEL)Channel channel, Message message) throws
	                                                                                                               IOException {
		log.info("A mensagem é: {}", banco);
		channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
	}
	

}
