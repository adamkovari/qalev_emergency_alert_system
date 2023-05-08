package com.qualysoft.devops.seminar.qalevreportservice;

import com.qualysoft.devops.seminar.qalevreportservice.config.Config;
import com.qualysoft.devops.seminar.qalevreportservice.util.AcknowledgerSeeder;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Configuration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Value;

import java.util.logging.Logger;
import java.util.logging.Level;

//import com.qualysoft.devops.seminar.qalevreportservice.config.DatabaseConfig;

@EnableConfigurationProperties(Config.class)
@SpringBootApplication
@RestController
public class QalevReportServiceApplication {

    public static final Logger logger = Logger.getLogger(QalevReportServiceApplication.class.getName());

    //private DatabaseConfig config;
    @Autowired
    private AcknowledgerSeeder acknowledgerSeeder;

    public static void main(String[] args) {
        logger.setLevel(Level.ALL);
        SpringApplication.run(QalevReportServiceApplication.class, args);
    }

    @EventListener
    public void seed(ContextRefreshedEvent event) {
        acknowledgerSeeder.createAcknowledgers();
    }

//    @GetMapping("/hello")
//    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
//
//        //System.out.println(this.config.getConfig());
//        return String.format("Hello %s! from ReportService", name);
//    }

    //
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

}
