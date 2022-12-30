package com.beckn.experienceCenter.controller;

import com.beckn.experienceCenter.cache.DatabaseCache;
import com.beckn.experienceCenter.dto.v2request.V2ExperienceDTO;
import com.beckn.experienceCenter.dto.v2request.V2UpdateSessionDto;
import com.beckn.experienceCenter.dto.v2response.ExperienceEventResponse;
import com.beckn.experienceCenter.dto.v2response.ExperienceResponse;
import com.beckn.experienceCenter.exception.ExperienceException;
import com.beckn.experienceCenter.service.V2ExperienceCenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v2")
public class V2ExperienceCenterController {

    @Autowired
    private V2ExperienceCenterService experienceCenterService;

    @PostMapping(value = "/xc/experience")
    public ResponseEntity<?> setupExperienceSession(@RequestBody V2ExperienceDTO inputSession) {
        if (inputSession.getExperienceId() == null) {
            return new ResponseEntity<>("Experience id is missing.", HttpStatus.BAD_REQUEST);
        }
        if (inputSession.getEventSourceAppId() == null || DatabaseCache.APPLICATION_MAP.get(inputSession.getEventSourceAppId()) == null) {
            return new ResponseEntity<>("Source app id is missing or not found in store.", HttpStatus.BAD_REQUEST);
        }
        try {
            String experienceId = experienceCenterService.setupExperienceSession(inputSession);
            return ResponseEntity.ok(experienceId);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(value = "/xc/experience")
    public ResponseEntity<?> closeExperienceSession(@RequestBody V2UpdateSessionDto updateSession) {
        if (updateSession.getExperienceId() == null) {
            return new ResponseEntity<>("Experience id is missing.", HttpStatus.BAD_REQUEST);
        }
        try {
            ExperienceResponse experienceResponse = experienceCenterService.closeExperienceSession(updateSession);
            return ResponseEntity.ok(experienceResponse);
        } catch (ExperienceException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }


    @GetMapping(value = "/event/{experienceId}")
    public ResponseEntity<?> getEventsById(@PathVariable String experienceId) {
        if (experienceId == null) {
            return new ResponseEntity<>("Experience id is missing.", HttpStatus.BAD_REQUEST);
        }
        try {
            ExperienceEventResponse experienceEventResponse = experienceCenterService.getEventsById(experienceId);
            return ResponseEntity.ok(experienceEventResponse);
        } catch (ExperienceException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping(value = "/event/event-message")
    public ResponseEntity<?> reloadEventMessages() {
        experienceCenterService.reloadEventMessages();
        return ResponseEntity.ok("");
    }
}
