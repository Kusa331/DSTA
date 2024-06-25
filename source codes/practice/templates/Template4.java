package Challenges;

import java.util.Scanner;

/**
 *
 * @author clydebalaman
 */
public class Template4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String end = sc.next();
        while(!end.equals("end")){
            // Your solution codes here..
            
            System.out.println(end);
            end = sc.next();
        }
    }
}

/*
Sample input:
abc
def
end

Sample output:
abc
def
*/
