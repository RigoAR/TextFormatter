public class EmailNotification implements Notification {
    private String email;
    private NotificationHistory history;

    public EmailNotification(String email, NotificationHistory history) {
        this.email = email;
        this.history = history;
    }

    @Override
    public void sendNotification(String message) {
        System.out.println("Sending Email to " + email + ": " + message);
        history.addNotification("Email", message);
    }
}