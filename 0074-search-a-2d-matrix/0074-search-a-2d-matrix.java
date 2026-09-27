class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int elements = matrix[0].length;
        int total = matrix.length * matrix[0].length;
        int l = 0, r = total - 1;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            int row = mid / elements;
            int col = mid % elements;

            if (matrix[row][col] == target) {
                return true;
            } else if (l == r && matrix[row][col] != target) {
                break;
            } else if (matrix[row][col] > target) {
                r = mid - 1;
            } else if (matrix[row][col] < target) {
                l = mid + 1;
            }
        }

        return false;
    }
}