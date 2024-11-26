import java.util.ArrayList;
import java.util.List;

public class UserPreferences {
    private String userId;
    private List<NotificationPreference> preferences;

    public enum NotificationPreference {
        SMS,
        EMAIL,
        SLACK,
        WHATSAPP,
        PUSH_NOTIFICATION
    }

    public UserPreferences(String userId, List<NotificationPreference> preferences) {
        this.userId = userId;
        this.preferences = new ArrayList<>(preferences);
    }

    public List<NotificationPreference> getPreferences() {
        return preferences;
    }

    public void enableNotificationChannel(NotificationPreference preference) {
        if (!preferences.contains(preference)) {
            preferences.add(preference);
        }
    }

    public void disableNotificationChannel(NotificationPreference preference) {
        preferences.remove(preference);
    }

    public void displayPreferences() {
        System.out.println("User Preferences: " + preferences);
    }
}
