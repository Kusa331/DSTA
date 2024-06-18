package W3.D2;

/**
 *
 * @author clydebalaman
 */
public class ArrayListDemo {
    public static void main(String[] args) {
        // Create a new ArrayList
        ArrayList<Character> list = new ArrayList<>();
        
        // Perform the specified sequence of operations
        try {
            list.add(0, 'A'); // add(0, 'A')
            System.out.println("After add(0, 'A'): " + list);

            list.add(0, 'B'); // add(0, 'B')
            System.out.println("After add(0, 'B'): " + list);

            System.out.println("get(1): " + list.get(1)); // get(1)

            /** comment this line to skip error */
            // list.set(2, 'C'); // set(2, 'C')
            // System.out.println("After set(2, 'C'): " + list);

            list.add(2, 'C'); // add(2, 'C')
            System.out.println("After add(2, 'C'): " + list);

            /** comment this line to skip error */
            //list.add(4, 'D'); // add(4, 'D')
            //System.out.println("After add(4, 'D'): " + list);

            list.remove(1); // remove(1)
            System.out.println("After remove(1): " + list);

            list.add(1, 'D'); // add(1, 'D')
            System.out.println("After add(1, 'D'): " + list);

            list.add(1, 'E'); // add(1, 'E')
            System.out.println("After add(1, 'E'): " + list);            
            
            /** comment this line to skip error */
            // System.out.println("get(4): " + list.get(4)); // get(4)

            list.add(4, 'F'); // add(4, 'F')
            System.out.println("After add(4, 'F'): " + list);

            list.set(2, 'G'); // set(2, 'G')
            System.out.println("After set(2, 'G'): " + list);

            System.out.println("get(2): " + list.get(2)); // get(2)
            
        } catch (IndexOutOfBoundsException e) {
            System.err.println("Index out of bounds: " + e.getMessage());
        } catch (IllegalStateException e) {
            System.err.println("Illegal state: " + e.getMessage());
        }

    }
}
