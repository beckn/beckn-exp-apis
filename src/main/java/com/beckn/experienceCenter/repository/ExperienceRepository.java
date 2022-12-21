package com.beckn.experienceCenter.repository;

import com.beckn.experienceCenter.model.Experience;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface ExperienceRepository extends MongoRepository<Experience, String> {
    @Query(value = "{experience_id :?0}")
    Experience findByExperienceId(String experience_id);
}
