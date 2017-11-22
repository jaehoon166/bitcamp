package bitcamp.java100.ch11.ex4;

public class Test1 {

    public static void main(String[] args) {
        //Car car = new Car();
        
        Sedan car1 = new Sedan();
        car1.run();
        car1.stop();
        
        Truck car2 = new Truck();
        car2.move();
        car2.stop();
    }

}
