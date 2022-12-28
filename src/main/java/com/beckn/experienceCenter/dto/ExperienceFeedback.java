package com.beckn.experienceCenter.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@Getter
@NoArgsConstructor
@Setter
public class ExperienceFeedback {
    private Character user_review;
    private String user_comment;
}
