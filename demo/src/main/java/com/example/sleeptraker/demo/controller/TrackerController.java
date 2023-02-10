package com.example.sleeptraker.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.sleeptraker.demo.model.Tracker;
import com.example.sleeptraker.demo.service.trackerservice;

@RequestMapping("/addSleep")
@RestController
public class TrackerController {
    @Autowired
    private trackerservice service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Tracker createTask(@RequestBody Tracker t){
        return service.addTask(t);
    }

    @GetMapping("/{taskId}")
    public Tracker getTask(@PathVariable String taskId)
    {
        return service.getTaskbyTaskId(taskId);
    }

    @PutMapping("/update")
    public Tracker modify(@RequestBody Tracker t)
    {
        return service.updateTask(t);
    }

    @DeleteMapping("/{taskId}")
    public String deleteTask(@PathVariable String taskId)
    {
        return service.deleteTaskId( taskId);
    }

}
