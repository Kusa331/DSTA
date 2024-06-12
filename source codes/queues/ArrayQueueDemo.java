package W2.D4;

/**
 *
 * @author clydebalaman
 */
public class ArrayQueueDemo {
    public static void main(String[] args) {
        // Create a queue with default capacity
        ArrayQueue<Integer> queue = new ArrayQueue<>();

        System.out.println("Method\t\t| Return Value\t| first <- Q <- last");
        
        // Enqueue 5
        queue.enqueue(5);
        System.out.println("enqueue(5)\t| – \t\t|" + queue.queueContents(queue));

        // Enqueue 3
        queue.enqueue(3);
        System.out.println("enqueue(3)\t| – \t\t|" + queue.queueContents(queue));

        // Size of the queue
        System.out.println("size()\t\t| " + queue.size() + " \t\t|" + queue.queueContents(queue));

        // Dequeue
        System.out.println("dequeue()\t| " + queue.dequeue() + " \t\t|" + queue.queueContents(queue));

        // Check if the queue is empty
        System.out.println("isEmpty()\t| " + queue.isEmpty() + " \t|" + queue.queueContents(queue));

        // Dequeue
        System.out.println("dequeue()\t| " + queue.dequeue() + " \t\t|" + queue.queueContents(queue));

        // Check if the queue is empty
        System.out.println("isEmpty()\t| " + queue.isEmpty() + " \t\t|" + queue.queueContents(queue));

        // Dequeue from empty queue
        System.out.println("dequeue()\t| " + queue.dequeue() + " \t\t|" + queue.queueContents(queue));

        // Enqueue 7
        queue.enqueue(7);
        System.out.println("enqueue(7)\t| – \t\t|" + queue.queueContents(queue));

        // Enqueue 9
        queue.enqueue(9);
        System.out.println("enqueue(9)\t| – \t\t|" + queue.queueContents(queue));

        // First element
        System.out.println("first() \t| " + queue.first() + " \t\t| " + queue.queueContents(queue));

        // Enqueue 4
        queue.enqueue(4);
        System.out.println("enqueue(4)\t| – \t\t|" + queue.queueContents(queue));
    }

}

