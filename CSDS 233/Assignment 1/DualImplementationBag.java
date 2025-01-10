import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class DualImplementationBag<T> {
    
    /**
     * A field that determines which type of list is being used
     */
    private boolean useArrayList;

    /**
     * A field that stores the list of elements
     */
    private List<T> internalList;

    /**
     * A field that counts the number of entries
     */
    private int counter;

    /**
     * @param useArrayList
     */
    public DualImplementationBag(boolean useArrayList) {
        this.useArrayList = useArrayList;
        if (useArrayList == false) {
            internalList = new LinkedList<T>();
        }
        else if (useArrayList == true) {
            internalList = new ArrayList<T>();
        }
    }

    /**
     * @param useArrayList
     */
    public void setUseArrayList(boolean useAList) {
        if (useAList == true) {
            ArrayList<T> tempList = new ArrayList<T>();
            for (T i : internalList) {
                tempList.add(i);
            }
            this.useArrayList = true;
            internalList = tempList;
        }
        else {
            LinkedList<T> tempList = new LinkedList<T>();
            for (T i : internalList) {
                tempList.add(i);
            }
            this.useArrayList = false;
            internalList = tempList;
        }
    }

    /**
     * @param element
     * @return whether the element was able to be added or not
     */
    public boolean add(T element) {
        counter = counter + 1;
        internalList.add(element);
        return true;
    }

    /**
     * @param element
     * @return whether the element was able to be removed or not
     */
    public boolean remove(T element) {
        counter = counter - 1;
        return (internalList.remove(element));
    }

    /**
     * @param element
     * @return whether the value is contained or not
     */
    public boolean contains(T element) {
        for (T i : internalList) {
            if (i == element) {
                return true;
            }
        }
        return false;
    }

    /**
     * @return if the bag is empty or not
     */
    public boolean isEmpty() {
        return counter == 0;
    }

    /**
     * @return the size of the array
     */
    public int size() {
        int size = 0;
        for (T i : internalList) {
            size = size + 1;
        }
        return size;
    }

    /**
     * @param element
     * @return the amount of times the element appears
     */
    public int getFrequencyOf(T element) {
        int elementNumber = 0;
        for (T i : internalList) {
            if (i == element) {
                elementNumber = elementNumber + 1;
            }
            else {
                elementNumber = elementNumber + 0;
            }
        }
        return elementNumber;
    }

    /**
     * @param index
     * @return the value of the index
     */
    public T get(int index) {return internalList.get(index); }

    public static void main(String[] args){
	}

}
