class Solution {
    public int reverse(int x) {
        int rev=0,digit,count=0;
        if(x<0){
            count=1;
            x=-x;
        }
        while(x>0){
            digit=x%10;
            x=x/10;
            if(rev>Integer.MAX_VALUE/10 || rev<Integer.MIN_VALUE/10 || (rev==Integer.MAX_VALUE/10 && digit>7) || (rev==Integer.MIN_VALUE/10 && digit<-8)){
                return 0;
            }
            rev=rev*10+digit;
        }
        if(count==0)
        return rev;
        else
        return -rev;
    }
}