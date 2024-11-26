public class Main {
    public static void main(String[] args)
    {

        SMSNotification sms1 = new SMSNotification("123-456-7890");

        sms1.sendNotification("System Update: Maintenance scheduled at 10 PM.");


        String userEmail = "user@example.com";

        Notification email = new EmailNotification(userEmail);

        email.sendNotification("System Update: Maintenance scheduled at 10 PM.");

        String slackChannel = "#team-updates"; // Example Slack channel
        Notification slack = new SlackNotification(slackChannel);

        slack.sendNotification("System Update: Maintenance scheduled at 10 PM.");
    }

}