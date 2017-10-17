package bitcamp.java100;

public class Test18_5 {

    public static void main(String[] args) throws Exception{
        String s1 = "ABC가각간";

        String s2 = s1.replace("BC", "하하하");

        System.out.println(s1);
        System.out.println(s2);

        System.out.println(s1.charAt(4));

        System.out.println(s1.indexOf("가각"));

        s1 = "ABBCDEBBFGH";

        System.out.println(s1.lastIndexOf("BB"));

        System.out.println(s1.substring(3));

        System.out.println(s1.substring(3, 6));

        s1 = "홍길동";

        System.out.println(s1.startsWith("홍길"));
        System.out.println(s1.startsWith("길"));

        System.out.println(s1.endsWith("동"));
        System.out.println(s1.endsWith("길"));

        s2 = "홍길동, 유관순, 임꺽정, 안중근, 윤봉길, 이육사, 윤동주";

        System.out.println(s1.contains("꺽정"));
        System.out.println(s1.contains("김꺽정"));

        String s3 = "ABC";
        String s4 = "기긱간";

        System.out.println(s3.contains(s4));

        System.out.println(s3);
        System.out.println(s4);

        s3 = new String("탕수육");
        s4 = new String("탕수육2");

        String s5 = new String("탈수육");
        String s6 = new String("탕수육");

        System.out.println(s3.compareTo(s6));
        System.out.println(s3.compareTo(s4));
        System.out.println(s3.compareTo(s5));

        s1 = "홍길동";
        s2 = "";
        s3 = null;

        System.out.println(s1.isEmpty());
        System.out.println(s2.isEmpty());
        // System.out.println(s3.isEmpty());

        System.out.println(s1.length());
        System.out.println(s2.length());
        // System.out.println(s3.length());

        s1 = "홍길동,유관순,임꺽정,안중근,윤봉길,이육사,윤동주";
        String arr[] = s1.split(",");
        for (String s : arr) {
            System.out.print(s);
            System.out.print("-");
        }
        System.err.println();

        arr = s1.split(" ");
        System.out.println(arr.length);
        System.out.println(arr[0]);

        s1 = "";
        arr = s1.split(",");
        System.out.println(arr.length);
        System.out.println(arr[0]);

        s1 = "Jae Hun";
        System.out.println(s1.toLowerCase());
        System.out.println(s1.toUpperCase());

        s1 = "  \t홍 \t길 동 ";
        System.out.println(s1.trim());
        
        s1 = "ABC\n가각간\n똘똠똥";
        
        byte bytes[] = s1.getBytes("UTF-8");
        for(byte b : bytes) {
            System.out.print(Integer.toHexString(b & 0x00ff));
            System.out.print(" ");
        }
        System.out.println();
        
        s1 = "ABC";
        s2 = "가각간";
        s3 = s1 + s2;
        
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
    }
}