public class SlackNotification implements Notification {
    @Override
    public void sendNotification(String message) {
        System.out.println("Sending Slack Message: " + message);
    }
}

