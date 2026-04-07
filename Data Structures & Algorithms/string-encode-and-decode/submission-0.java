class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            sb.append(s.length()).append("#").append(s);
        }
        return sb.toString();
    }

    public List<String> decode(String s) {
        List<String> result = new ArrayList<>();
        int i = 0;
        
        while (i < s.length()) {
            // 1. Find the next '#' starting from i
            int j = s.indexOf("#", i);
            
            // 2. Grab the number before the '#' to get the length
            int len = Integer.valueOf(s.substring(i, j));
            
            // 3. Scoop up the actual word using that length
            String word = s.substring(j + 1, j + 1 + len);
            
            // 4. Add it to our list
            result.add(word);
            
            // 5. Jump the pointer exactly to the start of the next number
            i = j + 1 + len;
        }
        
        return result;
    }
}
