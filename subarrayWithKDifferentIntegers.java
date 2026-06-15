import java.util.HashMap;

class subarrayWithKDifferentIntegers{
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atMost(nums,k) - atMost(nums,k-1);
    }

    public int atMost(int[] nums, int k) {
        int left = 0;
        int cnt = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int right = 0; right < nums.length; right++) {
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);
            while (map.size() > k) {
               int count = map.getOrDefault(nums[left],0)-1;
               map.put(nums[left],count);
               if(count <= 0){
                map.remove(nums[left]);
               }
               left++;
            }
            if (map.size() <= k) {
                cnt += right - left + 1;
            }
        }
        return cnt;
    }
}
