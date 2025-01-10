import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

public class DemoBag<T>{
    
    /**
     * Removes all of occurances of element
     * @param bag
     * @param element
     */
    public void removeAll(DualImplementationBag<T> bag, T element){
        int sizeOfBag = bag.size();
        for (int i = 0; i <= sizeOfBag; i++) {
            if (bag.contains(element) == true) {
                bag.remove(element);
            }
        }
    }

    /**
     * Keeps all element occurances
     * @param bag
     * @param element
     */
    public void retainAll(DualImplementationBag<T> bag, T element) {
        int sizeOfBag = bag.size();
        List<T> deleteList = new LinkedList<T>();
        for (int i = 0; i < sizeOfBag; i++) {
            if (bag.get(i) != element){
                deleteList.add(bag.get(i));
            }
        }
        for (int i = 0;  i < deleteList.size(); i++){
            bag.remove(deleteList.get(i));
        }
    }

    /**
     * 
     * @param otherBag1
     * @param otherBag2
     * @return the unioned bag
     */
    public DualImplementationBag<T> union(DualImplementationBag<T> otherBag1, DualImplementationBag<T> otherBag2) {
        DualImplementationBag<T> unionedList = new DualImplementationBag<T>(true);
        for (int i = 0; i < otherBag1.size(); i++){
            unionedList.add(otherBag1.get(i));
        }
        for (int i = 0; i < otherBag2.size(); i++) {
            unionedList.add(otherBag2.get(i));
        }
        return unionedList;
    }

    /**
     * @param otherBag1
     * @param otherBag2
     * @return the intersection between the two bags (common values)
     */
    public DualImplementationBag<T> intersection (DualImplementationBag<T> otherBag1, DualImplementationBag<T> otherBag2) {
        DualImplementationBag<T> intersectionList = new DualImplementationBag<T>(true);
        for (int i = 0; i < otherBag1.size(); i++) {
            for (int j = 0; j < otherBag2.size(); j++) {
                if (otherBag1.get(i) == otherBag2.get(j)) {
                    intersectionList.add(otherBag1.get(i));
                }
            }
        }
        return intersectionList;
    }

    /**
     * @param otherBag1
     * @param otherBag2
     * @return the difference between the two bags
     */
    public DualImplementationBag<T> difference(DualImplementationBag<T> otherBag1, DualImplementationBag<T> otherBag2) {
        DualImplementationBag<T> differenceList = new DualImplementationBag<T>(true);
        boolean newValue;
        for (int i = 0; i < otherBag1.size(); i++) {
            newValue = true;
            if (otherBag2.contains(otherBag1.get(i))){
                newValue = false;
            }
            else {
                differenceList.add(otherBag1.get(i));
            }
        }
        for (int i = 0; i < otherBag2.size(); i++) {
            newValue = true;
            if (otherBag1.contains(otherBag2.get(i))){
                newValue = false;
            }
            else {
                differenceList.add(otherBag2.get(i));
            }
        }
        return differenceList;
    }

    public static void main(String[] args){

    }

}
