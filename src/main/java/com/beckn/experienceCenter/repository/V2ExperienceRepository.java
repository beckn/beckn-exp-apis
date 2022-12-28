package com.beckn.experienceCenter.repository;

import com.beckn.experienceCenter.model.V2Experience;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface V2ExperienceRepository extends MongoRepository<V2Experience, String> {
    @Query(value = "{experience_id :?0}")
    V2Experience findByExperienceId(String experience_id);
}
