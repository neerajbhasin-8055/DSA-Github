class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        if(nums.length == 0 ){
            return 0;
        }
        int j = 0;
        int min = Integer.MAX_VALUE;
        int sum = 0;
        for(int i = 0 ; i < nums.length ; i++){
            sum += nums[i];
            while(sum >= target){
                min = Math.min(min,i-j+1);
                if(min == 1){
                    return 1;
                }
                sum -= nums[j];
                j++;
            }
        }
        if(min == Integer.MAX_VALUE ){
            return 0;
        }
        return min;
    }
}