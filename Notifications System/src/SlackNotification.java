public class SlackNotification implements Notification {
    private String slackChannel;

    public SlackNotification(String slackChannel) {
        this.slackChannel = slackChannel;
    }

    @Override
    public void sendNotification(String message)
    {
        System.out.println("Sending Slack message to channel " + slackChannel + ": " + message);
    }
}
