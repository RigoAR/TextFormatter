public class Main {
    public static void main(String[] args) {
        EventLogger logger = EventLogger.getInstance();


        logger.setLogLevel(EventLogger.LogLevel.INFO);


        logger.log(EventLogger.LogLevel.INFO, "Application started.");
        logger.log(EventLogger.LogLevel.DEBUG, "Debugging application.");
        logger.log(EventLogger.LogLevel.ERROR, "An error occurred.");


        System.out.println("Log history:");
        for (String log : logger.getLogHistory()) {
            System.out.println(log);
        }


        logger.log(EventLogger.LogLevel.INFO, "Processing user input.");
        logger.log(EventLogger.LogLevel.ERROR, "Error while processing request.");
    }
}
