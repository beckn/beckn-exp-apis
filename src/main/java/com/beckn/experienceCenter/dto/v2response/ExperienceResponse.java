package com.beckn.experienceCenter.dto.v2response;

import com.beckn.experienceCenter.dto.ExperienceFeedback;
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
public class ExperienceResponse {
    private String experienceId;
    private String experienceCenterId;
    private ExperienceSource experienceSource;
    private Boolean active;
    private ExperienceFeedback experienceFeedback;
    private ExperienceTimeline experienceTimeline;

}
