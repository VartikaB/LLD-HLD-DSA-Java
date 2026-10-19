package LLD.ChainOfResponsibiltyDesignPattern;

public class Infolog extends LogProcessor {

    public Infolog(LogProcessor nextLogProcessor) {
        super(nextLogProcessor);
    }
    public void log(LogLevel logLevel , String message){
        if(logLevel.equals(LogLevel.INFO)){
            System.out.println("This is info log");
        }
        else {
            super.log(logLevel, message);
        }
    }
    
    
}
