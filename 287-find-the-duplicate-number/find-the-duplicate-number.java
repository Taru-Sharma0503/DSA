class Solution {
    public int findDuplicate(int[] nums) {
        int n=nums.length;
        int freq[]=new int[n+1];

        for(int i=0;i<n;i++){
            if(freq[nums[i]]!=0)
                return nums[i];
            freq[nums[i]]++;
        }

        return -1;
    }
}