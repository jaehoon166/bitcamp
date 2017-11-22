package bitcamp.java100.ch14.ex1;

import java.io.File;
import java.io.FilenameFilter;

public class MyFilenameFilter2 implements FilenameFilter{

    @Override
    public boolean accept(File dir, String name) {
        try {
            System.out.print(dir.getCanonicalPath() + ",");
            System.out.println(name);
        } catch (Exception e) {
            
        }
        return true;
    }

}
