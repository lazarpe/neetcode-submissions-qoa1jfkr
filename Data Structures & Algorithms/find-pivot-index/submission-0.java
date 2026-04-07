class Solution {
    public int pivotIndex(int[] nums) {
        // Walk through every single index to test if it's the pivot
        for (int i = 0; i < nums.length; i++) {
            
            // Does the literal left side equal the literal right side?
            if (getLeft(nums, i) == getRight(nums, i)) {
                return i;
            }
        }
        return -1; // No pivot found
    }

    // Helper: Add up everything from index 0 up to (but not including) i
    int getLeft(int[] nums, int i) {
        int sum = 0;
        for (int j = 0; j < i; j++) {
            sum += nums[j]; 
        }
        return sum;
    }

    // Helper: Add up everything from index i+1 up to the very end
    int getRight(int[] nums, int i) {
        int sum = 0;
        for (int j = i + 1; j < nums.length; j++) {
            sum += nums[j];
        }
        return sum;
    }
}