import java.lang.StringBuilder;

public class ArrayList{

    private int numberOfValues = 1; 

    private int recordingList[] = new int[numberOfValues]; 

    /**
     * @param n
     */
    public void add (int n) {
        int tempList[] = new int[numberOfValues + 1];
        for (int i = 0; i < numberOfValues-1; i++) { 
            tempList[i] = recordingList[i];
        }
        tempList[numberOfValues-1] = n;
        recordingList = tempList;
        numberOfValues++;
    }

    /**
     * @param n
     * @param index
     */
    public void add (int n, int index) throws IllegalArgumentException {
        if (index < 0) {
            throw new IllegalArgumentException("Negative Index Value!");
        }
        if (index >= numberOfValues-1) {
            this.add(n);
        }
        else {
            recordingList[index] = n;
        }
    }

    /**
     * @param n
     * @return
     */
    public int indexof(int n) {
        for (int i = 0; i < numberOfValues-1; i++) {
            if (recordingList[i] == n) {
                return i;
            }
        }
        return -1;
    }

    /**
     * @param index
     * @return
     */
    public int remove (int index) throws IllegalArgumentException {
        int removeValue = 0;
        if (index < 0) {
            throw new IllegalArgumentException("Negative Index Value!");
        }
        else if (index > numberOfValues-1) {
            int Removeindex = numberOfValues - 2;
            System.out.println(Removeindex);
            int tempList[] = new int[numberOfValues-1];
            for (int i = 0, j = 0; i < numberOfValues-1; i++) {
                if (i == Removeindex) {
                    removeValue = recordingList[i];
                }
                else {
                    tempList[j] = recordingList[i];
                    j = j + 1;
                }
            }
            numberOfValues = numberOfValues - 1;
            recordingList = tempList;
        }
        else {
            int tempList[] = new int[numberOfValues-1];
            for (int i = 0, j = 0; i < numberOfValues-1; i++) {
                if (i == index) {
                    removeValue = recordingList[i];
                }
                else {
                    tempList[j] = recordingList[i];
                    j = j + 1;
                }
            }
            numberOfValues = numberOfValues - 1;
            recordingList = tempList;
        }
        return removeValue;
    }

    /**
     * @param n
     */
    public void removeValue (int n) {
        int remove = 0;
        int index = 0;
        int counterOfElements = 0;

        while ((remove == 0) && (counterOfElements < numberOfValues-1)){
            if (counterOfElements == 0) {
                if (recordingList[counterOfElements] == n) {
                    remove(0);
                    numberOfValues = numberOfValues - 1;
                    remove = remove + 1;
                }
                else {
                    counterOfElements = counterOfElements + 1;
                }
            }
            else if ((counterOfElements > 0) && (counterOfElements < numberOfValues-1)) {
                if (recordingList[counterOfElements] == n) {
                    remove (counterOfElements);
                    numberOfValues = numberOfValues - 1;
                    remove = remove + 1;
                }
                else {
                    counterOfElements = counterOfElements + 1;
                }
            }
            else if (counterOfElements + 1 == numberOfValues-1) {
                remove(counterOfElements);
                numberOfValues = numberOfValues - 1;
                remove = remove + 1;
            }
            else {
                counterOfElements = counterOfElements + 1;
            }
        }
        for (int i = 0; i < numberOfValues-1; i++) {
            while (remove == 0) {
                if (recordingList[i] == n) {
                    remove = remove + 1;
                    index = i;
                }
            }
        }
        if (remove > 0) {
            remove(index);
        }
    }

    /**
     * @param n
     */
    public void removeall(int n) {
        int index[] = new int[numberOfValues-1];
        for (int i = 0, k = 0; i < numberOfValues-1; i++) {
            if (recordingList[i] == n) {
                index[k] = i;
                k++;
            }
        }
        for (int i = 0; i < numberOfValues-1; i++) {
            if (index[i] >= 0){
                int rind = index[i];
                this.remove(rind);
            }
        }
    }

    /**
     * @return
     */
    public double mean() {
        double sum = 0;
        if (numberOfValues == 1) {
            return 0;
        }
        for(int i = 0; i < numberOfValues-1; i++) {
            sum = sum + recordingList[i];
        }
        return (sum/(numberOfValues-1));
    }

    /**
     * @return
     */
    public double variance() {
        double summation = 0;
        for (int i = 0; i < numberOfValues-1; i++){
            summation = summation + oneValueOfSummation(recordingList[i]);
        }

        if (numberOfValues == 2) {
            return 0;
        }
        else {
            return (summation/(numberOfValues-2));
        }
    }

    /**
     * @param nodeValue
     * @return the summation value
     */
    private double oneValueOfSummation(int indexValue) {
        if (this.mean() > indexValue) {
            double meanindex = this.mean() - indexValue;
            double sqrmeanindex = meanindex * meanindex;
            return (sqrmeanindex);
        }
        else {
            double meanindex = indexValue - this.mean();
            double sqrmeanindex = meanindex * meanindex;
            return (sqrmeanindex);
        }
    }

    /**
     * @param lower
     * @param upper
     * @return
     */
    public ArrayList sublist(int lower, int upper) {
        ArrayList subli = new ArrayList();
        for (int i = 0; i < numberOfValues-1; i++) {
            if ((recordingList[i] > lower) && (recordingList[i] < upper)) {
                subli.add(recordingList[i]);
            }
        }
        return subli;
    }

    /**
     * @return
     */
    public ArrayList removeNoise() { 
        ArrayList subli = new ArrayList();

        if (numberOfValues-1 == 0) {
            return subli;
        }
        else if (numberOfValues-1 == 1) {
            subli.add(recordingList[0]);
            return subli;
        }
        else {
            double mean = this.mean();
            double stddev = Math.sqrt(this.variance());
            double lowerEnd = mean - (3*stddev);
            double highEnd = mean + (3*stddev);
            for (int i = 0; i < numberOfValues-1; i++) {
                if ((recordingList[i] > lowerEnd) && (recordingList[i] < highEnd)) {
                    subli.add(recordingList[i]);
                }
            }
            return subli;
        }
    }

    /**
     * @return the standard deviation of the list of values when summation is divided by N
     */
    public double stddev() {
        double summation = 0;
        if (numberOfValues-1 == 0) {
            return 0;
        }
        else {
            for (int i = 0; i < numberOfValues-1; i++) {
                summation = summation + oneValueOfSummation(recordingList[i]);
            }
            double sqrroot = Math.sqrt(summation/(numberOfValues-1));
            return (sqrroot);
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        for (int i = 0; i < numberOfValues-1; i++) {
            builder.append(recordingList[i]);
            builder.append(' ');
        }
        builder.append("]");
        return builder.toString();
    }
} 