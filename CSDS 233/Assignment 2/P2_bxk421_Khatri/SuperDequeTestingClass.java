import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class SuperDequeTestingClass {
    
    @Test
    public void testPush() {
        SuperDeque<Integer> originalSuperDeque = new SuperDeque<Integer>();
        assertEquals("The original list", "'null'",originalSuperDeque.toString());
        originalSuperDeque.push(1);
        assertEquals("The original list with one element", "'1'",originalSuperDeque.toString());
        originalSuperDeque.push(2);
        assertEquals("The pushed list", "'1,2'",originalSuperDeque.toString());
        originalSuperDeque.push(3);
        assertEquals("The pushed list again", "'1,2,3,null'",originalSuperDeque.toString());
    }

    @Test
    public void testPop() {
        SuperDeque<String> originalSuperDeque = new SuperDeque<String>();
        assertEquals("Is 'isEmpty' Working", null, originalSuperDeque.pop());
        originalSuperDeque.push("One");
        originalSuperDeque.push("Two");
        originalSuperDeque.push("Three");
        assertEquals("The List with the first value popped", "Three", originalSuperDeque.pop());
        assertEquals("The original list", "'One,Two,null,null'",originalSuperDeque.toString());
        assertEquals("The List with the second value popped", "Two", originalSuperDeque.pop());
        assertEquals("The original list", "'One,null,null,null'",originalSuperDeque.toString());
        assertEquals("The List with the third value popped", "One", originalSuperDeque.pop());
        assertEquals("The original list", "'null,null,null,null'",originalSuperDeque.toString());
    }

    @Test
    public void testPeek() {
        SuperDeque<String> originalSuperDeque = new SuperDeque<String>();
        assertEquals("Peek the no value", null, originalSuperDeque.peek());

        originalSuperDeque.push("One");
        assertEquals("Peek the front value", "One", originalSuperDeque.peek());

        originalSuperDeque.push("Two");
        assertEquals("Peek the front value", "Two", originalSuperDeque.peek());

        originalSuperDeque.push("Three");
        assertEquals("Peek the front value", "Three", originalSuperDeque.peek());

        originalSuperDeque.pop();
        assertEquals("Peek the front value", "Two", originalSuperDeque.peek());
    }

    @Test
    public void testEnqueue() {
        SuperDeque<String> queueSuperDeque = new SuperDeque<String>();

        queueSuperDeque.enqueue("One");
        assertEquals("Will the value add?","'One'",queueSuperDeque.toString());
        queueSuperDeque.enqueue("Two");
        assertEquals("Will the value add?","'One,Two'",queueSuperDeque.toString());
        queueSuperDeque.enqueue("Three");
        assertEquals("Will the value add?","'One,Two,Three,null'",queueSuperDeque.toString());

    }

    @Test
    public void testDequeue() {
        SuperDeque<String> queueSuperDeque = new SuperDeque<String>();
        assertEquals("Empty List", null, queueSuperDeque.dequeue());

        queueSuperDeque.enqueue("One");
        queueSuperDeque.enqueue("Two");
        queueSuperDeque.enqueue("Three");
        queueSuperDeque.enqueue("Four");

        System.out.println(queueSuperDeque.toString());
        assertEquals("Remove the first element", "One",queueSuperDeque.dequeue());
        System.out.println(queueSuperDeque.toString());
        assertEquals("Remove the second element", "Two",queueSuperDeque.dequeue());
        System.out.println(queueSuperDeque.toString());
        assertEquals("Remove the third element", "Three",queueSuperDeque.dequeue());
        System.out.println(queueSuperDeque.toString());
        assertEquals("Remove the third element", "Four",queueSuperDeque.dequeue());
        assertEquals("Empty List", null, queueSuperDeque.dequeue());
        System.out.println(queueSuperDeque.toString());

        queueSuperDeque.enqueue("Five");
        queueSuperDeque.enqueue("Six");
        queueSuperDeque.enqueue("Seven");
        queueSuperDeque.enqueue("Eight");
        queueSuperDeque.enqueue("Nine");
        assertEquals("Will the value add?","'Nine,null,null,null,Five,Six,Seven,Eight'",queueSuperDeque.toString());
    }
}
