package com.beckn.experienceCenter.dto.v2request;

import com.beckn.experienceCenter.dto.ExperienceFeedback;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@AllArgsConstructor
@Getter
@NoArgsConstructor
@Setter
public class V2UpdateSessionDto {
    private String experienceId;
    private Date end_ts;
    private ExperienceFeedback experienceFeedback;
}
