import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        
        int lim = s.nextInt();
       
        if (lim >= 1 && lim <= 100) {
            long[] arr = new long[lim + 1];
            for (int i = 1; i <= lim; i++) {
                long num = s.nextInt();
                if (num >= -100 && num <= 100) {
                    arr[i] = num;
                } else {
                    arr[i] = 0;
                }
            }

            String add = s.next();
            int x = s.nextInt();
            int y = s.nextInt();

            try {
                if ((x >= 1) && (y <= lim)) {
                    if(x == y) {
                        System.out.println(arr[x]);
                    } else {
                        System.out.println(arr[x] + arr[y]);
                    }
                    
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                
            }
        }
    }
}
