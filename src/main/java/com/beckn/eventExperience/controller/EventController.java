package com.beckn.eventExperience.controller;

import com.beckn.eventExperience.model.xc.Domain;
import com.beckn.eventExperience.model.xc.Event;
import com.beckn.eventExperience.model.xc.EventSteps;
import com.beckn.eventExperience.model.xc.Steps;
import com.beckn.eventExperience.repository.DomainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.beckn.eventExperience.service.EventService;

@RestController
@RequestMapping("/")
public class EventController {

    @Autowired
    private EventService eventService;

    @Autowired
    private DomainRepository domainRepository;

    @PostMapping(value = "/events")
    public ResponseEntity<Event> saveOrUpdateEvent(@RequestBody Event inputEvent) {
        Event event = eventService.saveOrUpdateEvent(inputEvent);
        return ResponseEntity.ok(event);
    }

    @PostMapping(value = "/event-steps")
    public ResponseEntity<Steps> saveOrUpdateStep(@RequestBody Steps inputSteps) {
        Steps steps = eventService.saveOrUpdateSteps(inputSteps);
        return ResponseEntity.ok(steps);
    }

    @PostMapping(value = "/domains")
    public ResponseEntity<Domain> saveOrUpdateDomain(@RequestBody Domain inputDomain) {
        Domain domain = domainRepository.save(inputDomain);
        return ResponseEntity.ok(domain);
    }

    @GetMapping(value = "/events/{domainId}")
    public ResponseEntity<EventSteps> getEventsById(@PathVariable String domainId) {
        EventSteps eventSteps = eventService.getEventsById(domainId);
        return ResponseEntity.ok(eventSteps);
    }
}
