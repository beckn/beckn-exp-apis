package com.beckn.experienceCenter.repository;

import com.beckn.experienceCenter.model.V2Event;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface V2EventRepository extends MongoRepository<V2Event, Integer> {
    @Query(value = "{experience_id :?0}", sort= "{last_modified_at:-1}")
    List<V2Event> findByExperienceId(String experience_id);
}
