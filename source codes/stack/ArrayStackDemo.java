package W2.D1;

import java.util.Arrays;

/**
 *
 * @author clydebalaman
 */
public class ArrayStackDemo {
    public static void main(String[] args) {
        Stack<Integer> S = new ArrayStack<>( ); // contents: ()
        
        S.push(5); // contents: (5)
        S.push(3); // contents: (5, 3)
        
        System.out.println(S.size( )); // contents: (5, 3) outputs 2
        System.out.println(S.pop( )); // contents: (5) outputs 3
        System.out.println(S.isEmpty( )); // contents: (5) outputs false
        System.out.println(S.pop( )); // contents: () outputs 5
        System.out.println(S.isEmpty( )); // contents: () outputs true
        System.out.println(S.pop( )); // contents: () outputs null
        
        S.push(7); // contents: (7)
        S.push(9); // contents: (7, 9)
        
        System.out.println(S.top( )); // contents: (7, 9) outputs 9
        
        S.push(4); // contents: (7, 9, 4)
        
        System.out.println(S.size( )); // contents: (7, 9, 4) outputs 3
        System.out.println(S.pop( )); // contents: (7, 9) outputs 4
        
        S.push(6); // contents: (7, 9, 6)
        S.push(8); // contents: (7, 9, 6, 8)
        
        System.out.println(S.pop( )); // contents: (7, 9, 6) outputs 8
        
        System.out.println("------");
        
        Integer[ ] a = {4, 8, 15, 16, 23, 42}; // autoboxing allows this
        String[ ] s = {"Jack", "Kate", "Hurley", "Jin", "Michael"};
        System.out.println("a = " + Arrays.toString(a));
        System.out.println("s = " + Arrays.toString(s));
        System.out.println("Reversing...");
        reverse(a);
        reverse(s);
        System.out.println("a = " + Arrays.toString(a));
        System.out.println("s = " + Arrays.toString(s));
    }
    
    /** A generic method for reversing an array. */
    public static <E> void reverse(E[ ] a) {
        Stack<E> buffer = new ArrayStack<>(a.length);
        for (int i=0; i < a.length; i++)
            buffer.push(a[i]);
        for (int i=0; i < a.length; i++)
            a[i] = buffer.pop( );
    }
}
