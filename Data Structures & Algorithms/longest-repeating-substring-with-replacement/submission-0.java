class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int maxLength = 0;
        int maxFreq = 0;
        int l = 0;

        for (int r = 0; r < s.length(); r++) {
            char curr = s.charAt(r);
            map.put(curr, map.getOrDefault(curr, 0) + 1);
            maxFreq = Math.max(maxFreq, map.get(curr));
            while ((r - l + 1) - maxFreq > k) {
                char left = s.charAt(l);
                map.put(left, map.get(left) - 1);
                l++;
            }
            maxLength = Math.max(maxLength, r - l + 1);
        }
        return maxLength;
    }
}
