package W3.D5;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/**
 *
 * @author clydebalaman
 */
/** Concrete implementation of a binary tree using a node-based, linked structure. */
import java.util.*;

import java.util.*;

public class LinkedBinaryTree<E> extends AbstractBinaryTree<E> {

    @Override
    public Iterator<E> iterator() {
        return new ElementIterator();
    }

    @Override
    public Iterable<Position<E>> positions() {
        return new Iterable<Position<E>>() {
            @Override
            public Iterator<Position<E>> iterator() {
                return new PositionIterator();
            }
        };
    }

    //---------------- nested Node class ----------------
    protected class Node<E> implements Position<E> {
        private E element; // an element stored at this node
        private Node<E> parent; // a reference to the parent node (if any)
        private Node<E> left; // a reference to the left child (if any)
        private Node<E> right; // a reference to the right child (if any)

        /** Constructs a node with the given element and neighbors. */
        public Node(E e, Node<E> above, Node<E> leftChild, Node<E> rightChild) {
            element = e;
            parent = above;
            left = leftChild;
            right = rightChild;
        }

        // accessor methods
        public E getElement() { return element; }
        public Node<E> getParent() { return parent; }
        public Node<E> getLeft() { return left; }
        public Node<E> getRight() { return right; }

        // update methods
        public void setElement(E e) { element = e; }
        public void setParent(Node<E> parentNode) { parent = parentNode; }
        public void setLeft(Node<E> leftChild) { left = leftChild; }
        public void setRight(Node<E> rightChild) { right = rightChild; }
    } //----------- end of nested Node class -----------

    /** Factory function to create a new node storing element e. */
    protected Node<E> createNode(E e, Node<E> parent, Node<E> left, Node<E> right) {
        return new Node<E>(e, parent, left, right);
    }

    // LinkedBinaryTree instance variables
    protected Node<E> root = null; // root of the tree
    private int size = 0; // number of nodes in the tree

    // constructor
    public LinkedBinaryTree() { } // constructs an empty binary tree

    // nonpublic utility

    /** Validates the position and returns it as a node. */
    protected Node<E> validate(Position<E> p) throws IllegalArgumentException {
        if (!(p instanceof Node))
            throw new IllegalArgumentException("Not valid position type");

        Node<E> node = (Node<E>) p; // safe cast

        if (node.getParent() == node) // our convention for defunct node
            throw new IllegalArgumentException("p is no longer in the tree");
        return node;
    }

    // accessor methods (not already implemented in AbstractBinaryTree)
    /** Returns the number of nodes in the tree. */
    public int size() {
        return size;
    }

    /** Returns the root Position of the tree (or null if tree is empty). */
    public Position<E> root() {
        return root;
    }

    /** Returns the Position of p's parent (or null if p is root). */
    public Position<E> parent(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        return node.getParent();
    }

    /** Returns the Position of p's left child (or null if no child exists). */
    public Position<E> left(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        return node.getLeft();
    }

    /** Returns the Position of p's right child (or null if no child exists). */
    public Position<E> right(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        return node.getRight();
    }

    // update methods supported by this class
    /** Places element e at the root of an empty tree and returns its new Position. */
    public Position<E> addRoot(E e) throws IllegalStateException {
        if (!isEmpty()) throw new IllegalStateException("Tree is not empty");
        root = createNode(e, null, null, null);
        size = 1;
        return root;
    }

    /** Creates a new left child of Position p storing element e; returns its Position. */
    public Position<E> addLeft(Position<E> p, E e) throws IllegalArgumentException {
        Node<E> parent = validate(p);

        if (parent.getLeft() != null)
            throw new IllegalArgumentException("p already has a left child");

        Node<E> child = createNode(e, parent, null, null);
        parent.setLeft(child);
        size++;
        return child;
    }

    /** Creates a new right child of Position p storing element e; returns its Position. */
    public Position<E> addRight(Position<E> p, E e) throws IllegalArgumentException {
        Node<E> parent = validate(p);
        if (parent.getRight() != null)
            throw new IllegalArgumentException("p already has a right child");
        Node<E> child = createNode(e, parent, null, null);
        parent.setRight(child);
        size++;
        return child;
    }

    /** Replaces the element at Position p with e and returns the replaced element. */
    public E set(Position<E> p, E e) throws IllegalArgumentException {
        Node<E> node = validate(p);
        E temp = node.getElement();
        node.setElement(e);
        return temp;
    }

    /** Attaches trees t1 and t2 as left and right subtrees of external p. */
    public void attach(Position<E> p, LinkedBinaryTree<E> t1, LinkedBinaryTree<E> t2) throws IllegalArgumentException {
        Node<E> node = validate(p);
        if (isInternal(p)) throw new IllegalArgumentException("p must be a leaf");
        size += t1.size() + t2.size();
        if (!t1.isEmpty()) { // attach t1 as left subtree of node
            t1.root.setParent(node);

            node.setLeft(t1.root);
            t1.root = null;
            t1.size = 0;
        }

        if (!t2.isEmpty()) { // attach t2 as right subtree of node
            t2.root.setParent(node);
            node.setRight(t2.root);
            t2.root = null;
            t2.size = 0;
        }
    }

    /** Removes the node at Position p and replaces it with its child, if any. */
    public E remove(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        if (numChildren(p) == 2)
            throw new IllegalArgumentException("p has two children");

        Node<E> child = (node.getLeft() != null ? node.getLeft() : node.getRight());
        if (child != null)
            child.setParent(node.getParent()); // child's grandparent becomes its parent
        if (node == root)
            root = child; // child becomes root
        else {
            Node<E> parent = node.getParent();
            if (node == parent.getLeft())
                parent.setLeft(child);
            else
                parent.setRight(child);
        }
        size--;
        E temp = node.getElement();
        node.setElement(null); // help garbage collection
        node.setLeft(null);
        node.setRight(null);
        node.setParent(node); // our convention for defunct node
        return temp;
    }

    // nested ElementIterator class
    private class ElementIterator implements Iterator<E> {
        private Iterator<Position<E>> posIterator = new PositionIterator();

        @Override
        public boolean hasNext() {
            return posIterator.hasNext();
        }

        @Override
        public E next() {
            return posIterator.next().getElement();
        }

        @Override
        public void remove() {
            posIterator.remove();
        }
    }

    // nested PositionIterator class
    private class PositionIterator implements Iterator<Position<E>> {
        private List<Position<E>> positions = new ArrayList<>();
        private int index = 0;

        public PositionIterator() {
            inorderSubtree(root, positions);
        }

        @Override
        public boolean hasNext() {
            return index < positions.size();
        }

        @Override
        public Position<E> next() {
            if (index == positions.size()) throw new NoSuchElementException("No more elements");
            return positions.get(index++);
        }

        private void inorderSubtree(Position<E> p, List<Position<E>> snapshot) {
            if (p == null) return;
            inorderSubtree(left(p), snapshot);
            snapshot.add(p);
            inorderSubtree(right(p), snapshot);
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("Remove not supported");
        }
    }

   /** Adds positions of the subtree rooted at Position p to the given snapshot in inorder. */
    private void inorderSubtree(Position<E> p, List<Position<E>> snapshot) {
        if (left(p) != null) inorderSubtree(left(p), snapshot);
        snapshot.add(p); // add position p after exploring left subtree
        if (right(p) != null) inorderSubtree(right(p), snapshot);
    }

    /** Returns an iterable collection of positions of the tree, reported in inorder. */
    public Iterable<Position<E>> inorder() {
        List<Position<E>> snapshot = new ArrayList<>();
        if (!isEmpty()) {
            inorderSubtree(root(), snapshot); // fill the snapshot recursively
        }
        return snapshot;
    }
    
    
    /** Adds positions of the subtree rooted at Position p to the given snapshot. */
    private void preorderSubtree(Position<E> p, List<Position<E>> snapshot) {
        snapshot.add(p); // for preorder, we add position p before exploring subtrees
        for (Position<E> c : children(p))
            preorderSubtree(c, snapshot);
    }

    /** Adds positions of the subtree rooted at Position p to the given snapshot. */
    private void postorderSubtree(Position<E> p, List<Position<E>> snapshot) {
        for (Position<E> c : children(p))
            postorderSubtree(c, snapshot);
        snapshot.add(p); // for postorder, we add position p after exploring subtrees
    }

    /** Returns an iterable collection of positions of the tree, reported in preorder. */
    public Iterable<Position<E>> preorder() {
        List<Position<E>> snapshot = new ArrayList<>();
        if (!isEmpty())
            preorderSubtree(root(), snapshot); // fill the snapshot recursively
        return snapshot;
    }

    /** Returns an iterable collection of positions of the tree, reported in postorder. */
    public Iterable<Position<E>> postorder() {
        List<Position<E>> snapshot = new ArrayList<>();
        if (!isEmpty())
            postorderSubtree(root(), snapshot); // fill the snapshot recursively
        return snapshot;
    }

    /** Returns an iterable collection of positions of the tree in breadth-first order. */
    public Iterable<Position<E>> breadthfirst() {
        List<Position<E>> snapshot = new ArrayList<>();
        if (!isEmpty()) {
            Queue<Position<E>> fringe = new LinkedQueue<>();
            fringe.enqueue(root());
            while (!fringe.isEmpty()) {
                Position<E> p = fringe.dequeue(); // remove from front of the queue
                snapshot.add(p); // report this position
                for (Position<E> c : children(p))
                    fringe.enqueue(c); // add children to back of queue
            }
        }
        return snapshot;
    }

    /** Returns the height of the tree rooted at Position p. */
    public int height(Position<E> p) {
        int h = 0; // base case if p is external
        for (Position<E> c : children(p))
            h = Math.max(h, 1 + height(c));
        return h;
    }

    /** Returns a list of Positions representing the path from the root to Position p. */
    public List<Position<E>> pathFromRoot(Position<E> p) {
        List<Position<E>> path = new ArrayList<>();
        while (p != null) {
            path.add(p);
            p = parent(p);
        }
        Collections.reverse(path); // reverse the path to start from the root
        return path;
    }

    /** Returns a list of Positions representing the descendants of Position p. */
    public List<Position<E>> rootDescendants(Position<E> p) {
        List<Position<E>> descendants = new ArrayList<>();
        if (p != null) {
            for (Position<E> c : children(p)) {
                descendants.add(c);
                descendants.addAll(rootDescendants(c));
            }
        }
        return descendants;
    }

    /** Returns the level of Position p in the tree. */
    public int level(Position<E> p) {
        int level = 0;
        while (p != root()) {
            p = parent(p);
            level++;
        }
        return level;
    }

    /** Returns an iterable collection of positions of the tree in Euler tour order. */
    public Iterable<Position<E>> eulerTour(boolean dup) {
        List<Position<E>> snapshot = new ArrayList<>();
        if(dup && !isEmpty( )){
            eulerTourSubtree(root(), snapshot);
        }
        else{
            eulerTourSubtree(root( ), snapshot, new HashSet<>()); // fill the snapshot recursively 
        }
        return snapshot;
    }

    /** Adds positions of the subtree rooted at Position p to the given snapshot in Euler tour order. */
    private void eulerTourSubtree(Position<E> p, List<Position<E>> snapshot) {
        if (p != null) {
            snapshot.add(p);
            if (left(p) != null) eulerTourSubtree(left(p), snapshot);
            snapshot.add(p);
            if (right(p) != null) eulerTourSubtree(right(p), snapshot);
            snapshot.add(p);
        }
    }

    /** Adds positions of the subtree rooted at Position p to the given snapshot. */
    private void eulerTourSubtree(Position<E> p, List<Position<E>> snapshot, Set<Position<E>> visited) {
        if (p == null || visited.contains(p)) return;
        snapshot.add(p); // add before left
        visited.add(p);
        if (left(p) != null) eulerTourSubtree(left(p), snapshot, visited);
        if (right(p) != null) eulerTourSubtree(right(p), snapshot, visited);
    }    

    /** Returns an iterable collection of positions of the right subtree of the root in postorder. */
    public Iterable<Position<E>> postorderOnRightSubtree() {
        List<Position<E>> snapshot = new ArrayList<>();
        if (!isEmpty() && right(root()) != null)
            postorderSubtree(right(root()), snapshot);
        return snapshot;
    }

    // Method to find a node by element
    public Position<E> findNode(E e) {
        for (Position<E> pos : positions()) {
            if (pos.getElement().equals(e)) {
                return pos;
            }
        }
        return null;
    }
}
