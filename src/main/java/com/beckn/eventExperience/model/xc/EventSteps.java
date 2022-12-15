package com.beckn.eventExperience.model.xc;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class EventSteps {
    private Event event;
    private List<Steps> steps;
}
