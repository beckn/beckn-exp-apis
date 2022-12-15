package com.beckn.eventExperience.model.xc;

import com.mongodb.lang.NonNull;
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
@Document(collection = "events")
public class Event {
    @Id
    private int id;
    @NonNull
    private int domain_id;
    @NonNull
    private String title;
    @NonNull
    private String type;
    private Date start;
    private Date end;
    private Date created_at;
    private Date last_modified_at;

}
