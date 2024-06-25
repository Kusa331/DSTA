package Challenges;

import java.util.Scanner;

/**
 *
 * @author clydebalaman
 */
public class Template3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int T = sc.nextInt();
        while(T-- > 0){
            // Your solution codes here..
            String word = sc.next();
            System.out.println(word);
        }        
    }
}

/*
Sample Input:
3
abc
def
ghi

Sample Output:
abc
def
ghi
 
*/
