package com.qualysoft.devops.seminar.qalevreportservice.dto.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.qualysoft.devops.seminar.qalevreportservice.model.Alert;
import com.qualysoft.devops.seminar.qalevreportservice.util.Types;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.util.List;

@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class EventDto {

    private Types.EventStatus status;

    private EventTypeDto type;

    private List<AlertDto> alerts;
}