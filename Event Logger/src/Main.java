public class Main {
    public static void main(String[] args) {
        EventLogger logger = EventLogger.getInstance();
        logger.setLogLevel(EventLogger.LogLevel.DEBUG);

        Thread thread1 = new Thread(() -> {
            logger.log(EventLogger.LogLevel.INFO, "Info log from thread 1");
            logger.log(EventLogger.LogLevel.DEBUG, "Debug log from thread 1");
            logger.log(EventLogger.LogLevel.ERROR, "Error log from thread 1");
        });

        Thread thread2 = new Thread(() -> {
            logger.log(EventLogger.LogLevel.INFO, "Info log from thread 2");
            logger.log(EventLogger.LogLevel.DEBUG, "Debug log from thread 2");
            logger.log(EventLogger.LogLevel.ERROR, "Error log from thread 2");
        });

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        logger.archiveLogsOnDemand();

        String[] logHistory = logger.getLogHistory();
        for (String log : logHistory) {
            System.out.println(log);
        }
    }
}
