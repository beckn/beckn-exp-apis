package com.beckn.experienceCenter.mapper;

import com.beckn.experienceCenter.cache.DatabaseCache;
import com.beckn.experienceCenter.dto.v2response.Event;
import com.beckn.experienceCenter.dto.v2response.EventMessage;
import com.beckn.experienceCenter.dto.v2response.EventTimeline;
import com.beckn.experienceCenter.dto.v2response.Subscriber;
import com.beckn.experienceCenter.model.V2Application;
import com.beckn.experienceCenter.model.V2Event;
import com.beckn.experienceCenter.model.V2EventMessage;
import com.beckn.experienceCenter.repository.V2ApplicationRepository;
import com.beckn.experienceCenter.repository.V2EventMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EventMapper {

    @Autowired
    V2EventMessageRepository eventMessageRepository;

    @Autowired
    V2ApplicationRepository applicationRepository;

    public Event mapEventResponse(V2Event v2Event) {
        Event event = new Event();

        V2EventMessage v2EventMessage = DatabaseCache.EVENT_MESSAGE_MAP.get(v2Event.getEvent_code());
        EventMessage eventMessage = new EventMessage(
                v2EventMessage.getCode(),
                v2EventMessage.getAction_message(),
                v2EventMessage.getBap_message(),
                v2EventMessage.getBpp_message()
        );
        event.setEventMessage(eventMessage);

        V2Application application = DatabaseCache.APPLICATION_MAP.get(v2Event.getSource_app_id());
        Subscriber eventSource = new Subscriber(
                application.getApp_id(),
                application.getType(),
                application.getName(),
                application.getUri(),
                application.getDomain_id(),
                ""
        );
        event.setEventSource(eventSource);

        application = DatabaseCache.APPLICATION_MAP.get(v2Event.getDestination_app_id());
        Subscriber eventDestination = new Subscriber(
                application.getApp_id(),
                application.getType(),
                application.getName(),
                application.getUri(),
                application.getDomain_id(),
                ""
        );
        event.setEventDestination(eventDestination);

        EventTimeline eventTimeline = new EventTimeline(
                v2Event.getStart(),
                v2Event.getEnd(),
                v2Event.getCreated_at(),
                v2Event.getLast_modified_at()
        );
        event.setEventTimeline(eventTimeline);

        event.setPayload(v2Event.getPayload());
        return event;
    }
}
