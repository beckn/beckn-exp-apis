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
@Document(collection = "xc.experience")
public class Experience {
    @Transient
    public static final String SEQUENCE_NAME = "experience_sequence";
    @Id
    private int id;
    private String experience_id;
    private int app_id;
    private Boolean active;
    private Date start_ts;
    private Date end_ts;
    private Date created_at;
    private Date last_modified_at;
}
