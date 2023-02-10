package com.example.sleeptraker.demo.repositary;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.sleeptraker.demo.model.user;

public interface userrepositary extends  MongoRepository<user,String>{
    
    
}
