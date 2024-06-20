package W3.D4;

/**
 *
 * @author clydebalaman
 */
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class GenericTree<E> implements Tree<E> {

    // Nested Position class implementation
    public static class TreeNode<E> implements Position<E> {
        private E element;
        private TreeNode<E> parent;
        private List<TreeNode<E>> children;

        public TreeNode(E e, TreeNode<E> above, List<TreeNode<E>> below) {
            element = e;
            parent = above;
            children = below;
        }

        @Override
        public E getElement() throws IllegalStateException {
            return element;
        }

        public TreeNode<E> getParent() {
            return parent;
        }

        public List<TreeNode<E>> getChildren() {
            return children;
        }

        public void setParent(TreeNode<E> parent) {
            this.parent = parent;
        }

        public void setChildren(List<TreeNode<E>> children) {
            this.children = children;
        }

        public void setElement(E element) {
            this.element = element;
        }
    }

    private TreeNode<E> root = null;
    private int size = 0;

    public GenericTree() {
    }

    @Override
    public Position<E> root() {
        return root;
    }

    @Override
    public Position<E> parent(Position<E> p) throws IllegalArgumentException {
        TreeNode<E> node = validate(p);
        return node.getParent();
    }

    @Override
    public Iterable<Position<E>> children(Position<E> p) throws IllegalArgumentException {
        TreeNode<E> node = validate(p);
        List<Position<E>> children = new ArrayList<>();
        for (TreeNode<E> child : node.getChildren()) {
            children.add(child);
        }
        return children;
    }

    @Override
    public int numChildren(Position<E> p) throws IllegalArgumentException {
        TreeNode<E> node = validate(p);
        return node.getChildren().size();
    }

    @Override
    public boolean isInternal(Position<E> p) throws IllegalArgumentException {
        return numChildren(p) > 0;
    }

    @Override
    public boolean isExternal(Position<E> p) throws IllegalArgumentException {
        return numChildren(p) == 0;
    }

    @Override
    public boolean isRoot(Position<E> p) throws IllegalArgumentException {
        return p == root;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public Iterator<E> iterator() {
        return new ElementIterator();
    }

    @Override
    public Iterable<Position<E>> positions() {
        return new PositionIterable();
    }

    // Helper methods
    private TreeNode<E> validate(Position<E> p) throws IllegalArgumentException {
        if (!(p instanceof TreeNode)) throw new IllegalArgumentException("Not valid position type");
        TreeNode<E> node = (TreeNode<E>) p; // safe cast
        return node;
    }

    // Nested PositionIterable class
    private class PositionIterable implements Iterable<Position<E>> {
        @Override
        public Iterator<Position<E>> iterator() {
            return new PositionIterator();
        }
    }

    // Nested PositionIterator class
    private class PositionIterator implements Iterator<Position<E>> {
        private Iterator<TreeNode<E>> nodeIterator = new NodeIterator();

        @Override
        public boolean hasNext() {
            return nodeIterator.hasNext();
        }

        @Override
        public Position<E> next() {
            return nodeIterator.next();
        }
    }

    // Nested NodeIterator class
    private class NodeIterator implements Iterator<TreeNode<E>> {
        private List<TreeNode<E>> snapshot = new ArrayList<>();
        private int index = 0;

        public NodeIterator() {
            if (root != null) {
                preorderSubtree(root, snapshot);
            }
        }

        private void preorderSubtree(TreeNode<E> node, List<TreeNode<E>> snapshot) {
            snapshot.add(node);
            for (TreeNode<E> child : node.getChildren()) {
                preorderSubtree(child, snapshot);
            }
        }

        @Override
        public boolean hasNext() {
            return index < snapshot.size();
        }

        @Override
        public TreeNode<E> next() {
            if (index == snapshot.size()) throw new NoSuchElementException("No more elements");
            return snapshot.get(index++);
        }
    }

    // Nested ElementIterator class
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
    }
    
    public void setRoot(TreeNode<E> root) {
        this.root = root;
        size = 1;
        if (root != null) {
            size += root.getChildren().size();
        }
    }
}
