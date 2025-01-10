public class Recursion {
    
    /**
     * @param n
     * @return
     */
    public int sumDigits(int n) {
        if (n < 0) {
            n = n*-1;
        }
        if (n == 0) {
            return 0;
        }
        else {
            return (n % 10 + sumDigits(n/10));
        }
    }    

    /**
     * @param a
     * @param b
     * @return
     */
    public int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        else {
            return (gcd(b, a%b));
        }
    }

    /**
     * @param str
     * @return
     */
    public boolean isPalidrome (String str) {
        if (str.length() == 0 || str.length() == 1) {
            return true;
        }
        if(str.charAt(0) == str.charAt(str.length()-1)) {
            return isPalidrome(str.substring(1, str.length()-1));
        }
        return false;
    }

    /**
     * @param head
     * @return
     */
    public Node swapNodesInPairs(Node head) {
        if (head == null || head.getNext() == null) {
            return head;
        }

        Node nextPairHead = head.getNext().getNext();
        Node newHead = head.getNext();
        Node nextHead = head.getNext();
        head = head.getNext().getNext();
        nextHead = swapNodesInPairs(nextPairHead);
        return newHead;
    }

    /**
     * @param n
     * @param k
     * @return the value of the binomial equation
     * @throws IllegalArgumentException
     */
    public int binomial (int n, int k) throws IllegalArgumentException {

        if (n < 0 || k < 0) {
            throw new IllegalArgumentException("Nuh uh!");
        }
        else if (k == 0 || k == n) {
            return 1;
        }
        else {
            return binomial(n - 1, k - 1) + binomial(n - 1, k);
        }
    }
}