package com.beckn.experienceCenter.mapper;

import com.beckn.experienceCenter.dto.ExperienceFeedback;
import com.beckn.experienceCenter.dto.v2response.ExperienceResponse;
import com.beckn.experienceCenter.dto.v2response.ExperienceTimeline;
import com.beckn.experienceCenter.dto.v2response.Subscriber;
import com.beckn.experienceCenter.model.V2Application;
import com.beckn.experienceCenter.model.V2Experience;
import org.springframework.stereotype.Component;

@Component
public class ExperienceResponseMapper {
    public ExperienceResponse mapExperienceResponse(V2Experience experience, V2Application application) {
        ExperienceResponse experienceSession = new ExperienceResponse();
        experienceSession.setExperienceId(experience.getExperience_id());
        experienceSession.setExperienceCenterId(experience.getExperience_center_id());

        Subscriber subscriber = new Subscriber(
                application.getApp_id(),
                application.getType(),
                application.getName(),
                application.getUri(),
                application.getDomain_id(),
                ""
        );
        experienceSession.setExperienceSource(subscriber);

        experienceSession.setActive(experience.getActive());

        ExperienceFeedback experienceFeedback = new ExperienceFeedback(experience.getUser_review(), experience.getUser_comment());
        experienceSession.setExperienceFeedback(experienceFeedback);

        ExperienceTimeline experienceTimeline = new ExperienceTimeline(
                experience.getStart_ts(),
                experience.getEnd_ts(),
                experience.getCreated_at(),
                experience.getLast_modified_at()
        );
        experienceSession.setExperienceTimeline(experienceTimeline);
        return experienceSession;
    }
}
