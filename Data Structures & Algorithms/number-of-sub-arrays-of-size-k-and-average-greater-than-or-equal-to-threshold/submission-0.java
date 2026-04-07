class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int out = 0;
        int l = 0;
        int currSum = 0;
        
        // We need the sum to be at least this much to meet the threshold
        int targetSum = k * threshold;

        for (int r = 0; r < arr.length; r++) {
            currSum += arr[r];

            // If window size is too large, shrink from the left
            if (r - l + 1 > k) {
                currSum -= arr[l];
                l++;
            }

            // If we have a full window of size k, check the sum
            if (r - l + 1 == k) {
                if (currSum >= targetSum) {
                    out++;
                }
            }
        }
        
        return out;
    }
}