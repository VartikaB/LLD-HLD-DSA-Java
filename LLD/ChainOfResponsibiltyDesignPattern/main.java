package LLD.ChainOfResponsibiltyDesignPattern;

public class main {
    public static void main(String[] args) {
        LogProcessor obj = new Infolog(new DebugLog(new Errorlog(null)));
        obj.log(LogLevel.ERROR,"h1");
    }
    
}
