class Solution {
    public long gcdSum(int[] nums) {
        int[] prefGcd = new int[nums.length];
        int max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(nums[i], max);
            prefGcd[i] = gcd(nums[i], max);

        }
        Arrays.sort(prefGcd);
        int i = 0;
        int j = prefGcd.length - 1;
        long sum = 0;
        while (i < j) {
            sum = sum + gcd(prefGcd[i], prefGcd[j]);
            System.out.println(sum);
            i++;
            j--;
        }
        return sum;
    }

    public int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}