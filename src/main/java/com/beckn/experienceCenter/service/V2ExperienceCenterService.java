package com.beckn.experienceCenter.service;

import com.beckn.experienceCenter.dto.v2request.V2ExperienceDTO;
import com.beckn.experienceCenter.dto.v2request.V2UpdateSessionDto;
import com.beckn.experienceCenter.dto.v2response.ExperienceEventResponse;
import com.beckn.experienceCenter.dto.v2response.ExperienceResponse;
import com.beckn.experienceCenter.exception.ExperienceException;
import com.beckn.experienceCenter.mapper.ExperienceEventResponseMapper;
import com.beckn.experienceCenter.mapper.ExperienceResponseMapper;
import com.beckn.experienceCenter.mapper.V2ExperienceDtoToExperienceMapper;
import com.beckn.experienceCenter.model.Experience;
import com.beckn.experienceCenter.model.V2Application;
import com.beckn.experienceCenter.model.V2Event;
import com.beckn.experienceCenter.model.V2Experience;
import com.beckn.experienceCenter.repository.V2ApplicationRepository;
import com.beckn.experienceCenter.repository.V2EventRepository;
import com.beckn.experienceCenter.repository.V2ExperienceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class V2ExperienceCenterService {
    @Autowired
    private V2ExperienceRepository experienceRepository;

    @Autowired
    private V2ApplicationRepository applicationRepository;

    @Autowired
    private V2EventRepository eventRepository;

    @Autowired
    private V2ExperienceDtoToExperienceMapper mapper;

    @Autowired
    private ExperienceResponseMapper experienceResponseMapper;

    @Autowired
    private ExperienceEventResponseMapper experienceEventResponseMapper;

    @Autowired
    private SequenceGeneratorService service;

    public ExperienceEventResponse getEventsById(String experienceId) {
        V2Experience experience = experienceRepository.findByExperienceId(experienceId);
        if (experience == null) {
            throw new ExperienceException("", "", "E-101", "No data found in database for ExperienceId : " + experienceId);
        }
        V2Application application = applicationRepository.findByAppId(experience.getApp_id());
        if (application == null) {
            //throw new ExperienceException("", "", "E-102", "No data found in database for App id : " + experience.getApp_id());
        }
        List<V2Event> events = eventRepository.findByExperienceId(experienceId);
        if (events.isEmpty()) {
            //throw new ExperienceException("", "", "E-102", "No Events found in database for ExperienceId : " + experienceId);
        }
        return experienceEventResponseMapper.mapExperienceEventResponse(experience, application, events);
    }

    public String setupExperienceSession(V2ExperienceDTO inputSession) {
        V2Experience experience = experienceRepository.findByExperienceId(inputSession.getExperienceId());
        if (experience != null) {
            throw new ExperienceException("", "", "E-101", "ExperienceId already present in Database: " + inputSession.getExperienceId());
        }
        experience = mapper.mapExperienceDtoToExperience(inputSession);
        experience.setId(service.getSequenceNumber(Experience.SEQUENCE_NAME));
        return experienceRepository.save(experience).getExperience_id();
    }

    public ExperienceResponse closeExperienceSession(V2UpdateSessionDto updateSession) {
        V2Experience experience = experienceRepository.findByExperienceId(updateSession.getExperienceId());
        if (experience == null) {
            throw new ExperienceException("", "", "E-101", "No data found in database for ExperienceId : " + updateSession.getExperienceId());
        }
        experience.setActive(false);
        experience.setEnd_ts(updateSession.getEnd_ts());
        experience.setUser_comment(updateSession.getExperienceFeedback().getUser_comment());
        experience.setUser_review(updateSession.getExperienceFeedback().getUser_review());

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss.SSS");
        Date date = new Date();
        try {
            experience.setLast_modified_at(new SimpleDateFormat("dd/MM/yyyy HH:mm:ss.SSS").parse(formatter.format(date)));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        V2Application application = applicationRepository.findByAppId(experience.getApp_id());
        if (application == null) {
            //throw new ExperienceException("", "", "E-102", "No data found in database for App id : " + experience.getApp_id());
        }
        experience = experienceRepository.save(experience);
        return experienceResponseMapper.mapExperienceResponse(experience, application);
    }
}
