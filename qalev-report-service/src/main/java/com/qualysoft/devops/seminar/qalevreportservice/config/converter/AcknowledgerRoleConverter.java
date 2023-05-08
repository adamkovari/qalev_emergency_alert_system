package com.qualysoft.devops.seminar.qalevreportservice.config.converter;

import com.qualysoft.devops.seminar.qalevreportservice.model.AcknowledgerRole;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@ConfigurationPropertiesBinding
public class AcknowledgerRoleConverter implements Converter<String, AcknowledgerRole> {

    Logger logger = LoggerFactory.getLogger(AcknowledgerRoleConverter.class);

    @Override
    public AcknowledgerRole convert(String source) {
        logger.debug("AckRole was created from source: " + source);
        return new AcknowledgerRole()
                .setName(source);
    }
}