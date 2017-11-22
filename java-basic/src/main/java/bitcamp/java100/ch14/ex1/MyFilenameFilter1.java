package bitcamp.java100.ch14.ex1;

import java.io.File;
import java.io.FilenameFilter;

public class MyFilenameFilter1 implements FilenameFilter{

    @Override
    public boolean accept(File dir, String name) {
        return true;
    }

}
