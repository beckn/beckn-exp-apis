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
@Document(collection = "xc.application")
public class V2Application {
    @Id
    private int id;
    private String app_id;
    private String domain_id;
    private String type;
    private String name;
    private String uri;
    private String api_key;
    private Date created_at;
    private Date last_modified_at;
}
