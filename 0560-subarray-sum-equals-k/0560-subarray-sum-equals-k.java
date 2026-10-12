class Solution {
    public int subarraySum(int[] nums, int k) {
        int totalCount = 0 ;
        Map<Integer,Integer> prefixMap = new HashMap<>();
        int sum = 0 ;
        prefixMap.put(0,1);
        for(int num : nums){
            sum += num;
            if(prefixMap.containsKey(sum-k)){
                totalCount += prefixMap.get(sum-k);
            }
            prefixMap.put(sum,prefixMap.getOrDefault(sum,0)+1);
        }
        return totalCount;
    }
}