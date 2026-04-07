class Solution {
    public boolean isValid(String s) {
        if (s == null || s.isEmpty() || s.length() % 2 > 0) {
            return false;
        }
        char[] arr = new char[s.length()];
        int top = 0;
        for (char c : s.toCharArray()) {
            switch (c) {
                case '{': 
                    arr[top++] = '}';
                    break;
                case '[':
                    arr[top++] = ']';
                    break;
                case '(':
                    arr[top++] = ')';
                    break;
                default: 
                    if (top == 0 || arr[--top] != c) { 
                        return false;
                    }
            }
        }
        return top == 0;
    }
}
