package W3.D3;

/**
 *
 * @author clydebalaman
 */
public class LucasNumber {
    public static void main(String[] args) {
        // Example usage
        int n = 10; // Example input
        System.out.printf("The %dth Lucas number is: %d\n", n, lucas(n));
    }
    
    // Recursive method to compute the nth Lucas number
    public static int lucas(int n) {
        // Base cases
        if (n == 0) {
            return 2; // L(0) = 2
        }
        if (n == 1) {
            return 1; // L(1) = 1
        }
        // Recursive case
        return lucas(n - 1) + lucas(n - 2);
    }   
    
}
