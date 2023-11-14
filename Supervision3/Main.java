public class Main {
public static void main(String[] args) {
    String s1 = new String("Hi");
    String s2 = new String("Hi");
    System.out.println( (s1==s2) );
    System.out.println((s1.equals(s2)));
    String s3 = "Hello";
    String s4 = "Hi";
    System.out.println( (s3==s4) );
    System.out.println((s2 == s4));
}
}
