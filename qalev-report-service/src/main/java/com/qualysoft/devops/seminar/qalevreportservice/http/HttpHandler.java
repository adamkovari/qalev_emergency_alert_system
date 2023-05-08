package com.qualysoft.devops.seminar.qalevreportservice.http;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.Serializable;

@Service
public class HttpHandler {

    private final RestTemplate restTemplate;

    public HttpHandler(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public String postHttpRequest(String url, Serializable message) {
        return this.restTemplate.postForObject(url, message, String.class);
    }

    public String createURI(String url, String port, String endPoint) {
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