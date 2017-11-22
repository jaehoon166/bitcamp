package controll;

import java.util.ArrayList;
import java.util.Scanner;

public abstract class GenericController<T> {
    
    static Scanner keyScan = new Scanner(System.in);
    protected ArrayList<T> list = new ArrayList<>();

    public abstract void excute();
}
