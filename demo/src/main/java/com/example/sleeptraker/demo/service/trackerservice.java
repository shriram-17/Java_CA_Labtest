package com.example.sleeptraker.demo.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sleeptraker.demo.model.Tracker;
import com.example.sleeptraker.demo.repositary.Trackerrepositary;

@Service
public class trackerservice {

    @Autowired
    private Trackerrepositary respository;
    
    public Tracker addTask( Tracker t)
    {    
        t.setTaskId(UUID.randomUUID().toString().split("_")[0]);
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
        Date date = new Date();
        t.setDate(formatter.format(date));    
        float Total_Time =t.getSleep_time()-t.getWakeup_time();
        t.setTotal_sleepTime(Total_Time);
        return respository.save(t);
    }
    

    public Tracker getTaskbyTaskId(String taskId)
    {
        return respository.findById(taskId).get();
    }

    public Tracker updateTask(Tracker taskrequest)
    {
        Tracker curentTask =respository.findById(taskrequest.getTaskId()).get();
        curentTask.setSleep_time(taskrequest.getSleep_time());
        curentTask.setWakeup_time(taskrequest.getWakeup_time());
        float Total_Time =curentTask.getSleep_time()-curentTask.getSleep_time();
        curentTask.setTotal_sleepTime(Total_Time);
        return respository.save(curentTask);
    }

    public String deleteTaskId(String Taskid)
    {
        respository.deleteById(Taskid);
        return "The Record is Deleted";
    }

}
