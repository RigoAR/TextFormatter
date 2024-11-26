public class SlackNotification implements Notification {
    private String channel;
    private NotificationHistory history;

    public SlackNotification(String channel, NotificationHistory history) {
        this.channel = channel;
        this.history = history;
    }

    @Override
    public void sendNotification(String message) {
        System.out.println("Sending Slack message to " + channel + ": " + message);
        history.addNotification("Slack", message);
    }
}