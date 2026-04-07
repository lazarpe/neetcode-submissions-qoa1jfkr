class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] out = new int[nums.length];
        int total = 1;
        int zeroCount = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeroCount++;
            } else {
                total *= nums[i];
            }
        }
    
        if (zeroCount > 1) return out;
    
        for (int i = 0; i < nums.length; i++) {
            if (zeroCount == 1) {
                if (nums[i] == 0) {
                    out[i] = total;
                } else {
                    out[i] = 0;
                }
            } else {
                out[i] = total / nums[i];
            }
        }
        return out;
    }
}  
