package LLD.FileSystem;

import java.util.ArrayList;
import java.util.List;

public class Directory implements FileSystem {
    List<FileSystem> ls = new ArrayList<>();
    String directoryName;

    public Directory(String name) {
        this.directoryName=name;
    }
    
    public void add(FileSystem fs){
        ls.add(fs);
    }
    public void ls(){
        System.out.println("Directory name"+directoryName);
        for(FileSystem i : ls){
            i.ls();
        }
    }
    
    
}
