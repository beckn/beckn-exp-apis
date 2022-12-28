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
    private Subscriber eventSource;
    private Subscriber eventDestination;
    private EventMessage eventMessage;
    private EventTimeline eventTimeline;
    private String payload;
}
