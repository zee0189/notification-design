package com.kommunicate.design.service.server;

import com.kommunicate.design.model.NotificationRequest;
import com.kommunicate.design.service.NotificationExecutor;
import org.springframework.stereotype.Service;

@Service
public class WNSServer extends NotificationExecutor {

    public static final String TYPE = "WNS_SERVER";

    @Override
    public boolean isApplicable(NotificationRequest notificationRequest) {
        return notificationRequest.getNotificationType().equals(TYPE);
    }

    @Override
    protected Boolean isValid(NotificationRequest notificationRequest) {
        return true;
    }

    @Override
    protected void triggerNotification(NotificationRequest notificationRequest) {
        System.out.println("Triggering notification through WNS server.");
    }
}
