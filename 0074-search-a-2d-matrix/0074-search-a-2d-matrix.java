class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int i = 0 ;
        int j = n - 1;
        while( i < m && j >= 0){
            int ele = matrix[i][j];
            if(ele == target){
                return true;
            }
            if(ele < target){
                i++;
            }else{
                j--;
            }
        }
        return false;
    }
}
