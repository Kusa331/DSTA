package W3.D3;

/**
 *
 * @author clydebalaman
 */
public class TowerOfHanoi {
    public static void main(String[] args) {
        int n = 3; // Example: Move 3 disks from A to C
        hanoi(n, 'A', 'C', 'B');        
    }
    
    public static void hanoi(int n, char source, char target, char helper) {
        if (n == 1) {
            System.out.printf("Take disk 1 from tower %c to tower %c\n", source, target);
            return;
        }
        hanoi(n - 1, source, helper, target);
        System.out.printf("Take disk %d from tower %c to tower %c\n", n, source, target);
        hanoi(n - 1, helper, target, source);
    }    
}