package com.beckn.eventExperience.repository;

import com.beckn.eventExperience.model.xc.Domain;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DomainRepository extends MongoRepository<Domain, Integer> {
}
