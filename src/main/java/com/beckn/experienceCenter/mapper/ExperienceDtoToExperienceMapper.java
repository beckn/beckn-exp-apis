package com.beckn.experienceCenter.mapper;

import com.beckn.experienceCenter.dto.ExperienceDTO;
import com.beckn.experienceCenter.model.Experience;
import org.springframework.stereotype.Component;

@Component
public class ExperienceDtoToExperienceMapper {
    public Experience mapExperienceDtoToExperience(ExperienceDTO experienceDTO){
        Experience experience = new Experience();
        experience.setExperience_id(experienceDTO.getExperienceId());
        experience.setApp_id(Integer.parseInt(experienceDTO.getEventSourceAppId()));
        experience.setActive(experienceDTO.getActive());
        experience.setStart_ts(experienceDTO.getStart_ts());
        experience.setEnd_ts(experienceDTO.getEnd_ts());
        experience.setCreated_at(experienceDTO.getCreated_ts());
        experience.setLast_modified_at(experienceDTO.getLastModified_ts());
        return experience;
    }
}
