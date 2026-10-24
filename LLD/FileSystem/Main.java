package LLD.FileSystem;

public class Main {
    public static void main(String[] args) {
        Directory fs = new Directory("Movie");
        fs.add(new File("Bhool Bhulaiya"));
        fs.ls();
    }
    
}
