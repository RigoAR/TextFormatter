public class Main {
    public static void main(String[] args)
    {
        Notification sms = new SMSNotification();
        sms.sendNotification("System Update: Maintenance scheduled at 10 PM.");

        Notification email = new EmailNotification();
        email.sendNotification("System Update: Maintenance scheduled at 10 PM.");

        CombinedNotification combined = new CombinedNotification();
        combined.addNotificationMethod(sms);
        combined.addNotificationMethod(email);
        combined.sendNotification("System Update: Maintenance scheduled at 10 PM.");

        Notification slack = new SlackNotification();
        combined.addNotificationMethod(slack);
        combined.sendNotification("System Update: Maintenance scheduled at 10 PM.");
    }
}