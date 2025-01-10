import java.lang.StringBuilder;
public class QueueStackProblems {

    public static int evaluatePostFix (String postfix) {
        StringBuilder builder = new StringBuilder();
        SuperDeque<Integer> numbers = new SuperDeque<Integer>();
        for(int i = 0; i < postfix.length(); i++) {
            if (postfix.charAt(i) == ' ') {
                if (Character.isDigit(postfix.charAt(i+1)) == true) {
                    String newInteger = builder.toString();
                    int newInt = Integer.parseInt(newInteger);
                    System.out.println(newInt);
                    numbers.push(newInt);
                    builder = new StringBuilder();
                    System.out.println(numbers.toString());
                }
            }
            else if (postfix.charAt(i) == '*') {
                int number1 = numbers.pop();
                int number2 = numbers.pop();

                numbers.push(number2 * number1);
                System.out.println(numbers.toString());
            }
            else if (postfix.charAt(i) == '+') {
                int number1 = numbers.pop();
                int number2 = numbers.pop();
                numbers.push(number2 + number1);
            }
            else if (postfix.charAt(i) == '-') {
                int number1 = numbers.pop();
                int number2 = numbers.pop();

                numbers.push(number2 - number1);
            }
            else if (postfix.charAt(i) == '/') {
                int number1 = numbers.pop();
                int number2 = numbers.pop();

                numbers.push(number2 / number1);
            }
            else if (postfix.charAt(i) == '%') {
                int number1 = numbers.pop();
                int number2 = numbers.pop();

                numbers.push(number2 % number1);
            }
            else if (Character.isDigit(postfix.charAt(i)) == true){
                builder.append(postfix.charAt(i));
                System.out.println(postfix.charAt(i));
            }
            else {
                System.out.println(postfix.charAt(i));
            }
        }
        return numbers.pop();
    }

    public static String reverseWords (String s) {
        /** 
         * The idea was to have the builder store each word, once it hit a space add to a superdequeue
         * The superdequeue would store the word in the opposite order, and then that would be able to be but into a final 
         * builder which would then be returned as a toString.
         */
        StringBuilder builder = new StringBuilder();
        
        return "hello";
    }

    public static SuperDeque<E> reverseK (SuperDeque<E> dq, int k) {
        SuperDeque<E> newList = new SuperDeque<E>();
        if (k > dq.length()) {
            for (int i = dq.length - 1; i == 0; i--) {
                newList.enqueue(dq[i]);
            }
            return newList;
        }
        else {
            for (int i = k; i == 0; i--) {
                newList.enqueue(dq[i]);
            }
            for (int i = k; i < dq.length; i++) {
                newList.enqueue(dq[i]);
            }
            return newList;
        }

    }

    public static int playGame(int n, int offset) {
        /** 
         * The idea was to do a mod operation and loop through the data structure. The mod would be which number of the 
         * structure would be eliminated.
         */ 
        int num = n;
        for (int i = 1; i < n; i++) {
            
        }
        return 5;
    }

    public static void main(String[] args){

    }
}

