class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int L = 0;
        int R = 1;
        while (R < nums.length) {
            if (nums[L] != nums[R]) {
                L++;
                nums[L] = nums[R];
            }
            R++;
        }
        return L+1;
    }
}