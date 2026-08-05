class Solution {
    public int findMin(int[] nums) {
       int len=nums.length,s=0,e=len-1,m,min=nums[0];
       while(s<=e){
        m=s+(e-s)/2;
        if(nums[m]==nums[e]){
            min=nums[m];
            break;
        }
        else if(nums[m]>nums[e]){
            s=m+1;
        }
        else{
            if(m!=0 && nums[m-1]<nums[m]){
                e=m-1;
            }
            else{
                min=nums[m];
                break;
            }
        }
       }
       return min;
    }
}