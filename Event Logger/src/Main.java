public class Main {
    public static void main(String[] args) {
        EventLogger logger = EventLogger.getInstance();
        logger.setLogLevel(EventLogger.LogLevel.DEBUG);

        logger.log(EventLogger.LogLevel.INFO, "Application started");
        logger.log(EventLogger.LogLevel.DEBUG, "Debugging process...");
        logger.log(EventLogger.LogLevel.ERROR, "An error occurred");

        System.out.println("\nFull log history:");
        for (String log : logger.getLogHistory()) {
            System.out.println(log);
        }

        System.out.println("\nRecent logs:");
        for (String log : logger.getRecentLogs(2)) {
            System.out.println(log);
        }
    }
}
