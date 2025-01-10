import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinarySearchTree {
    
    private Node root;

    /**
     * Should be implemented in O(log n) time
     * @param value
     * @return whether or not the tree contains a node of this value
     */
    public boolean contains (int value) {
        if (root == null) {
            return false;
        }
        if (root.getElement() == value) {
            return true;
        }
        else {
            return searchForValue(root, value);
        }
       
    }

    /**
     * @param parent
     * @param value
     * @return Whether the value is in the binary tree or not
     */
    private boolean searchForValue(Node parent, int value) {
        if (parent == null) {
            return false;
        }
        if (parent.getElement() == value) {
            return true;
        }
        if (value < parent.getElement()) {
            return searchForValue(parent.getNextLeft(), value);
        } 
        if (value > parent.getElement()){
            return searchForValue(parent.getNextRight(), value);
        }
        return false;
    }

    /**
     * Adds an element to the tree (left for less than, right for greater or equal to)
     * @param value
     */
    public void add(int value) {
        Node childNode = new Node (value);

        //Set the root to be null
        if (root == null) {
            root = childNode;

        }
        //Set the node it should belong to null
        else {
            Node parentNode = searchForNullNode(root, value);

            //Left for less than
            if (value <= parentNode.getElement()) {
                parentNode.setNextLeft(childNode);
            } 
            //Right for greater or equal
            else {
                parentNode.setNextRight(childNode);
            }
        }
    }

    /**
     * @param parent
     * @param value
     * @return what the last node is, is used so something can be added to it
     */
    private Node searchForNullNode(Node parent, int value) {
        //First node null node
        if (parent == null) {
            return null; 
        }

        //Figure out which side to look at, this is for left
        if (value < parent.getElement()) {
            //Searching for null
            if (parent.getNextLeft() != null) {
                return searchForNullNode(parent.getNextLeft(), value); // Recursively look at each node till null is found
            } 
            else {
                return parent;
            }
        } 
        //This is for right
        else {
            //Searching for null
            if (parent.getNextRight() != null) {
                return searchForNullNode(parent.getNextRight(), value); // Recursively look at each node till null is found
            } 
            else {
                return parent;
            }
        }
    }

    /**
     * @return a string representation of DFS
     */
    @Override
    public String toString() {
        if (root == null) {
            return "";
        }

        StringBuilder builder = new StringBuilder();
        Stack<Node> dfStack = new Stack<>();
        dfStack.push(root);

        //
        while (!dfStack.isEmpty()) {
            Node node = dfStack.pop();
            builder.append(node.getElement());
            builder.append(" ");
    
            // Push right child first so that left child is processed first (LIFO)
            if (node.getNextRight() != null){
                dfStack.push(node.getNextRight());
            }

            //Push left child
            if (node.getNextLeft() != null){
                dfStack.push(node.getNextLeft());
            }
        }

        // Get rid of the last space
        if (builder.length() > 0) {
            builder.setLength(builder.length() - 1);
        }
        
        return builder.toString();
    }

    /**
     * @return a string representation of breadth first search representation of the tree
     */
    public String bfs() {
        if (root == null) {
            return "";
        }

        StringBuilder builder = new StringBuilder();
        Queue<Node> dfQueue = new LinkedList<>();
        dfQueue.offer(root);

        while (!dfQueue.isEmpty()) {
            int levelSize = dfQueue.size();

            for (int i = 0; i < levelSize; i++) {
                Node node = dfQueue.poll();
                builder.append(node.getElement()).append(" ");

                if (node.getNextLeft() != null) {
                    dfQueue.offer(node.getNextLeft());
                }

                if (node.getNextRight() != null) {
                    dfQueue.offer(node.getNextRight());
                }
            }
        }

        if (builder.length() > 0) {
            builder.setLength(builder.length() - 1);
        }

        return builder.toString();
    }

    /**
     * @param value
     * @return if the element was deleted or not
     */
    public boolean delete (int value) {
        if (this.contains(value) == false) {
            return false;
        }
        else {
            // Find the node to delete and its parent
            Node nodeToDelete = root;
            while (nodeToDelete != null && nodeToDelete.getElement() != value) {
                if (value < nodeToDelete.getElement()) {
                    nodeToDelete = nodeToDelete.getNextLeft();
                } 
                else {
                    nodeToDelete = nodeToDelete.getNextRight();
                }
            }
        }
        return true;
    }

    /**
     * @return the height of the tree
     */
    public int height() {
        if (root == null) {
            return 0;
        }

        int height = 0;
        Node leftCurrent = root;
        Node rightCurrent = root;

        //Traversing through the tree starting from the left
        while (leftCurrent != null || rightCurrent != null) {
            // Traverse down the left side
            if (leftCurrent != null) {
                height++;
                leftCurrent = leftCurrent.getNextLeft();
            }
            // Traverse down the right side
            if (rightCurrent != null) {
                height++;
                rightCurrent = rightCurrent.getNextRight();
            }
        }
        return (height);
    }

    /**
     * @param sum
     * @return whether there is a sum of the given value
     */
    public boolean hasSum(int sum) {
        return hasSum(root, sum);
    }

    /**
     * @param root
     * @param sum
     * @return if there is a sum
     */
    private boolean hasSum(Node root, int sum) {
        //The node is null :/
        if (root == null)
            return false;

        // If the current node is a leaf node and its value equals the remaining sum, then we found a path with the desired sum.
        if (root.getNextLeft() == null && root.getNextRight() == null && root.getElement() == sum)
            return true;

        // Recursively check for the sum in the left and right subtrees, subtracting the current node's value from the remaining sum.
        return hasSum(root.getNextLeft(), sum - root.getElement()) || hasSum(root.getNextRight(), sum - root.getElement());
    }

    /**
     * @param tree
     * @return if the tree is symmetrical
     */
    public static boolean isSymmetrical(int[] tree) {
        if ((tree == null) || (tree.length == 0)) {
            return true; // Empty tree or a tree with only one node is symmetrical
        }

        return mirror(tree, 0, (tree.length - 1));
    }
    
    /**
     * @param tree
     * @param left
     * @param right
     * @return if the mirror is true or not
     */
    private static boolean mirror(int[] tree, int leftIndex, int rightIndex) {
        // If the left index exceeds the right index, subtree is empty and symmetrical
        if (leftIndex >= rightIndex) {
            return false;
        }
    
        // Check if the values at the current indices are equal
        if (tree[leftIndex] != tree[rightIndex]) {
            return false;
        }
    
        // Recursively check if the left and right subtrees are mirrors of each other
        return (mirror(tree, leftIndex + 1, rightIndex - 1) && mirror(tree, leftIndex * 2 + 1, rightIndex * 2));
    }


    private class Node{
        private int value;
        private Node left;
        private Node right;

        /**
         * @param value
         */
        private Node (int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }

        /**
         * @return the element of the node
         */
        private int getElement() {
            return value;
        } 

        /**
         * @return the left node
         */
        private Node getNextLeft() {
            return left;
        }

        /**
         * @return the right node
         */
        private Node getNextRight() {
            return right;
        }

        /**
         * Set the left child
         * @param childLeft
         */
        private void setNextLeft(Node childLeft) {
            left = childLeft; 
        }

        /**
         * Set the Right child
         * @param childRight
         */
        private void setNextRight(Node childRight) {
            right = childRight;
        }
    }
}