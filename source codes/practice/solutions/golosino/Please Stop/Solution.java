import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        
        while (num != -1) {
            if(num % 2 != 0 && (-1 <= num && num <= 100)) {
                System.out.println(num); 
            }
            
            num = scan.nextInt();
        }
    }
}
