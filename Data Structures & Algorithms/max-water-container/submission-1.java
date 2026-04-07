class Solution {

    // while left index < right index
    // start leftIndex, and rightIndex
    // set currMaxAmount = height * width
        // width = rightIndex - leftIndex
        // height = Math.min(heights[rightIndex], heights[leftIndex]);
    // compare left and right index height and from smaller one move away

    /* 
        left = 0
        right = 7
        maxAmount = 1 * (7 - 0) = 7
        --
        left = 1
        right = 7
        currMax = 6 * (7 - 1) = 36
        maxAmount = 36
    */
    public int maxArea(int[] heights) {
        int left = 0;
        int right = heights.length - 1;
        int maxAmount = 0;

        while (left < right) {
            int currMax = 0;
            int leftHeight = heights[left];
            int rightHeight = heights[right];
            
            if (left == 0 && right == heights.length - 1) {
                maxAmount = Math.min(leftHeight, rightHeight) * (right - left);
            } else {
                currMax = Math.min(leftHeight, rightHeight) * (right - left);
                if (currMax > maxAmount) {
                    maxAmount = currMax;
                }
            }
            if (leftHeight < rightHeight) {
                left++;
            } else {
                right--;
            }
        }    
        return maxAmount;    
    }
}
