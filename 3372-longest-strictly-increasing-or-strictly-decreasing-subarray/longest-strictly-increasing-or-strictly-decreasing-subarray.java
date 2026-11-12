class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int n=nums.length,s=0,e=0,ans=0;
        boolean increasing;
        if(n==1)
            return 1;

        increasing=nums[0]>nums[1]?true:false;
        while(e<n-1){
            if(nums[e]==nums[e+1]){
                ans=Math.max(ans,e-s+1);
                while(e<n-1 && nums[e]==nums[e+1])
                    e++;
                s=e;
            }

            else if(e<n-1 && ((increasing && nums[e]>nums[e+1]) || (!increasing && nums[e]<nums[e+1])))
                e++;
            
            else{
                ans=Math.max(ans,e-s+1);
                increasing=!increasing;
                s=e;
                e++;
            }
        }

        ans=Math.max(ans,e-s+1);
        return ans;
    }
}