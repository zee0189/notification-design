package com.kommunicate.design.service;

import com.kommunicate.design.model.NotificationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationTrigger {

    /**
     * This list holds all the concrete implementations of servers. such as apm, fcm, wns server
     */
    @Autowired
    private List<NotificationExecutor> notificationExecutors;

    /**
     * it takes the notification request from the client and check through all the server objects and which ever the class is
     * applicable it triggers the notification from that object
     *
     * @param notificationRequest
     */
    public void trigger(NotificationRequest notificationRequest){
         for (NotificationExecutor notificationExecutor : notificationExecutors){
             if(notificationExecutor.isApplicable(notificationRequest)){    // this check is where we figure out the right object based on the notification type
                 notificationExecutor.execute(notificationRequest);
                 return;
             }
         }
         throw new IllegalArgumentException("Invalid notification type");
    }
}
