public class Main {
    public static void main(String[] args) {

        EventLogger logger = EventLogger.getInstance();


        logger.setLogLevel(LogLevel.DEBUG);

        logger.logInfo("Application started.");
        logger.logDebug("Debugging the application.");
        logger.logError("An error occurred during processing.");

        System.out.println("Log history: ");
        for (String log : logger.getLogHistory()) {
            System.out.println(log);
        }

        logger.saveToFile("application_logs.txt");

        logger.flushLogs();
    }
}
