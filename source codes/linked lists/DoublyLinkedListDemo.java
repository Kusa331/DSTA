package W1.D5;

/**
 *
 * @author clydebalaman
 */
public class DoublyLinkedListDemo {
    public static void main(String[] args) {
        DoublyLinkedList<String> dll = new DoublyLinkedList<>();
        
        // Add elements to the list
        dll.addLast("BWI");
        dll.addLast("JFK");
        dll.addLast("SFO");

        // Display the list
        System.out.println("List: " + dll.display());

        // Show the first and last elements
        System.out.println("First element: " + dll.first());
        System.out.println("Last element: " + dll.last());

        // Add elements in between JFK and SFO
        DoublyLinkedList.Node<String> firstNode = dll.getHeader().getNext().getNext();
        DoublyLinkedList.Node<String> secondNode = firstNode.getNext();
        
        dll.addBetween("PVD", firstNode, secondNode);
        System.out.println("After adding PVD in between " + firstNode.getElement() + " and " + secondNode.getElement() + " : " + dll.display());

        // Adds element LAX to the front of the list.
        dll.addFirst("LAX");
        System.out.println("After adding the element to the front: " + dll.display());
        
        // Remove the first element
        System.out.println("Removed element: " + dll.removeFirst());
        System.out.println("After removing the first element: " + dll.display());


        // Remove the last element
        System.out.println("Removed element: " + dll.removeLast());
        System.out.println("After removing the last element: " + dll.display());

        // Display the size of the list
        System.out.println("Size of the list: " + dll.size());        
    }
}
