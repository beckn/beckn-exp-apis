package com.beckn.eventExperience.model.xc;

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
@Document(collection = "steps")
public class Steps {
    @Id
    private int id;
    private int eventId;
    private String title;
    private String source;
    private String destination;
    private Date start;
    private Date end;
    private String payload;
    private Date created_at;
    private Date last_modified_at;
}
