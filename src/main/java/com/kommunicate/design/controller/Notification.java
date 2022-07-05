package com.kommunicate.design.controller;

import com.kommunicate.design.model.NotificationRequest;
import DesignPattern.Behavioral.commad.NotificationTrigger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/notification")
@Controller
public class Notification {

    @Autowired
    private NotificationTrigger notificationTrigger;

    @PostMapping("/trigger")
    public ResponseEntity<?> triggerNotification(@RequestBody NotificationRequest notificationRequestModel){
         notificationTrigger.trigger(notificationRequestModel);
         return new ResponseEntity<>(HttpStatus.OK);
    }

}
