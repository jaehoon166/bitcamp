package bitcamp.java100;

public class Test16_4 {

    public static void main(String[] args) {

        int i = 0;
        while (i < 5) {
            System.out.println(i++);
        }

        i = 0;
        while (i < 5) {
            System.out.print("=> ");
            System.out.println(i);
            i++;
        }

        i = 1;
        while (i <= 5) {
            int count = 5 - i;
            while (count > 0) {
                System.out.print(" ");
                count--;
            }
            count = 1;
            while (count <= i) {
                System.out.print("*");
                count++;
            }
            System.out.println();
            i++;
        }

        // *
        // ***
        // *****

        i = 1;
        while (i <= 5) {
            int count = (5 - i) / 2;
            while (count > 0) {
                System.out.print(" ");
                count--;
            }
            count = 1;
            while (count <= i) {
                System.out.print("*");
                count++;
            }
            System.out.println();
            i += 2;
        }

        i = 0;
        while (i < 5) {
            if (i == 3) {
                i++;
                continue;
            }
            System.out.println(i);
            i++;
        }

        i = 1;
        label1: {
            while (i <= 10) {
                int count = 1;
                while (count <= i) {
                    System.out.print("*");
                    if (count == 5) {
                        break label1;
                    }
                    count++;
                }
                System.out.println();
                i++;
            }
        }

        i = 1;
        label1: while (i <= 10) {
            int count = 1;
            while (count <= i) {
                System.out.print("*");
                if (count == 5) {
                    break label1;
                }
                count++;
            }
            System.out.println();
            i++;
        }

        i = 2;
        while (i <= 9) {
            int count = 1;
            while (count <= 9) {
                int a = count * i;
                System.out.printf("%d * %d = %d\n", i, count, a);
                count++;
            }
            i++;
        }

        i = 987654321;
        while (i > 0) {
            System.out.printf("%d ", i % 10);
            i /= 10;
        }
        System.out.printf("\n");
        ////////////////////////////////////////////////////////
        i = 987654321;
        int a = 0;
        int count = 0;
        int val[] = new int[10];
        while (i > 0) {
            int c = i % 10;
            val[a] = c;
            i /= 10;
            a++;
        }
        ////////////////////////////////////////////////////////
        i = 987654321;

        int cnt[] = new int[10];

        while (i > 0) {
            cnt[i % 10]++;
            i /= 10;
        }
        int x = 0;
        while (x < cnt.length) {
            System.out.printf("%d = %d\n", x, cnt[x]);
            x++;
        }
        ///////////////////////////////////////////////////////
        i = 0;
        do {
            System.out.print("=> ");
            System.out.println(i);
            i++;
        }while(i < 5);
    }
}