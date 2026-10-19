package LLD.ChainOfResponsibiltyDesignPattern;

public class Errorlog extends LogProcessor {
    public Errorlog(LogProcessor nextLogProcessor) {
        super(nextLogProcessor);
    }
    public void log(LogLevel logLevel , String message){
        if(logLevel.equals(LogLevel.ERROR)){
            System.out.println("This is error log");
        }
        else {
            super.log(logLevel, message);
        }
    }
    
}
