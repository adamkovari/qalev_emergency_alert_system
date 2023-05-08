package com.qualysoft.devops.seminar.qalevreportservice.service;

import com.qualysoft.devops.seminar.qalevreportservice.dto.mapper.AcknowledgerRoleMapper;
import com.qualysoft.devops.seminar.qalevreportservice.dto.model.AcknowledgerRoleDto;
import com.qualysoft.devops.seminar.qalevreportservice.model.AcknowledgerRole;
import com.qualysoft.devops.seminar.qalevreportservice.repository.AcknowledgerRoleRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Component
public class AcknowledgerRoleService {

    @Autowired
    private AcknowledgerRoleRepository acknowledgerRoleRepository;

    @Autowired
    private ModelMapper modelMapper;

    /**
     * Returns all the AckRoles in the database.
     *
     * @return Set<AckRoleDto>
     */
    public List<AcknowledgerRoleDto> getAllAckRoles() {

        System.out.println(acknowledgerRoleRepository.findAll());

        return acknowledgerRoleRepository.findAll().stream()
                .map(event -> modelMapper.map(event, AcknowledgerRoleDto.class))
                .collect(Collectors.toList());

    }

    public AcknowledgerRoleDto putAckRole(String name) {
        AcknowledgerRole ackRole = acknowledgerRoleRepository.findByName(name);
        if (ackRole == null) {
            ackRole = new AcknowledgerRole()
                    .setName(name);

            return AcknowledgerRoleMapper.toAcknowledgerRoleDto(acknowledgerRoleRepository.save(ackRole));
        }

        throw new RuntimeException("Duplication");
    }
}