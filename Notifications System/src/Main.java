import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        NotificationHistory history = new NotificationHistory();

        UserPreferences user = new UserPreferences("user123abc", Arrays.asList(
                UserPreferences.NotificationPreference.SMS,
                UserPreferences.NotificationPreference.WHATSAPP
        ));

        String phoneNumber = "123-456-7890";
        String email = "rigo@example.com";
        String slackChannel = "team-updates";
        String userDevice = "device123abc";

        Notification sms = new SMSNotification(phoneNumber, history);
        Notification emailNotification = new EmailNotification(email, history);
        Notification slackNotification = new SlackNotification(slackChannel, history);
        Notification whatsappNotification = new WhatsAppNotification(phoneNumber, history);
        Notification pushNotification = new PushNotification(userDevice, history);

        sendNotifications(user, sms, emailNotification, slackNotification,
                whatsappNotification, pushNotification,
                "System Update: Maintenance scheduled at 10 PM.");

        history.displayHistory();
    }

    private static void sendNotifications(UserPreferences user,
                                          Notification sms,
                                          Notification email,
                                          Notification slack,
                                          Notification whatsapp,
                                          Notification push,
                                          String message)
    {
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
                case WHATSAPP:
                    whatsapp.sendNotification(message);
                    break;
                case PUSH_NOTIFICATION:
                    push.sendNotification(message);
                    break;
            }
        }
    }
}
