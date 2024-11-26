public class SMSNotification implements Notification {
    private String phoneNumber;

    public SMSNotification(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public void sendNotification(String message) {
        // Logic to send SMS using an external service (simulated here)
        System.out.println("Sending SMS to " + phoneNumber + ": " + message);
        // In a real implementation, you'd integrate with an SMS gateway here.
    }
}
