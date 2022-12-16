package com.beckn.eventExperience.repository;

import com.beckn.eventExperience.model.xc.Event;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface EventRepository extends MongoRepository<Event, String> {
    @Query(value = "{domainId :?0}", sort= "{last_modified_at:-1}")
    List<Event> findByDomainId(String domainId);
}
