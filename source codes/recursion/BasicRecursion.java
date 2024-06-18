package W3.D3;

/**
 *
 * @author clydebalaman
 */
public class BasicRecursion {
    public static void main(String[] args) {
        //code to implement basic recursion functions here
    }
    
    public static int sumOfDigits(int n) {
        if (n == 0) {
            return 0;
        }
        return n % 10 + sumOfDigits(n / 10);
    }
        
    public static String reverseString(String str) {
        if (str.isEmpty()) {
            return str;
        }
        return reverseString(str.substring(1)) + str.charAt(0);
    }
        
    public static int power(int a, int b) {
        if (b == 0) {
            return 1;
        }
        return a * power(a, b - 1);
    }    
}
