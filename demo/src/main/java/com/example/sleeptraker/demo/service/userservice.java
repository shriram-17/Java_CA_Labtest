package com.example.sleeptraker.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.UUID;
import com.example.sleeptraker.demo.model.user;
import com.example.sleeptraker.demo.repositary.userrepositary;

@Service
public class userservice {
    @Autowired
    private userrepositary resUserrepositary;

    public user UserAdd(user u)
    {
        u.setUid(UUID.randomUUID().toString().split("_")[0]);
        return resUserrepositary.save(u);

    }

    public String checkuUser(user t)
    {
        user a =resUserrepositary.findById(t.getUid()).get();
        boolean val =a.getPassword().equals(t.getPassword());
        if (val)
        {
            return "User Invalid";
        }
        else
        {
            return "User Valid";
        }
    }
}
