package W3.D3;

/**
 *
 * @author clydebalaman
 */
public class Factorial {
    public static void main(String[] args) {
        int num = 5;
        
        System.out.println("An iterative implementation of the factorial function.");
        System.out.printf("%d! is %d\n",num,factorial_iterative(num));
        
        //System.out.println("A recursive implementation of the factorial function.");
        //System.out.printf("%d! is %d\n",num,factorial(num));
    }
    
    public static int factorial_iterative(int n) throws IllegalArgumentException {
        if (n < 0) throw new IllegalArgumentException(); // argument must be nonnegative
        
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        
        return result;
    }    
    
    public static int factorial(int n){
        if (n == 0){
            return 1; // base case
        }
        else{
            return n * factorial(n-1); // recursive case
        }
    }
}

