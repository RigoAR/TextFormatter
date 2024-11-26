import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

enum LogLevel {
    INFO, DEBUG, ERROR
}

public class EventLogger {
    private static EventLogger instance;
    private List<String> logHistory;
    private LogLevel currentLogLevel;

    private EventLogger() {
        logHistory = new ArrayList<>();
        currentLogLevel = LogLevel.INFO;
    }

    public static EventLogger getInstance() {
        if (instance == null) {
            instance = new EventLogger();
        }
        return instance;
    }

    public void setLogLevel(LogLevel logLevel) {
        this.currentLogLevel = logLevel;
    }

    public void logInfo(String message) {
        log(LogLevel.INFO, message);
    }

    public void logDebug(String message) {
        log(LogLevel.DEBUG, message);
    }

    public void logError(String message) {
        log(LogLevel.ERROR, message);
    }

    private void log(LogLevel logLevel, String message) {
        if (logLevel.ordinal() >= currentLogLevel.ordinal()) {
            String logMessage = String.format("[%s] %s: %s", logLevel, java.time.LocalDateTime.now(), message);
            System.out.println(logMessage);
            logHistory.add(logMessage);
        }
    }

    public List<String> getLogHistory() {
        return logHistory;
    }

    public void saveToFile(String filename) {
        try (FileWriter writer = new FileWriter(filename)) {
            for (String log : logHistory) {
                writer.write(log + System.lineSeparator());
            }
            System.out.println("Logs saved to file: " + filename);
        } catch (IOException e) {
            System.out.println("Error saving log file: " + e.getMessage());
        }
    }

    public void flushLogs() {
        logHistory.clear();
        System.out.println("Logs flushed.");
    }
}


