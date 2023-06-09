package com.qualysoft.devops.seminar.qalevackservice;

import com.qualysoft.devops.seminar.qalevackservice.config.Config;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@EnableConfigurationProperties(Config.class)
@SpringBootApplication
@RestController
public class QalevAckServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(QalevAckServiceApplication.class, args);
	}
	@GetMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
		return String.format("Hello %s! from AckService", name);
	}

}