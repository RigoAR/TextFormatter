import java.util.ArrayList;
import java.util.List;

public class EventLogger {
    private static EventLogger instance;
    private List<String> logHistory;
    private LogLevel currentLogLevel;

    public enum LogLevel {
        INFO,
        DEBUG,
        ERROR
    }

    private EventLogger() {
        logHistory = new ArrayList<>();
        currentLogLevel = LogLevel.INFO;
    }

    public static synchronized EventLogger getInstance() {
        if (instance == null) {
            instance = new EventLogger();
        }
        return instance;
    }

    public void setLogLevel(LogLevel level) {
        this.currentLogLevel = level;
    }

    public void log(LogLevel level, String message) {
        if (shouldLog(level)) {
            String logMessage = String.format("[%s] - %s: %s", level, java.time.LocalDateTime.now(), message);
            logHistory.add(logMessage);
            System.out.println(logMessage);
        }
    }

    private boolean shouldLog(LogLevel level) {
        return level.ordinal() >= currentLogLevel.ordinal();
    }

    public List<String> getLogHistory() {
        return new ArrayList<>(logHistory);
    }

    public List<String> getRecentLogs(int count) {
        int start = Math.max(logHistory.size() - count, 0);
        return new ArrayList<>(logHistory.subList(start, logHistory.size()));
    }

    public void clearLogs() {
        logHistory.clear();
    }
}
