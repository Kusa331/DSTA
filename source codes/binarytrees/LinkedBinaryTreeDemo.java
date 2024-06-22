package W3.D5;

/**
 *
 * @author clydebalaman
 */
public class LinkedBinaryTreeDemo {

    public static void main(String[] args) {
        // Create an empty LinkedBinaryTree
        LinkedBinaryTree<String> tree = new LinkedBinaryTree<>();

        // Add the root node
        Position<String> root = tree.addRoot("a");

        // Add left and right children to the root
        Position<String> leftChild = tree.addLeft(root, "b");
        Position<String> rightChild = tree.addRight(root, "c");

        // Add children to the left child
        Position<String> leftLeftChild = tree.addLeft(tree.findNode("b"), "d");
        Position<String> leftRightChild = tree.addRight(tree.findNode("b"), "e");

        // Add children to the right child
        Position<String> rightLeftChild = tree.addLeft(tree.findNode("c"), "f");
        Position<String> rightRightChild = tree.addRight(tree.findNode("c"), "g");

        // Display root
        System.out.println("Root: " + tree.root().getElement());

        // Display internal nodes
        System.out.print("Internal Nodes: ");
        for (Position<String> p : tree.positions()) {
            if (tree.isInternal(p)) {
                System.out.print(p.getElement() + " ");
            }
        }
        System.out.println();

        // Display external nodes
        System.out.print("External Nodes: ");
        for (Position<String> p : tree.positions()) {
            if (tree.isExternal(p)) {
                System.out.print(p.getElement() + " ");
            }
        }
        System.out.println();

        // Display number of nodes
        System.out.println("Number of Nodes: " + tree.size());

        // Display path from root to node 'e'
        System.out.print("Path from Root node to 'e': ");
        for (Position<String> p : tree.pathFromRoot(leftRightChild)) {
            System.out.print(p.getElement() + " ");
        }
        System.out.println();

        // Display descendants of node 'e'
        System.out.print("Descendants of node 'e': ");
        for (Position<String> p : tree.children(leftRightChild)) {
            System.out.print(p.getElement() + " ");
        }
        System.out.println();

        // Display root height
        System.out.println("Root Height: " + tree.height(root));

        // Display traversals
        System.out.print("Inorder Traversal: ");
        for (Position<String> p : tree.positions()) {
            System.out.print(p.getElement() + " ");
        }
        System.out.println();

        System.out.print("Preorder Traversal: ");
        for (Position<String> p : tree.preorder()) {
            System.out.print(p.getElement() + " ");
        }
        System.out.println();

        // Display parent of node 'e'
        System.out.println("Parent of node 'e': " + tree.parent(leftRightChild).getElement());

        System.out.print("Postorder Traversal: ");
        for (Position<String> p : tree.postorder()) {
            System.out.print(p.getElement() + " ");
        }
        System.out.println();

        System.out.print("Breadth-first Traversal: ");
        for (Position<String> p : tree.breadthfirst()) {
            System.out.print(p.getElement() + " ");
        }
        System.out.println();

        // Display level of node 'e'
        System.out.println("Level of node 'e': " + tree.pathFromRoot(leftRightChild).size());

        System.out.print("Euler Tour Traversal: ");
        for (Position<String> p : tree.eulerTour(true)) {
            System.out.print(p.getElement() + " ");
        }
        System.out.println();        

        System.out.print("Postorder Traversal on Root’s Right Subtree: ");
        for (Position<String> p : tree.postorderOnRightSubtree()) {
            System.out.print(p.getElement() + " ");
        }
        System.out.println();
    }
}

/*
Root: a
Internal Nodes: b a c 
External Nodes: d e f g 
Number of Nodes: 7
Path from Root node to 'e': a b e 
Descendants of node 'e': 
Root Height: 2
Inorder Traversal: d b e a f c g 
Preorder Traversal: a b d e c f g 
Parent of node 'e': b
Postorder Traversal: d e b f g c a 
Breadth-first Traversal: a b c d e f g 
Level of node 'e': 3
Euler Tour Traversal: a b d d d b e e e b a c f f f c g g g c a 
Postorder Traversal on Root’s Right Subtree: f g c 
*/
