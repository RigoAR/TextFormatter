public class WhatsAppNotification implements Notification {
    private String phoneNumber;
    private NotificationHistory history;

    public WhatsAppNotification(String phoneNumber, NotificationHistory history) {
        this.phoneNumber = phoneNumber;
        this.history = history;
    }

    @Override
    public void sendNotification(String message) {
        System.out.println("Sending WhatsApp message to " + phoneNumber + ": " + message);
        history.addNotification("WhatsApp", message);
    }
}