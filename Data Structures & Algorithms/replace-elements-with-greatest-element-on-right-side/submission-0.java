class Solution {
    public int[] replaceElements(int[] arr) {
        int[] out = new int[arr.length];
        int curr = 0;
        for (int i = 0; i < arr.length-1; i++) {
            int curr_max = arr[i+1];
            for (int j = i+1; j < arr.length; j++) {
                if (curr_max < arr[j]) {
                    curr_max = arr[j];
                }
            }
            out[i] = curr_max;
        }
        out[arr.length - 1] = -1;
        return out;
    }
}