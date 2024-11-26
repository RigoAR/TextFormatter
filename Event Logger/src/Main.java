public class Main {
    public static void main(String[] args) {
        EventLogger logger = EventLogger.getInstance();
        logger.setLogLevel(EventLogger.LogLevel.DEBUG);

        logger.log(EventLogger.LogLevel.INFO, "Application started");
        logger.log(EventLogger.LogLevel.DEBUG, "Connecting to database...");
        logger.log(EventLogger.LogLevel.ERROR, "Database connection failed");

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                logger.log(EventLogger.LogLevel.INFO, "Info log from thread 1");
                logger.log(EventLogger.LogLevel.DEBUG, "Debug log from thread 1");
                logger.log(EventLogger.LogLevel.ERROR, "Error log from thread 1");
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                logger.log(EventLogger.LogLevel.INFO, "Info log from thread 2");
                logger.log(EventLogger.LogLevel.DEBUG, "Debug log from thread 2");
                logger.log(EventLogger.LogLevel.ERROR, "Error log from thread 2");
            }
        });

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String[] logHistory = logger.getLogHistory();
        for (String log : logHistory) {
            System.out.println(log);
        }
    }
}
