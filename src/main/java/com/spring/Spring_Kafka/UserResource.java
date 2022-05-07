package com.spring.Spring_Kafka;

import org.apache.commons.logging.Log;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

import org.apache.logging.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.apache.logging.log4j.LogManager;

	@RestController
	@RequestMapping("kafka")
	@Slf4j
	public class UserResource {

		final static org.slf4j.Logger logger = LoggerFactory.getLogger(UserResource.class);

	    @Autowired
	    private KafkaTemplate<String, User> kafkaTemplate;

	    private static final String TOPIC = "sasi";

	    @GetMapping("/publish/{name}")
	    public User post(@PathVariable("name") final String name) {

			logger.info("this is started",name);

			User sasi=new User(name,20,"Guntur");

	        //kafkaTemplate.send(TOPIC, new User(name,20,"Guntur"));

			logger.info(sasi.getName(),sasi.getAge(),sasi.getLocation());
	        System.out.println("sent successfully");

	        return  sasi;
	    }
		
	    @GetMapping("/test")
	    public String Test(){

			logger.info("this is just testing");

			

	        

	        return "Published successfully";
	    }
	}

