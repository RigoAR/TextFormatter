public class Main {
    public static void main(String[] args)
    {

        SMSNotification sms1 = new SMSNotification("123-456-7890");

        sms1.sendNotification("System Update: Maintenance scheduled at 10 PM.");
    }
}