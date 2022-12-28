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
public class EventResponse {
    private int eventId;
    private String action;
    private Event event;
}
