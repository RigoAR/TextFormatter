public class Main {
    public static void main(String[] args)
    {
        EventLogger logger = EventLogger.getInstance();


        logger.log("Application started!");

        logger.log("Error: Unable to connect to the database");

        System.out.println("Log History:\n" + logger.getLogHistory());

        logger.flushLogs();
    }
}
