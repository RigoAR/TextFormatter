import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.locks.ReentrantLock;

public class EventLogger {
    private static EventLogger instance;
    private LogLevel currentLogLevel;
    private static final String LOG_FILE = "application.log";
    private static final String ARCHIVED_LOG_DIR = "archived_logs";
    private static final long ARCHIVE_INTERVAL_MS = 60000; // 1 minute
    private static final ReentrantLock lock = new ReentrantLock();
    private long lastArchiveTime = System.currentTimeMillis();

    public enum LogLevel {
        INFO, DEBUG, ERROR
    }

    private EventLogger() {
        currentLogLevel = LogLevel.INFO;
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

    public synchronized void log(LogLevel level, String message) {
        if (level.ordinal() >= currentLogLevel.ordinal()) {
            String logMessage = formatLogMessage(level, message);
            System.out.println(logMessage);
            logToFile(logMessage);

            long currentTime = System.currentTimeMillis();
            if (currentTime - lastArchiveTime >= ARCHIVE_INTERVAL_MS) {
                archiveLogs();
                lastArchiveTime = currentTime;
            }
        }
    }

    private String formatLogMessage(LogLevel level, String message) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String timestamp = sdf.format(new Date());
        return String.format("[%s] %s: %s", timestamp, level, message);
    }

    private synchronized void logToFile(String logMessage) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(LOG_FILE, true))) {
            writer.write(logMessage);
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Error writing to log file: " + e.getMessage());
        }
    }

    public synchronized String[] getLogHistory() {
        try (BufferedReader reader = new BufferedReader(new FileReader(LOG_FILE))) {
            return reader.lines().toArray(String[]::new);
        } catch (IOException e) {
            System.out.println("Error reading log history: " + e.getMessage());
            return new String[0];
        }
    }

    public synchronized void archiveLogs() {
        lock.lock();
        try {
            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            File logFile = new File(LOG_FILE);
            if (logFile.exists()) {
                File archiveDir = new File(ARCHIVED_LOG_DIR);
                if (!archiveDir.exists()) {
                    archiveDir.mkdirs();
                }

                File archivedLog = new File(ARCHIVED_LOG_DIR, "log_" + timestamp + ".txt");
                try (BufferedReader reader = new BufferedReader(new FileReader(logFile));
                     BufferedWriter writer = new BufferedWriter(new FileWriter(archivedLog))) {
                    String line;
                    while ((line = reader.readLine()) != null) {
                        writer.write(line);
                        writer.newLine();
                    }
                }

                new BufferedWriter(new FileWriter(logFile)).close();
                System.out.println("Logs archived successfully.");
            }
        } catch (IOException e) {
            System.out.println("Error archiving logs: " + e.getMessage());
        } finally {
            lock.unlock();
        }
    }

    public synchronized void archiveLogsOnDemand() {
        archiveLogs();
    }
}
