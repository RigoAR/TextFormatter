import java.util.List;

public class UserPreferences {
    private String userId;
    private List<NotificationPreference> preferences;

    public UserPreferences(String userId, List<NotificationPreference> preferences) {
        this.userId = userId;
        this.preferences = preferences;
    }

    public List<NotificationPreference> getPreferences() {
        return preferences;
    }

    public String getUserId() {
        return userId;
    }

    public enum NotificationPreference {
        SMS,
        EMAIL,
        SLACK
    }

}

