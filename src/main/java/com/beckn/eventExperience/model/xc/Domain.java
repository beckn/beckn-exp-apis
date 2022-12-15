package com.beckn.eventExperience.model.xc;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.lang.NonNull;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Document(collection = "domains")
public class Domain {
    @Id
    private int id;
    @NonNull
    private String title;
    @NonNull
    private String type;
    private String repo_url;
    private Date created_at;
    private Date last_modified_at;
}
