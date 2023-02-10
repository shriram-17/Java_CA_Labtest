package com.example.sleeptraker.demo.repositary;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.sleeptraker.demo.model.Tracker;

public interface Trackerrepositary extends MongoRepository<Tracker,String>{
    
}
