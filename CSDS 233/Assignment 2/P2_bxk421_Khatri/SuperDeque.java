import java.lang.StringBuilder;
public class SuperDeque<E> {

    /**
     * The index that represents the front of the data structure
     */
    private int front;

    /**
     * The index that represents the back of the data structure
     */
    private int back;

    /**
     * The array that stores the data of SuperDeque
     */
    private E[] dq;

    /**
     * The initial size of SuperDeque
     */
    private static final int DEFAULT_CAP = 1;
    
    @SuppressWarnings("unchecked")
    public SuperDeque(){
        this.dq = (E[]) new Object[DEFAULT_CAP];
        this.front = 0;
        this.back = 0;
    } 

    /**
     * SuperDeque works like a stack --> add an element to the top of the stack
     * @param element
     */
    public void push(E element) {
        int amountOfValues = dq.length;
        // Checks if the SuperDeque is full. If it is, the size is doubled. Then the value is added at the front
        if (back == dq.length) {
            this.doubleSize();
            @SuppressWarnings("unchecked")
            E[] tempList = (E[]) new Object[dq.length];
            //Loops through all the values and adds them to the list
            for (int i = 0; i < amountOfValues; i++) {
                tempList[i] = dq[i];
            }
            tempList[back] = element;
            dq = tempList;
            back ++;
        }
        else {
            @SuppressWarnings("unchecked")
            E[] tempList = (E[]) new Object[dq.length];
            //Loops through all the values and adds them to the list
            for (int i = 1; i < amountOfValues; i++) {
                tempList[i] = dq[i-1];
            }
            tempList[back] = element;
            dq = tempList;
            back ++;
        }
        

    }

    /**
     * @return the top, removed element of the stack (if empty, return null)
     */
    public E pop(){
        if (this.isEmpty() == true) {
            return null;
        }
        else {
            E removeValue = this.peek();
            @SuppressWarnings("unchecked")
            E[] tempList = (E[]) new Object[dq.length];
            for (int i = 0; i < back-1; i++) {
                tempList[i] = (dq[i]);
            }
            back = back - 1;
            dq = tempList;
            return removeValue;
        }
    }

    /**
     * @return the top element of the stack (if empty, return null)
     */
    public E peek() {
        if (this.isEmpty() == true) {
            return null;
        }
        else {
            return dq[back-1];
        }
    }

    /**
     * SuperDeque works as a queue and adds an element at the back of superdeque
     * @param element
     */
    public void enqueue(E element){
        int amountOfValues = dq.length;

        //If the list has no values, if empty, if the front and back are NOT next to each other, else when they are next to each other
        if (this.isEmpty()) {
            this.push(element);
        }
        else if (front == back && dq[front] == null) {
            this.push(element);
            back = 0;
        }
        else if (back + 1!= front) {

            //If the back value is at the end of the list
            if (back % amountOfValues == 0) {

                //If the front value is NOT at the start of the list
                if (front != 0) {
                    @SuppressWarnings("unchecked")
                    E[] tempList = (E[]) new Object[dq.length];
                    tempList[0] = element;
                    for (int i = 1; i < amountOfValues; i++) {
                        tempList[i] = (dq[i]);
                    }
                    back = 1;
                    dq = tempList;
                }
                //If the front value is AT THE START
                else {
                    this.doubleSize();
                    dq[back] = element;
                    back ++;
                } 
            }
            // If the back value is not at the end
            else {
                dq[back] = element;
                back ++;
            }
        }
        else {
            @SuppressWarnings("unchecked")
            E[] frontList = (E[]) new Object[dq.length - front + 1];
            @SuppressWarnings("unchecked")
            E[] backList = (E[]) new Object[back];

            //This for-loop stores from head to end
            for (int placer = 0, counter = front; counter < dq.length; counter++, placer ++) {
                frontList[placer] = dq[counter];
            }

            //This for-loop stores from start to tail
            for (int i = 0; i < back; i++) {
                backList[i] = dq[i];
            }

            //Double the size of the queue
            this.doubleSize();

            //This for-loop add the start to tail again, adds the element, then after adds one to the "back"
            for (int i = 0; i < backList.length; i++){
                dq[i] = backList[i];
            }
            dq[back] = element;
            back ++;

            // This for-loop makes the values null between the element and "front," and then changes the front value
            for(int i = back; i < front; i++) {
                dq[i] = null;
            }
            front = front + (dq.length/2);

            //This for-loop adds the front to back values again
            for (int i = front, j = 0; i < dq.length; i++, j++) {
                dq[i] = frontList[j];
            }
        }
    }

    /**
     * Remove the first element (return null if empty)
     * @return the element at the front
     */
    public E dequeue() {
        if (this.isEmpty() == true) {
            return null;
        }
        else {
            if (front == 0) {
                E removeValue = dq[0];
                @SuppressWarnings("unchecked")
                E[] tempList = (E[]) new Object[dq.length];
                for (int i = 1; i < dq.length; i++) {
                    tempList[i] = dq[i];
                }
                dq = tempList;
                front ++;
                return removeValue;
            }
            else if (front % dq.length == 0) {
                E removeValue = dq[0];
                @SuppressWarnings("unchecked")
                E[] tempList = (E[]) new Object[dq.length];
                for (int i = 1; i < dq.length; i++) {
                    tempList[i] = dq[i];
                }
                dq = tempList;
                front = 1;
                return removeValue;
            }
            else {
                E removeValue = dq[front];
                @SuppressWarnings("unchecked")
                E[] tempList = (E[]) new Object[dq.length];
                for (int i = 0; i < front; i++) {
                    tempList[i] = dq[i];
                }
                for (int i = front+1; i < dq.length; i++) {
                    tempList[i] = dq[i];
                }
                dq = tempList;
                front ++;
                return removeValue;
            }
            
        }
    }

    /**
     * @return true if the array is empty
     */
    public boolean isEmpty() {
        if ((back == 0)){
            return true;
        }
        else if (front == back){
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * If the array is full, doubles the size of the array
     */
    private void doubleSize() {
        int numberOfValues = dq.length;
        @SuppressWarnings("unchecked")
        E[] doubleSizeArray = (E[]) new Object[dq.length * 2];
        for (int i = 0; i < numberOfValues; i++) {
            doubleSizeArray[i] = dq[i];
        }
        dq = doubleSizeArray;
    }

    /**
     * @return A string the represents the array
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("'");
        for (int j = 0; j < dq.length; j++) {
            builder.append(dq[j]);
            if (j+1 != dq.length) {
                builder.append(",");
            }
        }
        builder.append("'"); 
        return (builder.toString());
    }

    public static void main(String[] args){

    }
} 