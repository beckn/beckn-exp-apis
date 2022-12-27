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
public class EventMessage {
    private String eventCode;
    private String action;
    private String actionMessage;
    private String bapMessage;
    private String bppMessage;
}