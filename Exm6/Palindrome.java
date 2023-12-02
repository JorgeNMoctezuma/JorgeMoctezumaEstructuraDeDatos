package Exm6;

public class Palindrome {

    public static void main(String[] args) {
        String x1 = "COCO";
        String x2 = "KAFKA";
        String x3 = "JAVA";

        System.out.println(palindromeCheck(x1));
        System.out.println(palindromeCheck(x2));
        System.out.println(palindromeCheck(x3));
    }
    public static boolean palindromeCheck(String x) {
        int n = x.length();

        for (int i = 0; i < n / 2; i++){
            if (x.charAt(i) != x.charAt(n - i - 1)){
                return false;
            }
        }
        return true;
    }
}
