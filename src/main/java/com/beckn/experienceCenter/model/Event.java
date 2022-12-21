package com.beckn.experienceCenter.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Document(collection = "events")
public class Event {

    @Id
    private int event_id;
    private String experience_id;
    private String event_code;
    private String event_title;
    private String event_message;
    private String event_layer;
    private String event_source_type;
    private String event_destination_type;
    private String event_source_id;
    private String event_destination_id;
    private String payload;
    private String context_transaction_id;
    private String context_message_id;
    private Date eventStart_ts;
    private Date eventEnd_ts;
    private Date created_ts;
    private Date lastModified_ts;

}
