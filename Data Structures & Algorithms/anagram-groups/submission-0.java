class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        // Loop through each word
        
        for (String str : strs) {
            // Sort each by letters
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sorted = new String(chars);
            // if: sorted does not exists in hashmap as key
            // - add sorted as key plus orig as new str array in val
            if (!map.containsKey(sorted)) {
                map.put(sorted, new ArrayList<>());
            }
            map.get(sorted).add(str);
        } 
        // Loop through hashmap, return array with strs by same keys
        List<List<String>> out = new ArrayList<>();
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            out.add(entry.getValue());
        }
        return out;
    }
}
