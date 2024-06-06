package W1.D4;

/**
 *
 * @author clydebalaman
 */
public class SinglyLinkedListDemo {
    public static void main(String[] args) {
        SinglyLinkedList<String> sll = new SinglyLinkedList<>();
        
        // Add elements to the list
        sll.addLast("MSP");
        sll.addFirst("LAX");
        sll.addLast("ATL");
        sll.addLast("BOS");
        
        // Display the elements in the list
        System.out.println("First element: " + sll.first());
        System.out.println("Last element: " + sll.last());
        System.out.println("Size of the list: " + sll.size());
        
        // Remove the first element and display the new first element
        System.out.println("Removing first element: " + sll.removeFirst());
        System.out.println("New first element: " + sll.first());
        System.out.println("New size of the list: " + sll.size());
        
        System.out.println("---");
        System.out.println(sll.display());
    }
}
