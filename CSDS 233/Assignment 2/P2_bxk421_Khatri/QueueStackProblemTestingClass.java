import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class QueueStackProblemTestingClass {
    
    /**
     * Test at your own mercy, this crashed my computer twice, I tried to fix it and now it just...doesn't work
     * This will evaluate an expression
     */
    @Test
    public void testPostFix() {
        String postFix = "(“27 3 9 * + 1 ”)";
        assertEquals("try", 53, QueueStackProblems.evaluatePostFix(postFix));
    }

    /**
     * I'm not gonna lie this just doesn't work
     */
    @Test
    public void testReverseK() {
        SuperDeque<String> dq = new SuperDeque<>();
        dq.push("1");
        dq.push("2");
        dq.push("3");
        dq.push("4");
        dq.push("5");
        dq.push("6");
        dq.push("7");
        dq.push("8");

        //assertEquals("try", 53, reverseK(dq , 4)); so this also cannot test :(
    }

    // There are no other tests because I didn't do the rest :/
}
