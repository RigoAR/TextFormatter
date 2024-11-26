import java.util.ArrayList;
import java.util.List;

public class NotificationHistory {
    private List<String> history;

    public NotificationHistory() {
        this.history = new ArrayList<>();
    }

    public void addNotification(String channel, String message) {
        String historyEntry = "Channel: " + channel + ", Message: " + message;
        history.add(historyEntry);
    }

    public void displayHistory() {
        if (history.isEmpty()) {
            System.out.println("No notifications have been sent.");
        } else {
            System.out.println("Notification History:");
            for (String entry : history) {
                System.out.println(entry);
            }
        }
    }
}

