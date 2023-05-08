package com.qualysoft.devops.seminar.qalevackservice.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
public class ReporterService {
    private String url;
    private String port;
}