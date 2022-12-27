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
@Document(collection = "xc.event_message")
public class V2EventMessage {

    @Id
    private int id;
    private String code;
    private String action_message;
    private String bap_message;
    private String bpp_message;
    private Boolean active;
    private Date created_at;
    private Date last_modified_at;

}
