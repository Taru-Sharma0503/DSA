class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int n=nums.length,ans=0,sum=0,left=0,right=0;
        int pos[]=new int[10001];

        Arrays.fill(pos,-1);

        while(right<n){
            int num=nums[right];
            if(pos[num]==-1){
                pos[num]=right;
                sum+=num;
                right++;
            }
            else {
                int idx=pos[num];
                ans=Math.max(ans,sum);
                while(left<idx+1){
                    sum-=nums[left];
                    pos[nums[left]]=-1;
                    left++;
                }
                sum+=num;
                pos[num]=right;
                right++;
            }
        }

        return Math.max(ans,sum);
    }
}