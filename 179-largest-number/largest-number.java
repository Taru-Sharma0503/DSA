class Solution {
    public String largestNumber(int[] nums) {
        int n=nums.length;
        StringBuilder ans=new StringBuilder();
        boolean nonZero=false;
        String num[]=new String[n];

        for(int i=0;i<n;i++){
            num[i]=Integer.toString(nums[i]);
            if(nums[i]!=0)
                nonZero=true;
        }

        if(!nonZero)
            return "0";

        Arrays.sort(num, (a, b) -> (b + a).compareTo(a + b));

        for(int i=0;i<n;i++)
            ans.append(num[i]);

        return ans.toString();
    }
}