package com.example.demo.controler;

import com.example.demo.model.Banco;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/send")
public class EnvioMensagem {
	
	@Autowired
	private RabbitTemplate template;
	
	@GetMapping(consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.TEXT_PLAIN_VALUE})
	public void enviar(@RequestBody Banco banco){
		this.template.convertAndSend("filasuzana", banco);
	}
	
}
