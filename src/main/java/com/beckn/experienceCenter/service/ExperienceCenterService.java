package com.beckn.experienceCenter.service;

import com.beckn.experienceCenter.dto.ExperienceDTO;
import com.beckn.experienceCenter.dto.UpdateSessionDto;
import com.beckn.experienceCenter.exception.ExperienceException;
import com.beckn.experienceCenter.mapper.ExperienceDtoToExperienceMapper;
import com.beckn.experienceCenter.model.Event;
import com.beckn.experienceCenter.model.Experience;
import com.beckn.experienceCenter.model.ExperienceResult;
import com.beckn.experienceCenter.repository.EventRepository;
import com.beckn.experienceCenter.repository.ExperienceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExperienceCenterService {
    @Autowired
    private ExperienceRepository experienceRepository;

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private ExperienceDtoToExperienceMapper mapper;

    @Autowired
    private SequenceGeneratorService service;

    public ExperienceResult getEventsById(String experienceId) {
        ExperienceResult experienceResult = new ExperienceResult();
        Experience experience = experienceRepository.findByExperienceId(experienceId);
        if (experience == null) {
            throw new ExperienceException("", "", "E-101", "No data found in database for ExperienceId : " + experienceId);
        }
        experienceResult.setExperience(experience);
        List<Event> events = eventRepository.findByExperienceId(experienceId);
        if (events.isEmpty()) {
            //throw new ExperienceException("", "", "E-102", "No Events found in database for ExperienceId : " + experienceId);
        }
        experienceResult.setEvents(events);
        return experienceResult;
    }

    public Experience setupExperienceSession(ExperienceDTO inputSession) {
        Experience experience = mapper.mapExperienceDtoToExperience(inputSession);
        experience.setId(service.getSequenceNumber(Experience.SEQUENCE_NAME));
        experience.setActive(true);
        return experienceRepository.save(experience);
    }

    public Experience closeExperienceSession(UpdateSessionDto updateSession) {
        Experience experience = experienceRepository.findByExperienceId(updateSession.getExperienceId());
        if (experience == null) {
            throw new ExperienceException("", "", "E-101", "No data found in database for ExperienceId : " + updateSession.getExperienceId());
        }
        experience.setActive(false);
        experience.setEnd_ts(updateSession.getEnd_ts());
        return experienceRepository.save(experience);
    }
}
