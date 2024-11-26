import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class EventLogger {
    private static EventLogger instance;
    private LogLevel currentLogLevel;
    private LogDestination currentLogDestination;
    private static final String LOG_FILE = "application.log";

    public enum LogLevel {
        INFO, DEBUG, ERROR
    }

    public enum LogDestination {
        CONSOLE, FILE, REMOTE
    }

    private EventLogger() {
        currentLogLevel = LogLevel.INFO;
        currentLogDestination = LogDestination.CONSOLE;
    }

    public static EventLogger getInstance() {
        if (instance == null) {
            synchronized (EventLogger.class) {
                if (instance == null) {
                    instance = new EventLogger();
                }
            }
        }
        return instance;
    }

    public void setLogLevel(LogLevel level) {
        this.currentLogLevel = level;
    }

    public void setLogDestination(LogDestination destination) {
        this.currentLogDestination = destination;
    }

    public synchronized void log(LogLevel level, String message) {
        if (level.ordinal() >= currentLogLevel.ordinal()) {
            String logMessage = formatLogMessage(level, message);

            switch (currentLogDestination) {
                case CONSOLE:
                    logToConsole(logMessage);
                    break;
                case FILE:
                    logToFile(logMessage);
                    break;
                case REMOTE:
                    logToRemote(logMessage);
                    break;
            }
        }
    }

    private String formatLogMessage(LogLevel level, String message) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String timestamp = sdf.format(new Date());
        return String.format("[%s] %s: %s", timestamp, level, message);
    }

    private void logToConsole(String logMessage) {
        System.out.println(logMessage);
    }

    private void logToFile(String logMessage) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(LOG_FILE, true))) {
            writer.write(logMessage);
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Error writing to log file: " + e.getMessage());
        }
    }

    private void logToRemote(String logMessage) {
        System.out.println("Sending log to remote server: " + logMessage);
    }

    public synchronized String[] getLogHistory() {
        try (BufferedReader reader = new BufferedReader(new FileReader(LOG_FILE))) {
            return reader.lines().toArray(String[]::new);
        } catch (IOException e) {
            System.out.println("Error reading log history: " + e.getMessage());
            return new String[0];
        }
    }
}
