package LLD.ChainOfResponsibiltyDesignPattern;

public class DebugLog extends LogProcessor {
    public DebugLog(LogProcessor nextLogProcessor) {
        super(nextLogProcessor);
    }
    public void log(LogLevel logLevel , String message){
        if(logLevel.equals(LogLevel.DEBUG)){
            System.out.println("This is debug log");
        }
        else {
            super.log(logLevel, message);
        }
    }
    
}
