package bitcamp.java100;

public class Test18_6 {

    public static void main(String[] args) {
        String email = "1yun@test.com";
        
        System.out.println(email.matches("1yun@test.com"));
        
        System.out.println(email.matches(".+@.+\\..+"));
        
        System.out.println(email.matches("^\\D.+@.+\\..+"));
        
        String str = "홍길동(hong@test.com),임꺽정(leem@test.com),유관순(yu@test.com),안중근(ahn@test.com),윤봉길(yun@test.com)";
        
        java.util.regex.Pattern pattern = java.util.regex.Pattern.compile("\\w+@\\w+.\\w+");
        
        java.util.regex.Matcher matcher = pattern.matcher(str);
        
        int startIndex = 0;
        while(matcher.find(startIndex)) {
            String matchString = matcher.group();
            startIndex = matcher.start() + matchString.length();
            System.out.println(matchString);
        }
    }
}