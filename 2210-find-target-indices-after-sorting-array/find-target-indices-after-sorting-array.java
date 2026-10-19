class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        List<Integer> ans=new ArrayList<>();
        Arrays.sort(nums);

        for(int i=0;i<nums.length;i++){
            int num=nums[i];
            if(num==target){
                ans.add(i);
            }
        }

        return ans;
    }
}