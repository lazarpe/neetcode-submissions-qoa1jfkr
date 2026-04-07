class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l = 0;
        int len = 0;
        Set<Character> list = new HashSet<>();
        char[] arr = s.toCharArray();
        
        for (int r = 0; r < arr.length; r++) {
            while (list.contains(arr[r])) {
                list.remove(arr[l]);
                l++;
            }
            list.add(arr[r]);
            len = Math.max(len, r - l + 1);
        }
        return len;
    }
}
