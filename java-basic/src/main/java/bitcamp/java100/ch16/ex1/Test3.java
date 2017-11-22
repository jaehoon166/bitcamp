package bitcamp.java100.ch16.ex1;

class Test3 {

    static class MyRunnable implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 10000; i++) {
                System.out.println("MyThread=> " + i);
            }
        }
    }

    public static void main(String[] args) {
        Thread t = new Thread(new MyRunnable());

        t.start();

        for (int i = 0; i < 10000; i++) {
            System.out.println(i);
        }

    }

}
