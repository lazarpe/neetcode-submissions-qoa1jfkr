class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // top left: matrix[0][0]
        // bottom left: matrix[matrix.length - 1][0]

        int l = 0;
        int r = matrix.length - 1;
        int m = 0;
        int gigaRow = 0;

        // find the right row to do bs in:
        while (l <= r) {
            m = (l + r) / 2;
            if (matrix[m][0] < target) {
                if (target <= matrix[m][matrix[m].length - 1]) {
                    // its in this row! do bs here
                    gigaRow = m;
                    break;
                } else {
                    // move l: 1 row below m
                    l = m + 1;
                }
            } else if (matrix[m][0] > target) {
                // move r: 1 row above row m
                r = m - 1;
            } else {
                return true;
            }
        }

        int left = 0;
        int right = matrix[gigaRow].length - 1;
        int med = 0;
        // do bs in gigaRow:
        while (left <= right) {
            med = (left + right) / 2;
            if (matrix[gigaRow][med] > target) {
                right = med - 1; 
            } else if (matrix[gigaRow][med] < target) {
                left = med + 1;
            } else {
                return true;
            }
        }

        // if we land here target not found:
        return false;
    }
}
