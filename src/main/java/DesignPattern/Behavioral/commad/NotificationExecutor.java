package DesignPattern.Behavioral.commad;

import com.kommunicate.design.model.NotificationRequest;

public abstract class NotificationExecutor {

    public void execute(final NotificationRequest notificationRequest){
       if(!isValid(notificationRequest)){
           throw new IllegalArgumentException("Not a valid request");
       }
       triggerNotification(notificationRequest);
    }

    public abstract boolean isApplicable(final NotificationRequest notificationRequest);

    protected abstract Boolean isValid(final NotificationRequest notificationRequest);

    protected abstract void triggerNotification(final NotificationRequest notificationRequest);

}
