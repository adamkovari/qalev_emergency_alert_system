package com.qualysoft.devops.seminar.qalevackservice.config;

import com.qualysoft.devops.seminar.qalevackservice.model.ReporterService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@ConfigurationProperties("qalev-ack-service")
public class Config {

    private String config;

    private ReporterService qalevReportService;
}