import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileLogOutput implements LogOutputStrategy {
    private static final String LOG_FILE = "application.log";

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
