package Challenges;

import java.util.Scanner;

/**
 *
 * @author clydebalaman
 */
public class Template2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int value = sc.nextInt();
        while(value != -1){
            // Your solution codes here..
            System.out.println(value);
            value = sc.nextInt();
        }        
    }
}
/*
Sample input:
10
20
30
-1

Sample output:
10
20
30
*/ 
