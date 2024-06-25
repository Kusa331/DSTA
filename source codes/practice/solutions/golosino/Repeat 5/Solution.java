import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int num = s.nextInt();
        String word = s.next();

        if (1 <= num && num <= 100) {
            for (int i = 0; i < num; i++) {
                System.out.println(word);
            }
        }
    }
}
