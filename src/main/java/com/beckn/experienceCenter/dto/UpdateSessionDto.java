package com.beckn.experienceCenter.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@AllArgsConstructor
@Getter
@NoArgsConstructor
@Setter
public class UpdateSessionDto {
    private String experienceId;
    private Date end_ts;
}
