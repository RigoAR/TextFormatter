public class WhatsAppNotification implements Notification {
    private String phoneNumber;

    public WhatsAppNotification(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public void sendNotification(String message) {
        System.out.println("Sending WhatsApp message to " + phoneNumber + ": " + message);
    }
}