class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for(int i = 0 ; i < nums.length ; i++){
            if(i > 0 && nums[i-1] == nums[i]){
                continue;
            }
            for(int l = nums.length -1 ; l >= i+3 ; l--){
                if(l < nums.length - 1 && nums[l] == nums[l+1]){
                    continue;
                }
                int j = i + 1;
                int k = l - 1;
                while( j < k){
                    long sum = (long) nums[i]+ nums[j] + nums[k] + nums[l];
                    if(sum == target){
                        result.add(new ArrayList<>(List.of(nums[i],nums[j],nums[k],nums[l])));
                        j++;
                        k--;
                        while( j < k && nums[j-1] == nums[j]){
                            j++;
                        }
                        while(j < k && nums[k] == nums[k+1]){
                            k--;
                        }
                    }
                    else if(sum < target){
                        j++;
                    }else if(sum > target){
                        k--;
                    }
                }
            }
        }
        return result;
    }
}