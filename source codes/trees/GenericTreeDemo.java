package W3.D4;

/**
 *
 * @author clydebalaman
 */
import java.util.ArrayList;
import java.util.List;

public class GenericTreeDemo {
    public static void main(String[] args) {
        GenericTree<String> tree = new GenericTree<>();

        // Creating root
        GenericTree.TreeNode<String> root = new GenericTree.TreeNode<>("Electronics R'Us", null, new ArrayList<>());
        tree.setRoot(root);

        // Adding children to root
        GenericTree.TreeNode<String> child1 = new GenericTree.TreeNode<>("R&D", root, new ArrayList<>());
        GenericTree.TreeNode<String> child2 = new GenericTree.TreeNode<>("Sales", root, new ArrayList<>());
        GenericTree.TreeNode<String> child3 = new GenericTree.TreeNode<>("Purchasing", root, new ArrayList<>());
        GenericTree.TreeNode<String> child4 = new GenericTree.TreeNode<>("Manufacturing", root, new ArrayList<>());

        root.getChildren().add(child1);
        root.getChildren().add(child2);
        root.getChildren().add(child3);
        root.getChildren().add(child4);
        
        // Adding children to Sales
        GenericTree.TreeNode<String> child2_1 = new GenericTree.TreeNode<>("Domestic", child2, new ArrayList<>());
        GenericTree.TreeNode<String> child2_2 = new GenericTree.TreeNode<>("International", child2, new ArrayList<>());
        child2.getChildren().add(child2_1);
        child2.getChildren().add(child2_2);

        // Adding a child to International
        GenericTree.TreeNode<String> child2_2_1 = new GenericTree.TreeNode<>("Canada", child2_2, new ArrayList<>());
        GenericTree.TreeNode<String> child2_2_2 = new GenericTree.TreeNode<>("S. America", child2_2, new ArrayList<>());
        GenericTree.TreeNode<String> child2_2_3 = new GenericTree.TreeNode<>("Overseas", child2_2, new ArrayList<>());
        child2_2.getChildren().add(child2_2_1);
        child2_2.getChildren().add(child2_2_2);
        child2_2.getChildren().add(child2_2_3);  
        
        // Adding a child to Overseas
        GenericTree.TreeNode<String> child2_2_3_1 = new GenericTree.TreeNode<>("Africa", child2_2_3, new ArrayList<>());
        GenericTree.TreeNode<String> child2_2_3_2 = new GenericTree.TreeNode<>("Europe", child2_2_3, new ArrayList<>());
        GenericTree.TreeNode<String> child2_2_3_3 = new GenericTree.TreeNode<>("Asia", child2_2_3, new ArrayList<>());
        GenericTree.TreeNode<String> child2_2_3_4 = new GenericTree.TreeNode<>("Australia", child2_2_3, new ArrayList<>());
        child2_2_3.getChildren().add(child2_2_3_1);
        child2_2_3.getChildren().add(child2_2_3_2);
        child2_2_3.getChildren().add(child2_2_3_3); 
        child2_2_3.getChildren().add(child2_2_3_4); 
        
        // Adding a child to Manufacturing
        GenericTree.TreeNode<String> child4_1 = new GenericTree.TreeNode<>("TV", child4, new ArrayList<>());
        GenericTree.TreeNode<String> child4_2 = new GenericTree.TreeNode<>("CD", child4, new ArrayList<>());
        GenericTree.TreeNode<String> child4_3 = new GenericTree.TreeNode<>("Tuner", child4, new ArrayList<>());
        child4.getChildren().add(child4_1);
        child4.getChildren().add(child4_2);
        child4.getChildren().add(child4_3);        
        
        for (String element : tree) {
            System.out.println(element);
        }   
        
        System.out.println("---------------");
        // Using parent method
        System.out.println("Parent of Sales: " + tree.parent(child2).getElement());

        // Using children method
        System.out.print("Children of Root: ");
        for (Position<String> child : tree.children(root)) {
            System.out.print(child.getElement() + " ");
        }
        System.out.println(); 
        
        // Using numChildren method
        System.out.println("Number of children of Root: " + tree.numChildren(root));
        
        // Using isInternal method
        System.out.println("Is Root internal? " + tree.isInternal(root));        

        // Using isExternal method
        System.out.println("Is Child R&D external? " + tree.isExternal(child2_1));
        
        // Using isRoot method
        System.out.println("Is Root the root? " + tree.isRoot(root));        
        
        // Using size method
        System.out.println("Size of the tree: " + tree.size());

        
        System.out.println("---------------");
        
    }
}



