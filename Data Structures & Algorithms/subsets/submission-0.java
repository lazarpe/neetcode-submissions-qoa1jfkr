class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> out = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        helper(0, out, subset, nums);
        return out;
    }

    private void helper(int i, List<List<Integer>> out, List<Integer> subset, int[] nums) {
        // base case
        if (i >= nums.length) {
            out.add(new ArrayList<>(subset));
            return;
        }
        // append it
        subset.add(nums[i]);
        helper(i + 1, out, subset, nums);
        subset.remove(subset.size() - 1);
        // dont append
        helper(i + 1, out, subset, nums);
    }
}
