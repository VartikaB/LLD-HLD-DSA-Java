package LLD.FileSystem;

public class File implements FileSystem {
    String filename;
    File(String filename){
        this.filename=filename;
    }
    public void ls(){
        System.out.println("File name is: "+filename);
    }
    
}
