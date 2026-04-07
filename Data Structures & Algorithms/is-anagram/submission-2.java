class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        char[] temp = new char[s.length()];
        char[] temp1 = new char[t.length()];

        for (int i = 0; i < s.length(); i++) {
            temp[i] = s.charAt(i);
            temp1[i] = t.charAt(i);
        }        
        Arrays.sort(temp);
        Arrays.sort(temp1);

        return new String(temp).equals(new String(temp1));
    }
}
