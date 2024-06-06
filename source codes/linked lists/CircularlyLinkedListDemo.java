package W1.D5;

/**
 *
 * @author clydebalaman
 */
public class CircularlyLinkedListDemo {
    public static void main(String[] args) {
        CircularlyLinkedList<String> cll = new CircularlyLinkedList <>();
        
        // Add elements to the list
        cll.addLast("LAX");
        cll.addLast("MSP");
        cll.addLast("ATL");
        cll.addFirst("BOS");
        
        // Display the list
        System.out.println("List: " +  cll.display());
        
        // Show the first and last elements
        System.out.println("First element: " + cll.first());
        System.out.println("Last element: " + cll.last());
        
        // Rotate the list
        cll.rotate();
        System.out.println("After rotation: " + cll.display());
        
        // Add elements to the front of the list
        cll.addFirst("STL");
        System.out.println("After adding STL to the front: " + cll.display());
        
        // Remove first element
        System.out.println("Removed element: " + cll.removeFirst());
        System.out.println("After removing first element: " + cll.display());
        
        // Display the size of the list
        System.out.println("Size of the list: " + cll.size());
    }
}
