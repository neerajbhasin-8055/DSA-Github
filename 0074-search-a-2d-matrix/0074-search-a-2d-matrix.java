class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int low = 0; 
        int high = (matrix.length * matrix[0].length)-1;
        while(low<=high){
            int mid = (low+high) / 2;
            int ele = matrix[mid/matrix[0].length][mid%matrix[0].length];
            if(ele == target){
                return true;
            }else if(ele > target){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return false;
    }
}