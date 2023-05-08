package com.qualysoft.devops.seminar.qalevackservice.http;

import com.qualysoft.devops.seminar.qalevackservice.config.Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.Serializable;

@Service
public class HttpHandler {

    @Autowired
    private Config config;
    private final RestTemplate restTemplate;

    public HttpHandler(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public ResponseEntity postHttpRequest(Serializable message) {
        return this.restTemplate.postForEntity(createURI(config.getQalevReportService().getUrl(), config.getQalevReportService().getPort(), EndPoint.ACKNOWLEDGE.label), message, String.class);
    }

    private String createURI(String url, String port, String endPoint) {
        return "http://" + url + ':' + port + '/' + endPoint;
    }

    public enum EndPoint {
        REPORT("report-alert"),
        ACKNOWLEDGE("ack-alert");

        public final String label;

        EndPoint(String label) {
            this.label = label;
        }
    }
}