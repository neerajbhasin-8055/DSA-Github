class CountGoodNumbers{
    
    long MOD = 1000000000+7;
    public int countGoodNumbers(long n) {
        long even = (n+1)/2;
        long odd = n/2;
        long evenChoices = mathPow(5,even);
        long oddChoices = mathPow(4,odd);
        long res = (evenChoices*oddChoices)%MOD;
        return (int)(res % MOD);
    }
    public long mathPow(long num, long pow){
        if(pow==0)return 1;
        long half = mathPow(num,pow/2);
        if(pow%2 == 0){
            return (half * half)%MOD;
        }else{
            return (num*((half*half)%MOD))%MOD;
        }
    } 

}
