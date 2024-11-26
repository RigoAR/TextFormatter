public class SMSNotification implements Notification {
    private String phoneNumber;
    private NotificationHistory history;

    public SMSNotification(String phoneNumber, NotificationHistory history) {
        this.phoneNumber = phoneNumber;
        this.history = history;
    }

    @Override
    public void sendNotification(String message) {
        System.out.println("Sending SMS to " + phoneNumber + ": " + message);
        history.addNotification("SMS", message);
    }
}