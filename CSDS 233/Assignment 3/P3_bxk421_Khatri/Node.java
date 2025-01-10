public class Node {

    private int element;

    private Node next;

    /**
     * @param element
     * @param next
     */
    public Node(int element, Node next) {
        this.element = element;
        this.next = next;
    }

    /**
     * @return the element the node is pointing at
     */
    public int getElement() {
        return element;
    }

    /**
     * @return the next node that can be pointed at
     */
    public Node getNext() {
        return next;
    }

    /**
     * @param element
     */
    public void setElement(int element) {
        this.element = element;
    }

    /**
     * @param next
     */
    public void setNext(Node next) {
        this.next = next;
    }
}