public class Binary{

    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        // This runs on the assumption that the array is not rotated (or has rotated a full circle)
        if (nums[left] <= nums[right]) {
            return nums[left];
        }

        // This runs for any other scenario
        while (left < right) {
            int mid = left + (right - left) / 2;

            // Check if mid is the minimum element (since the array rotates to the right)
            if (nums[mid] > nums[mid + 1]) {
                return nums[mid + 1];
            }

            // This if statement checks which half of the array the minimum is at
            if (nums[mid] >= nums[left]) { // If this is true, the minimum is on the right
                left = mid + 1;
            }
            else { //Otherwise, the minimum is on the left
                right = mid;
            }
        }

        // This is purely because the method needs a return outside of the while loop, it should never be used
        return -100000;
    }

    /*
    public int findMin(int[] nums) {
        return findMinRecursive(nums, 0, nums.length - 1);
    }

    private int findMinRecursive(int[] nums, int left, int right) {

        //If the array is not rotated, the first element is the minimum
        if (nums[left] < nums[right]) {
            return nums[left];
        }

        //If the two pointers are at the same place, the minimum is that value
        if (left == right) {
            return nums[left];
        }

        int mid = left + (right - left) / 2;

        // If the middle element is greater than the furtherest right element, 
        //the minimum lies to the right
        if (nums[mid] > nums[right]) {
            return findMinRecursive(nums, mid + 1, right);
        } 
        // If the middle element is less than or equal to the furtherest right element, 
        //the minimum lies to the left or at mid
        else {
            return findMinRecursive(nums, left, mid);
        }
    }
    */
}