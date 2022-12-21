package com.beckn.experienceCenter.repository;

import com.beckn.experienceCenter.model.Event;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface EventRepository extends MongoRepository<Event, Integer> {
    @Query(value = "{experience_id :?0}", sort= "{lastModified_ts:-1}")
    List<Event> findByExperienceId(String experience_id);
}
