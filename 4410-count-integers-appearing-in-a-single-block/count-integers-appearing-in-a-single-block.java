class Solution {
    public int countSpecialIntegers(int[] nums) {
        int ans=0;
        int[] count=new int[101];

        for(int i=0;i<nums.length;i++){
            int num=nums[i];
            if(count[num]==-1)
                continue;
            
            else if(count[num]==0){
                count[num]=1;
                ans++;
            }

            else{
                if(nums[i-1]!=num){
                    count[num]=-1;
                    ans--;
                }
            }
        }

        return ans;
    }
}