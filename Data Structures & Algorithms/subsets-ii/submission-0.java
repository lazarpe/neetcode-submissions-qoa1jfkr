class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> out = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        helper(0, out, subset, nums);
        return out;
    }

    private static void helper(
        int i, 
        List<List<Integer>> out, 
        List<Integer> subset, 
        int[] nums) {
            if (i >= nums.length) {
                out.add(new ArrayList<>(subset));
                return;
            }
            // decision tree:
            // A - append:
            subset.add(nums[i]);
            helper(i + 1, out, subset, nums);
            subset.remove(subset.size() - 1);
            // B - dont append: 
            while (i + 1 < nums.length && nums[i] == nums[i + 1]) {
                i++;
            }
            helper(i + 1, out, subset, nums);
    }
}
