package com.discovery.project.Repository;

import com.discovery.project.Model.MongoModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MongoRepo extends MongoRepository<MongoModel, String>  {
}
