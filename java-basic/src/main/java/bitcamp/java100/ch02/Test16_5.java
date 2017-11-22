package bitcamp.java100.ch02;

public class Test16_5 {

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            System.out.println(i);
        }

        System.out.println("--------------------------------------");

        for (int i = 0, j = 0; i < 5; i++, j += 2) {
            System.out.printf("%d, %d\n", i, j);
        }

        System.out.println("--------------------------------------");

        int sum = 0;
        for (int i = 0; i <= 10; i++) {
            sum += i;
            System.out.println(sum);
        }

        System.out.println("--------------------------------------");

        for (int i = 0; i <= 18; i++) {
            System.out.print("=> ");
            System.out.println(i);
        }

        System.out.println("--------------------------------------");

        for (int i = 0; i <= 18; i++) {
            if (i == 5)
                break;
            System.out.print("=> ");
            System.out.println(i);
        }

        System.out.println("--------------------------------------");

        for (int i = 0; i <= 18; i++) {
            if (i == 5)
                continue;
            System.out.println(i);
        }

        System.out.println("--------------------------------------");

        int i = 0;
        for (; i < 5; i++) {
            System.out.println(i);
        }

        System.out.println("--------------------------------------");

        i = 0;
        for (; i < 5;) {
            System.out.println(i);
            i++;
        }

        System.out.println("--------------------------------------");

        i = 0;
        for (;;) {
            if (i == 5)
                break;
            System.out.println(i);
            i++;
        }

        System.out.println("--------------------------------------");

        String[] names = { "홍길동", "임꺽정", "유관순", "안중근", "윤봉길" };
        for (int index = 0; index < names.length; index++) {
            System.out.println(names[index]);
        }

        System.out.println("--------------------------------------");

        label1: for (int a = 1; a <= 5; a++) {
            for (int b = 0; b < a; b++) {
                System.out.print("*");
                if (b == 2)
                    break label1;
            }
            System.out.println();
        }
        System.out.println();

        System.out.println("--------------------------------------");

        for (int a = 1; a < 9; a++) {
            for (int b = 1; b < 10; b++) {
                System.out.printf("%d * %d = %d\n", a + 1, b, (a + 1) * b);
            }
        }
        
        System.out.println("--------------------------------------");
        
        int num = 98761234;
        for(i = 0;i<8;i++) {
            System.out.printf("%d ",num % 10);
            num/=10;
        }
        
        System.out.println("--------------------------------------");
        
        
    }
}