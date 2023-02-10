package com.example.sleeptraker.demo.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "Tracker")
public class Tracker {
    @Id
    private String taskId; 

    private String date;

    private float wakeup_time;

    private float sleep_time;
    
    private float total_sleepTime;

}
