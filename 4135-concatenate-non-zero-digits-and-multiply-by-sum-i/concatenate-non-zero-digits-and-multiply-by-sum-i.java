class Solution {
    public long sumAndMultiply(int n) {
        long sum=0,x=0;
        int count=0;

        while(n>0){
            int digit=n%10;
            n/=10;
            if(digit!=0){
                x=digit*(long)Math.pow(10,count)+x;
                count++;
            }
            sum+=digit;
        }

        return sum*x; 
    }
}