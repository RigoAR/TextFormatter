public class PushNotification implements Notification {
    private String deviceId;
    private NotificationHistory history;

    public PushNotification(String deviceId, NotificationHistory history) {
        this.deviceId = deviceId;
        this.history = history;
    }

    @Override
    public void sendNotification(String message) {
        System.out.println("Sending Push notification to " + deviceId + ": " + message);
        history.addNotification("Push Notification", message);
    }
}