package com.beckn.experienceCenter.dto.v2response;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ExperienceEventResponse {
    private ExperienceResponse experienceSession;
    private List<EventResponse> events;
}
