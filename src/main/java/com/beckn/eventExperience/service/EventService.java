package com.beckn.eventExperience.service;

import com.beckn.eventExperience.model.xc.Event;
import com.beckn.eventExperience.model.xc.EventSteps;
import com.beckn.eventExperience.model.xc.Steps;
import com.beckn.eventExperience.repository.EventRepository;
import com.beckn.eventExperience.repository.StepsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventService {
    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private StepsRepository stepsRepository;

    public Event saveOrUpdateEvent(Event inputEvent) {
        return eventRepository.save(inputEvent);
    }

    public Steps saveOrUpdateSteps(Steps inputSteps) {
        return stepsRepository.save(inputSteps);
    }

    public EventSteps getEventsById(String domainId) {
        EventSteps eventSteps = new EventSteps();
        Event event = eventRepository.findByDomainId(domainId).get(0);
        eventSteps.setEvent(event);
        eventSteps.setSteps(stepsRepository.findbyEventId(event.getId()));
        return eventSteps;
    }
}
