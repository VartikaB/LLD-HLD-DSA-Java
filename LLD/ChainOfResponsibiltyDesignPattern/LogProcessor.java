package LLD.ChainOfResponsibiltyDesignPattern;

public abstract class LogProcessor {
    public LogLevel loglevel;
    LogProcessor nextLogProcessor;

    public LogProcessor(LogProcessor nextLogProcessor) {
        this.nextLogProcessor = nextLogProcessor;
    }
    public void log(LogLevel logLevel , String message){
        if(nextLogProcessor!=null){
            nextLogProcessor.log(logLevel, message);
        }
    }
    
}
