import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class EventLogger {
    private static EventLogger instance;
    private LogLevel currentLogLevel;
    private LogOutputStrategy logOutputStrategy;
    private static final String LOG_FILE = "application.log";

    public enum LogLevel {
        INFO, DEBUG, ERROR
    }

    public interface LogOutputStrategy {
        void log(String logMessage);
    }

    public static class ConsoleLogOutput implements LogOutputStrategy {
        @Override
        public void log(String logMessage) {
            System.out.println(logMessage);
        }
    }

    public static class FileLogOutput implements LogOutputStrategy {
        @Override
        public void log(String logMessage) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(LOG_FILE, true))) {
                writer.write(logMessage);
                writer.newLine();
            } catch (IOException e) {
                System.out.println("Error writing to log file: " + e.getMessage());
            }
        }
    }

    private EventLogger() {
        currentLogLevel = LogLevel.INFO;
        logOutputStrategy = new ConsoleLogOutput();
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

    public void setLogOutputStrategy(LogOutputStrategy strategy) {
        this.logOutputStrategy = strategy;
    }

    public void log(LogLevel level, String message) {
        if (level.ordinal() >= currentLogLevel.ordinal()) {
            String logMessage = formatLogMessage(level, message);
            logOutputStrategy.log(logMessage);
        }
    }

    private String formatLogMessage(LogLevel level, String message) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String timestamp = sdf.format(new Date());
        return String.format("[%s] %s: %s", timestamp, level, message);
    }

    public String[] getLogHistory() {
        try (BufferedReader reader = new BufferedReader(new FileReader(LOG_FILE))) {
            return reader.lines().toArray(String[]::new);
        } catch (IOException e) {
            System.out.println("Error reading log history: " + e.getMessage());
            return new String[0];
        }
    }
}
