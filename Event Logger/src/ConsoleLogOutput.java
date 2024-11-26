public class ConsoleLogOutput implements LogOutputStrategy {
    @Override
    public void log(String logMessage) {
        System.out.println(logMessage);
    }
}



