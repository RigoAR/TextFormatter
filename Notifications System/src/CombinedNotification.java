import java.util.ArrayList;
import java.util.List;

public class CombinedNotification implements Notification {
    private List<Notification> notificationMethods = new ArrayList<>();

    public void addNotificationMethod(Notification notification) {
        notificationMethods.add(notification);
    }

    @Override
    public void sendNotification(String message) {
        for (Notification notification : notificationMethods) {
            notification.sendNotification(message);
        }
    }
}
