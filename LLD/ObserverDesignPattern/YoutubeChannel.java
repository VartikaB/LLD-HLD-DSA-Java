package LLD.ObserverDesignPattern;

import java.util.ArrayList;
import java.util.List;

public class YoutubeChannel {
    List<Subscriber> subscribers = new ArrayList<>();
    public void subscribe(Subscriber subscriber) {
        subscribers.add(subscriber);
    }
    public void unsubscribe(Subscriber subscriber) {
        subscribers.remove(subscriber); 
    }
    public void uploadVideo(String videoTitle) {
        System.out.println("New video uploaded: " + videoTitle);
        notifySubscribers(videoTitle);
    }
    private void notifySubscribers(String videoTitle) {
        for (Subscriber subscriber : subscribers) {
            subscriber.notify(videoTitle);
        }
    }
}
