class maxConsecutiveOnes{
    public int longestOnes(int[] nums, int k) {
        int max = 0;
        int i = 0 ;
        int zeroes = 0;
        for(int j = 0; j < nums.length ; j++){
            if(nums[j] == 0) zeroes++;
            while(zeroes>k){
                if(nums[i] == 0) zeroes--;
                i++;
            }
            max = Math.max(max,j-i+1);
        }
        return max;
    }
}