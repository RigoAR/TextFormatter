import java.io.*;
import java.util.concurrent.locks.ReentrantLock;

public class EventLogger {
    private static EventLogger instance;

    private static final ReentrantLock lock = new ReentrantLock();

    private File logFile;


    private EventLogger() {
        this.logFile = new File("application.log");
    }

    public static EventLogger getInstance() {
        if (instance == null) {
            lock.lock();
            try {
                if (instance == null) {
                    instance = new EventLogger();
                }
            } finally {
                lock.unlock();
            }
        }
        return instance;
    }


    public synchronized void log(String message) {
        try {
            try (FileWriter writer = new FileWriter(logFile, true);
                 BufferedWriter bufferedWriter = new BufferedWriter(writer)) {
                bufferedWriter.write(message);
                bufferedWriter.newLine();
            }

            System.out.println(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public synchronized String getLogHistory() {
        StringBuilder logHistory = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(logFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                logHistory.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return logHistory.toString();
    }


    public synchronized void flushLogs() {
        try (FileWriter writer = new FileWriter(logFile)) {
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

