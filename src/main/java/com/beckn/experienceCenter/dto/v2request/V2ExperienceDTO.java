package com.beckn.experienceCenter.dto.v2request;


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
public class V2ExperienceDTO {
    private String experienceId;
    private String experienceCenterId;
    private String eventSourceAppId;
    private Date start_ts;
}
