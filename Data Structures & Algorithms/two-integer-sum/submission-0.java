class Solution {
    public int[] twoSum(int[] in, int target) {
        HashMap<Integer, Integer> m = new HashMap<>();
        int[] out = new int[2];
        for (int i = 0; i < in.length; i++) {
            int complement = target - in[i];
            if (m.containsKey(complement)) {
                out[0] = m.get(complement);
                out[1] = i;
                return out;
            }  else {
                m.put(in[i], i);
            }
        }
        return out;

        /*int out[] = new int[2];
        int i = 0;
        int j = 1;

        while (i < in.length - 1 && j < in.length) {
            if (in[i] + in[j] == target) {
                out[0] = i;
                out[1] = j;
                return out;
            } else if (j == in.length - 1) {
                i++;
                j = i+1;
            } else {
                j++;
            }
        } 
        return out;*/
    }
}
