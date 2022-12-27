package com.beckn.experienceCenter.mapper;

import com.beckn.experienceCenter.dto.v2request.V2ExperienceDTO;
import com.beckn.experienceCenter.model.V2Experience;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class V2ExperienceDtoToExperienceMapper {
    public V2Experience mapExperienceDtoToExperience(V2ExperienceDTO experienceDTO) {
        V2Experience experience = new V2Experience();
        experience.setExperience_id(experienceDTO.getExperienceId());
        experience.setExperience_center_id(experienceDTO.getExperienceCenterId());
        experience.setApp_id(experienceDTO.getEventSourceAppId());
        experience.setActive(true);
        experience.setStart_ts(experienceDTO.getStart_ts());
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss.SSS");
        Date date = new Date();
        try {
            experience.setCreated_at(new SimpleDateFormat("dd/MM/yyyy HH:mm:ss.SSS").parse(formatter.format(date)));
            experience.setLast_modified_at(new SimpleDateFormat("dd/MM/yyyy HH:mm:ss.SSS").parse(formatter.format(date)));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return experience;
    }
}
