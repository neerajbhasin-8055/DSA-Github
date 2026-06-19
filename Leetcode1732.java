class Leetcode1732{
  
    public int largestAltitude(int[] gain) {
        int[] result = new int[gain.length + 1];
        int max = Integer.MIN_VALUE;
        int i = 1;
        for(int j = 0 ; j < gain.length ; j++){
            result[i] = gain[j] + result[i-1];
            max = Math.max(max,result[i]);
            i++;
        }
        if(max < 0) return 0;
        return max;
        //Hello
    }
}
