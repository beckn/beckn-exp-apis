package com.beckn.experienceCenter.dto.v2response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Event {
    private EventSource eventSource;
    private EventDestination eventDestination;
    private EventMessage eventMessage;
    private EventTimeline eventTimeline;
    private String payload;
}
