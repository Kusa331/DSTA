package W2.D1;

import W1.D3.ArrayOps;
import W1.D4.SinglyLinkedList;
import W1.D5.DoublyLinkedList;

import java.util.Scanner;

/**
 * Program: Week 1 Challenge
 * @author clydebalaman
 */
public class BasicOpsDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int T = sc.nextInt();
        String L = sc.next();
        
        if (L.equals("ARR")) doARR(T);
        else if (L.equals("SLL")) doSLL(T);
        else if (L.equals("DLL")) doDLL(T);
    }
    
    public static void doARR(int T){
        ArrayOps<String> arr = new ArrayOps <>(10);
        Scanner sc = new Scanner(System.in);
        
        while(T-->0){
            int cmd = sc.nextInt();
            
            switch(cmd){
                case 1: {
                    // addFirst
                    String element = sc.next();
                    arr.addFirst(element);
                    break;
                }
                case 2: {
                    // addLast
                    String element = sc.next();
                    arr.addLast(element);
                    break;
                }
                case 3: {
                    // removeFirst
                    arr.removeFirst();
                    break;
                }
                case 4: {
                    // removeLast
                    arr.removeLast();
                    break;
                }
            }
        }
        
        System.out.println("ARR: " + arr.display());
    }
    
    public static void doSLL(int T){
        SinglyLinkedList<String> sll = new SinglyLinkedList<>();
        Scanner sc = new Scanner(System.in);
        
        while(T-->0){
            int cmd = sc.nextInt();
            
            switch(cmd){
                case 1: {
                    // addFirst
                    String element = sc.next();
                    sll.addFirst(element);
                    break;
                }
                case 2: {
                    // addLast
                    String element = sc.next();
                    sll.addLast(element);
                    break;
                }
                case 3: {
                    // removeFirst
                    sll.removeFirst();
                    break;
                }
                case 4: {
                    // removeLast
                    sll.removeLast();
                    break;
                }
            }
        }
        
        System.out.println("SLL: " + sll.display());        
               
    }
    
    public static void doDLL(int T){
        DoublyLinkedList<String> dll = new DoublyLinkedList<>();
        Scanner sc = new Scanner(System.in);
        
        while(T-->0){
            int cmd = sc.nextInt();
            
            switch(cmd){
                case 1: {
                    // addFirst
                    String element = sc.next();
                    dll.addFirst(element);
                    break;
                }
                case 2: {
                    // addLast
                    String element = sc.next();
                    dll.addLast(element);
                    break;
                }
                case 3: {
                    // removeFirst
                    dll.removeFirst();
                    break;
                }
                case 4: {
                    // removeLast
                    dll.removeLast();
                    break;
                }
            }
        }
        
        System.out.println("DLL: " + dll.display());         
    }
}

/*
TC1

7 ARR
1 A
2 B
2 C
2 D
2 E
3
4

7 SLL
1 A
2 B
2 C
2 D
2 E
3
4

7 DLL
1 A
2 B
2 C
2 D
2 E
3
4


*/
