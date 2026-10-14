package LLD.ObserverDesignPattern;

public class Main {
    public static void main(String[] args) {
        YoutubeChannel yt = new YoutubeChannel();
        Subscriber sub1 = new EmailSubscriber();
        Subscriber sub2 = new BelIiconSubscriber();
        yt.subscribe(sub1);
        yt.subscribe(sub2);
        yt.uploadVideo("This is video for observer design pattern");
    }
    
}
