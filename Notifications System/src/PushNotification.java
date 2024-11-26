public class PushNotification implements Notification {
    private String userDevice;

    public PushNotification(String userDevice) {
        this.userDevice = userDevice;
    }

    @Override
    public void sendNotification(String message) {
        System.out.println("Sending Push Notification to device " + userDevice + ": " + message);
    }
}