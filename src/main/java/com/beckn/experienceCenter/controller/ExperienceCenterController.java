package com.beckn.experienceCenter.controller;

import com.beckn.experienceCenter.dto.ExperienceDTO;
import com.beckn.experienceCenter.dto.UpdateSessionDto;
import com.beckn.experienceCenter.exception.ExperienceException;
import com.beckn.experienceCenter.model.Experience;
import com.beckn.experienceCenter.model.ExperienceResult;
import com.beckn.experienceCenter.service.ExperienceCenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class ExperienceCenterController {

    @Autowired
    private ExperienceCenterService experienceCenterService;

    @PostMapping(value = "/xc/experience")
    public ResponseEntity<?> setupExperienceSession(@RequestBody ExperienceDTO inputSession) {
        if (inputSession.getExperienceId() == null) {
            return new ResponseEntity<>("Experience id is missing.", HttpStatus.BAD_REQUEST);
        }
        if (inputSession.getEventSourceAppId() == null) {
            return new ResponseEntity<>("App id is missing.", HttpStatus.BAD_REQUEST);
        }
        if (inputSession.getDomainId() == null) {
            return new ResponseEntity<>("Domain Id is missing.", HttpStatus.BAD_REQUEST);
        }
        try {
            Experience experience = experienceCenterService.setupExperienceSession(inputSession);
            return ResponseEntity.ok(experience);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(value = "/xc/experience")
    public ResponseEntity<?> closeExperienceSession(@RequestBody UpdateSessionDto updateSession) {
        if (updateSession.getExperienceId() == null) {
            return new ResponseEntity<>("Experience id is missing.", HttpStatus.BAD_REQUEST);
        }
        try {
            Experience experience = experienceCenterService.closeExperienceSession(updateSession);
            return ResponseEntity.ok(experience);
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
            ExperienceResult experienceResult = experienceCenterService.getEventsById(experienceId);
            return ResponseEntity.ok(experienceResult);
        } catch (ExperienceException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }

    }
}
