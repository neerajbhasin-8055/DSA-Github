class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n-k+1];
        Deque<Integer> dq = new ArrayDeque<>();
        int resP = 0 ;
        int left = 0 ;
        for(int right  = 0 ; right < n ; right++){
            while(!dq.isEmpty() && nums[dq.peekLast()] < nums[right]){
                dq.removeLast();
            }
            dq.addLast(right);

            if(right - left + 1 == k){
                res[resP++] = nums[dq.peekFirst()];
                if(dq.peekFirst() == left){
                    dq.removeFirst();
                }
                left++;
            }
        }
    return res;
    }
}