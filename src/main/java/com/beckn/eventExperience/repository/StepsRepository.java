package com.beckn.eventExperience.repository;

import com.beckn.eventExperience.model.xc.Steps;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface StepsRepository extends MongoRepository<Steps, Integer> {
    @Query("{eventId :?0}")
    public List<Steps> findbyEventId(Integer eventId);
}
