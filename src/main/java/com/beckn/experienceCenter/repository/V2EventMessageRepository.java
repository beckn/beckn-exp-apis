package com.beckn.experienceCenter.repository;

import com.beckn.experienceCenter.model.V2EventMessage;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface V2EventMessageRepository extends MongoRepository<V2EventMessage, Integer> {
    @Query(value = "{code :?0}")
    V2EventMessage findByCode(String code);
}
