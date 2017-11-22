
public class Test {
    public static void main(String[] args) {
        String[] path = "/score/add?name=aaa&kor=100&eng=100".split("\\?");
        
        String[] arr = path[1].split("&");
        
        for(String s : arr) {
            String[] kv = param.split("&");
            System.out.println(s);
        }
        
    }
}
