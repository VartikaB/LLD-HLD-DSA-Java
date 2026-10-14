package LLD.ObserverDesignPattern;

public class BelIiconSubscriber implements Subscriber {
    @Override
    public void notify(String message) {
        System.out.println("BelIicon subscriber received message: " + message);
    }
    
}
