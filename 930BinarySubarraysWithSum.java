class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        return atMost(nums,goal) - atMost(nums,goal-1);
    }

    public int atMost(int[] arr, int goal){
        int left = 0 ;
        int count = 0;
        int sum = 0;
        for(int right = 0 ; right < arr.length ; right++){
            sum += arr[right];
            while(sum > goal && left <= right){
                sum-=arr[left];
                left ++;
            }
            count += right - left + 1;
        }
        return count ;
    }
}