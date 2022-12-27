package com.beckn.experienceCenter.repository;

import com.beckn.experienceCenter.model.V2Application;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface V2ApplicationRepository extends MongoRepository<V2Application, Integer> {
    @Query(value = "{app_id :?0}")
    V2Application findByAppId(String app_id);
}
