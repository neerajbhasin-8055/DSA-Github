class NiceSubarrays{
    
    public int numberOfSubarrays(int[] nums, int k) {
        int oddCount =0 ;
        Map<Integer,Integer> pref = new HashMap<>();
        pref.put(0,1);
        int res = 0;
        for(int num : nums){
            if( num%2 == 1 ) oddCount++;
            if(pref.containsKey(oddCount-k)){
                res += pref.get(oddCount-k);
            }
            pref.put(oddCount,pref.getOrDefault(oddCount,0)+1);
        }
        return res;
    }
}
