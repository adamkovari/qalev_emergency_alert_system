package com.qualysoft.devops.seminar.qalevreportservice.dto.mapper;

import com.qualysoft.devops.seminar.qalevreportservice.dto.model.AcknowledgerRoleDto;
import com.qualysoft.devops.seminar.qalevreportservice.model.AcknowledgerRole;

public class AcknowledgerRoleMapper {
    public static AcknowledgerRoleDto toAcknowledgerRoleDto(AcknowledgerRole ackRole) {
        return new AcknowledgerRoleDto()
                .setName(ackRole.getName());
    }
}