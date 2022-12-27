package com.beckn.experienceCenter.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Document(collection = "xc.event")
public class V2Event {

    @Id
    private int event_id;
    private String experience_id;
    private String event_code;
    private String action;
    private String source_app_id;
    private String destination_app_id;
    private Date start;
    private Date end;
    private String payload;
    private Date created_at;
    private Date last_modified_at;

}
