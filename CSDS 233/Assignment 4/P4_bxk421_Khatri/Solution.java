public class Solution{

    // This has a time complexity of O(nlogn)
    public int[][] kClosest(int[][] points, int k) {
        int[] distanceArray = new int[points.length];
        int[][] result = new int[k][2];

        //This for loop records every distance in the int array
        for (int i = 0; i < distanceArray.length; i++){
            distanceArray[i] = (int)Math.round(Math.sqrt(Math.pow(points[i][0] - 233, 2) + Math.pow(points[i][1] - 233, 2)));
        }
        sort(distanceArray, 0, distanceArray.length);

        for (int i = 0; i < distanceArray.length; i++) {
            int distance = (int)Math.round(Math.sqrt(Math.pow(points[i][0] - 233, 2) + Math.pow(points[i][1] - 233, 2)));
            for (int j = 0; j < k; j++) {
                if (distance < distanceArray[j]) {
                    result[i][0] = points[j][0];
                    result[i][1] = points[j][1];
                }
            }

        }
        return result;
    }

    /*
     * This method makes the merging part of the mergesort. It has a time complexity of O(n)
     */
    public void merging(int arr[], int first, int last){

        //This holds the middleIndex value, the left-middle index value, and the right-middle index value.
        //Needed b/c of even values, otherwise it could duplicate the middle value
        int middleIndex = (first + last)/2;
        int middleLeft = middleIndex - first + 1;
        int middleRight = last - middleIndex;


        //This holds the arrays of left and right
        int L[] = new int[middleLeft];
        int R[] = new int[middleRight];

        //This copies the left side of the array
        for (int i = 0; i < middleLeft; ++i) {
            L[i] = arr[first + i];
        }
        //This copies the right side of the array
        for (int j = 0; j < middleRight; ++j){
            R[j] = arr[middleIndex + j];
        }

        //Records the index of left and right added to big array. 
        //K is the first value and it records what place number should be
        int index1 = 0;
        int index2 = 0;
        int k = first;

        //This loops through all of the left and right values
        while ((index1 < middleLeft) && (index2 < middleRight)) {
            if (L[index1] <= R[index2]) {
                arr[k] = L[index1];
                index1++;
            }
            else {
                arr[k] = R[index2];
                index2++;
            }
            k++;
        }

        // Copy remaining elements of left array if any
        while (index1 < middleLeft) {
            arr[k] = L[index1];
            index1++;
            k++;
        }

        // Copy remaining elements of the right array if any
        while (index2 < middleRight-1) {
            arr[k] = R[index2];
            index2++;
            k++;
        }
    }
    /*
     * This is the O(logn) part of the sorting algorithm. This will recurxively sort the left and right half
     * snd the left half until the full array is sorted.
     */
    public void sort(int arr[], int first, int last) {
        int middle = first + (last - first) / 2;

        //This if statement is used to recursively sort both the left and right half (respectiviely)
        if (first < last) {
            sort(arr, first, middle); 
            sort(arr, middle + 1, last);
            merging(arr, first, last);
        }

    }

    public String toString(int[][] makeToStringArray) {
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        for (int row = 0; row < makeToStringArray.length; row++) {
            builder.append("{");
            builder.append(makeToStringArray[row][0]);
            builder.append(",");
            builder.append(makeToStringArray[row][1]);
            builder.append("}");
            builder.append(", ");
        }
        builder.append("]");
        return builder.toString();
    }
}