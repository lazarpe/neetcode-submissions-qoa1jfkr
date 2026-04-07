class Solution {
    public int[] productExceptSelf(int[] nums) {
        //int[] pre = new int[nums.length];
        //int[] post = new int[nums.length];
        int[] out = new int[nums.length];

        // 1. prefix products
        //pre[0] = 1;
        out[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            //pre[i] = pre[i - 1] * nums[i - 1];
            out[i] = out[i - 1] * nums[i - 1];
        }

        // 2. suffix products
        // post[nums.length - 1] = 1;
        int right = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            //post[i] = post[i + 1] * nums[i + 1];
            out[i] = out[i] * right;
            right *= nums[i];
        }

        // 3. multiply products
        /*
        for (int i = 0; i < nums.length; i++) {
            out[i] = pre[i] * post[i];
        }*/
        return out;
    }

/*
    public int[] productExceptSelf(int[] nums) {
        int[] out = new int[nums.length];
        int total = 1;
        int zeroCount = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeroCount++;
            } else {
                total *= nums[i];
            }
        }
    
        if (zeroCount > 1) return out;
    
        for (int i = 0; i < nums.length; i++) {
            if (zeroCount == 1) {
                if (nums[i] == 0) {
                    out[i] = total;
                } else {
                    out[i] = 0;
                }
            } else {
                out[i] = total / nums[i];
            }
        }
        return out;
    } */
}  
