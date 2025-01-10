import java.lang.StringBuilder;

public class LinkedList {

    private Node firstNode;

    private int numOfElements = 0;

    private int elementOfFirstNode;

    protected Node getFirstNode() {
        return firstNode;
    }

    /**
     * @param n
     */
    public void add(int n) {
        if (numOfElements == 0) {
            firstNode = new Node(n, null);
            numOfElements = numOfElements + 1;
        }
        else {
            Node nodeptr = getFirstNode();
            Node setAsNode = new Node(n, null);
            while (nodeptr.getNext() != null) {
                nodeptr = nodeptr.getNext();
            }
            nodeptr.setNext(setAsNode);
            numOfElements = numOfElements + 1;
        }
    }

    /**
     * @param n
     * @param index
     */
    public void add(int n, int index) {
        Node nodeptr = getFirstNode();
        if (index < 0) {
            throw new IllegalArgumentException("Negative Index Value!");
        }
        else if (index >= numOfElements) {
            this.add(n);
        }
        else {
            for (int i = 0; i < index-1; i++) {
                System.out.println(nodeptr.getElement());
                nodeptr = nodeptr.getNext();
            }
            Node tempNode = nodeptr.getNext().getNext();
            Node insertNode = new Node(n, null);
            nodeptr.setNext(insertNode);
            nodeptr = nodeptr.getNext();
            nodeptr.setNext(tempNode);
            nodeptr = getFirstNode();
            for (int i = 0; i < numOfElements; i++) {
                System.out.println(nodeptr.getElement());
                nodeptr = nodeptr.getNext();
            }
        }
    }

    /**
     * @param n
     * @return
     */
    public int indexof(int n) {
        Node nodeptr = getFirstNode();
        int nodeptrElement = elementOfFirstNode;
        for (int i = 0; i < numOfElements; i++) {
            nodeptrElement = nodeptr.getElement();
            if (nodeptrElement == n) {
                return i;
            }
            nodeptr = nodeptr.getNext();
        }
        return -1;
    }

    /**
     * @param index
     * @return
     */
    public int remove(int index) throws IllegalArgumentException {
        Node nodeptr = getFirstNode();
        if (index < 0) {
            throw new IllegalArgumentException("Negative Index Value!");
        }
        else if (numOfElements == 1) {
            int returnElement = nodeptr.getElement();
            numOfElements = numOfElements - 1;
            return returnElement;
        }
        else if (index == 0) {
            int returnElement = nodeptr.getElement();
            firstNode = nodeptr.getNext();
            elementOfFirstNode = firstNode.getElement();
            numOfElements = numOfElements - 1;
            return returnElement;
        }
        else if (index >= numOfElements-1) {
            for(int i = 0; i < numOfElements-2;i++){
                System.out.println(nodeptr.getElement());
                nodeptr = nodeptr.getNext();
            }
            Node nextNode = nodeptr.getNext();
            int returnElement = nextNode.getElement();
            nodeptr.setNext(null);
            numOfElements = numOfElements - 1;
            return returnElement;
        }
        else {
            for (int i = 0; i < index-1; i++) {
                System.out.println(nodeptr.getElement());
                nodeptr = nodeptr.getNext();
                System.out.println(nodeptr.getElement());
            }
            Node tempNode = nodeptr.getNext();
            int returnElement = tempNode.getElement();
            tempNode = tempNode.getNext();
            nodeptr.setNext(tempNode);
            numOfElements = numOfElements - 1;
            return returnElement;
        }
    }
    
    /**
     * @param n
     */
    public void removeValue(int n) {
        int haveremoved = 0;
        int counterOfElements = 0;
        Node nodeptr = getFirstNode();

        while ((haveremoved == 0) && (counterOfElements < numOfElements)) {
            if (counterOfElements == 0) {
                if (nodeptr.getElement() == n) {
                    nodeptr = nodeptr.getNext();
                    this.firstNode = nodeptr;
                    haveremoved = haveremoved + 1;
                    numOfElements = numOfElements - haveremoved;
                }
                else {
                    nodeptr = nodeptr.getNext();
                }
            }
            else if ((counterOfElements > 0) && (counterOfElements < numOfElements)) {
                if (nodeptr.getElement() == n) {
                    nodeptr = getFirstNode();
                    for (int i = 0; i < counterOfElements-1; i++) {
                        System.out.println(nodeptr.getElement());
                        nodeptr = nodeptr.getNext();
                        System.out.println(nodeptr.getElement());
                    }
                    Node tempNode = nodeptr.getNext();
                    int returnElement = tempNode.getElement();
                    tempNode = tempNode.getNext();
                    nodeptr.setNext(tempNode);
                    numOfElements = numOfElements - 1;
                }
                else {
                    nodeptr = nodeptr.getNext();
                }
            }
            else if (counterOfElements + 1 == numOfElements) {
                if (nodeptr.getNext().getElement() == n) {
                    nodeptr.getNext().setNext(null);
                    haveremoved = haveremoved + 1;
                    numOfElements = numOfElements - haveremoved;
                }
                else {
                    nodeptr = nodeptr.getNext();
                }
            }
            else {
                nodeptr = nodeptr.getNext();
            }
            counterOfElements = counterOfElements + 1;
        }
    }

    /**
     * @param n
     */
    public void removeall(int n) {
        int nElements = 0;
        int counterOfElements = 0;
        Node nodeptr = getFirstNode();

        while (counterOfElements < numOfElements) {
            if (nodeptr.getElement() == n) {
                nElements = nElements + 1;
            }
            if (nElements > 0) {
                this.removeValue(n);
            }
            nodeptr = nodeptr.getNext();
            counterOfElements = counterOfElements + 1;
        }
    }

    /**
     * @return
     */
    public double mean() {
        double sum = 0;
        Node nodeptr = getFirstNode();
        if (numOfElements == 0) {
            return 0;
        }
        for(int i = 0; i < numOfElements; i++) {
            sum = sum + nodeptr.getElement();
            nodeptr = nodeptr.getNext();
        }
        return (sum/numOfElements);
    }

    /**
     * @return
     */
    public double variance() {
        double summation = 0;
        Node nodeptr = getFirstNode();
        for (int i = 0; i < numOfElements; i++) {
            summation = summation + oneValueOfSummation(nodeptr.getElement());
            nodeptr = nodeptr.getNext();
        }

        if (numOfElements == 1) {
            return 0;
        }
        else {
            double varaince = (summation/(numOfElements-1));
            return varaince; 
        }
    }

    /**
     * @param nodeValue
     * @return the summation value
     */
    public double oneValueOfSummation(int nodeValue) {
        if (this.mean() > nodeValue) {
            double meanindex = this.mean() - nodeValue;
            System.out.println(meanindex);
            double sqrmeanindex = meanindex * meanindex;
            System.out.println(sqrmeanindex);
            return (sqrmeanindex);
        }
        else {
            double meanindex = nodeValue - this.mean();
            double sqrmeanindex = meanindex * meanindex;
            return (sqrmeanindex);
        }
    }

    /**
     * @param lower
     * @param upper
     * @return
     */
    public LinkedList sublist (int lower, int upper) {
        LinkedList subli = new LinkedList();
        Node nodeptr = getFirstNode();
        int nodeptrElement = elementOfFirstNode;
        for (int i = 0; i < numOfElements; i++) {
            nodeptrElement = nodeptr.getElement();
            if (nodeptrElement > lower && nodeptrElement < upper) {
                subli.add(nodeptrElement);
            }
            nodeptr = nodeptr.getNext();
        }
        return subli;
    }

    /**
     * @return
     */
    public LinkedList removeNoise() {
        LinkedList subli = new LinkedList();

        if (numOfElements == 0) {
            return subli;
        }
        else if (numOfElements == 1) {
            subli.add(elementOfFirstNode);
            return subli;
        }
        else {
            double mean = this.mean();
            double stddev = Math.sqrt(this.variance());
            int lowerEnd = (int)(mean - (3*stddev) + 1);
            int highEnd = (int)(mean + (3*stddev) + 1);
            return (this.sublist(lowerEnd, highEnd));
        }
    }


    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        Node nodeptr = getFirstNode();
        builder.append("[");
        for (int i = 0; i < numOfElements; i++) {
            builder.append(nodeptr.getElement());
            nodeptr = nodeptr.getNext();
            builder.append(' ');
        }
        builder.append("]");
        return builder.toString();
    }

    /* 
    public LinkedList ReverseLinkedListInSections(LinkedList modiList,int left, int right) {
        Node head = modiList.getFirstNode();

        if (head == null || left == right) {
                return modiList;
           }
        
        //in case of left being 1, will be left out later in the loop
        Node placeholder = new Node(-25, null); 
        placeholder.setNext(head); 
    
    
        Node beforeLeft = placeholder;
        //Loop for getting the Node right before the left position
        for (int i = 1; i < left; i++) {
            beforeLeft = beforeLeft.getNext();
        }
    
        Node beforeRight = beforeLeft;
        //Loop for getting the last Node that needs to be flipped
        for (int i = left; i <= right; i++) {
            beforeRight = beforeRight.getNext();
        }
        
        Node leftNodeFlip = beforeLeft.getNext();
        Node rightNodeFlip = beforeRight.getNext();
    
        beforeRight.setNext(null);
    
        Node oldNode = null;
        Node newNode = leftNodeFlip;
        Node nextNode = newNode.getNext();

        while (newNode != null) {
            nextNode = newNode.getNext();
            newNode.setNext(oldNode);
            oldNode = newNode;
            newNode = nextNode;
    }
    
    beforeLeft.setNext(oldNode);
    leftNodeFlip.setNext(rightNodeFlip);
    
    return modiList;
    }  
    */
}