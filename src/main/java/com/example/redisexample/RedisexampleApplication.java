package com.example.redisexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class RedisexampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(RedisexampleApplication.class, args);
	}

}
