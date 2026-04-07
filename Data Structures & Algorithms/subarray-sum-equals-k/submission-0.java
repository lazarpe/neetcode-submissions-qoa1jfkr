class Solution {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int[] prefixSum = new int[nums.length];
        prefixSum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            prefixSum[i] = prefixSum[i-1] + nums[i]; 
        }

        for (int l = 0; l < nums.length; l++) {
            for (int r = l; r < nums.length; r++) {
                int currSum;
                if (l == 0) {
                    currSum = prefixSum[r];
                } else {
                    currSum = prefixSum[r] - prefixSum[l-1];
                }
                if (currSum == k) count++;
            }
        }
        return count;
    }
}