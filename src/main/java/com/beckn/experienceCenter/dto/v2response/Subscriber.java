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
public class Subscriber {
    private String id;
    private String type;
    private String name;
    private String uri;
    private String domainId;
    private String domainName;
}
