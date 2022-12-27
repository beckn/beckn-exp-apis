package com.beckn.experienceCenter.mapper;

import com.beckn.experienceCenter.dto.v2response.EventResponse;
import com.beckn.experienceCenter.dto.v2response.ExperienceEventResponse;
import com.beckn.experienceCenter.model.V2Application;
import com.beckn.experienceCenter.model.V2Event;
import com.beckn.experienceCenter.model.V2Experience;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ExperienceEventResponseMapper {

    @Autowired
    ExperienceResponseMapper experienceResponseMapper;
    @Autowired
    EventMapper eventMapper;

    public ExperienceEventResponse mapExperienceEventResponse(V2Experience experience, V2Application application, List<V2Event> events) {
        ExperienceEventResponse experienceEventResponse = new ExperienceEventResponse();
        experienceEventResponse.setExperienceSession(experienceResponseMapper.mapExperienceResponse(experience, application));
        List<EventResponse> eventResponses = new ArrayList<>();
        for (V2Event event : events) {
            EventResponse eventResponse = new EventResponse();
            eventResponse.setEventId(event.getEvent_id());
            eventResponse.setEvent(eventMapper.mapEventResponse(event));
            eventResponses.add(eventResponse);
        }
        experienceEventResponse.setEvents(eventResponses);

        return experienceEventResponse;
    }
}
