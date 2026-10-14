package LLD.ObserverDesignPattern;

public class EmailSubscriber implements Subscriber {
    @Override
    public void notify(String message) {
        System.out.println("Email subscriber received message: " + message);
    }
    
}
