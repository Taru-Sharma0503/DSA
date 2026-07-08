class Solution {
    List<List<Integer>> subsets=new ArrayList<>();

    public int subsetXORSum(int[] nums) {
        getSubsets(0,nums,new ArrayList<>());
        int sum=0,xor=0;
        
        for(int i=0;i<subsets.size();i++){
            List<Integer> subset=subsets.get(i);
            xor=0;
            for(int j=0;j<subset.size();j++){
                xor^=subset.get(j);
            }
            sum+=xor;
        }

        return sum;
    }

    public void getSubsets(int index,int[] nums,List<Integer> curr){
        if(index==nums.length){
            subsets.add(new ArrayList<>(curr));
            return;
        }

        curr.add(nums[index]);
        getSubsets(index+1,nums,curr);

        curr.remove(curr.size()-1);
        getSubsets(index+1,nums,curr);
    }
}