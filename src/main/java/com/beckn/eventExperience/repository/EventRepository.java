package com.beckn.eventExperience.repository;

import com.beckn.eventExperience.model.xc.Event;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EventRepository extends MongoRepository<Event, Integer> {
}
