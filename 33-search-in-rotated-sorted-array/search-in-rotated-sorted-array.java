class Solution {
    public int search(int[] nums, int target) {
        int s=0,e=nums.length-1,m,ans=-1;
        while(s<=e){
            m=s+(e-s)/2;
            if(nums[m]==target){
                ans=m;
                break;
            }
            else if(nums[s]<=nums[m]){
                if(nums[s]<=target && target<nums[m]){
                    e=m-1;
                }
                else{
                    s=m+1;
                }
            }
            else{
                if(nums[m]<target && target<=nums[e]){
                    s=m+1;
                }
                else{
                    e=m-1;
                }
            }
        }
        return ans;
    }
}