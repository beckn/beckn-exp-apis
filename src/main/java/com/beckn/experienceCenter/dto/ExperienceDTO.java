package com.beckn.experienceCenter.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ExperienceDTO {
    private String experienceId;
    private String domainId;
    private String eventSourceAppId;
    private Boolean active;
    private Date start_ts;
    private Date end_ts;
    private Date created_ts;
    private Date lastModified_ts;
}
