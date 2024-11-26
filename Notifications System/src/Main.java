import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        UserPreferences user = new UserPreferences("user123", Arrays.asList(UserPreferences.NotificationPreference.SMS, UserPreferences.NotificationPreference.EMAIL));

        String phoneNumber = "123-456-7890";
        String email = "user@example.com";
        String slackChannel = "#team-updates";

        Notification sms = new SMSNotification(phoneNumber);
        Notification emailNotification = new EmailNotification(email);
        Notification slackNotification = new SlackNotification(slackChannel);

        sendNotifications(user, sms, emailNotification, slackNotification, "System Update: Maintenance scheduled at 10 PM.");
    }

    private static void sendNotifications(UserPreferences user, Notification sms, Notification email, Notification slack, String message) {
        for (UserPreferences.NotificationPreference preference : user.getPreferences()) {
            switch (preference) {
                case SMS:
                    sms.sendNotification(message);
                    break;
                case EMAIL:
                    email.sendNotification(message);
                    break;
                case SLACK:
                    slack.sendNotification(message);
                    break;
            }
        }
    }
}
