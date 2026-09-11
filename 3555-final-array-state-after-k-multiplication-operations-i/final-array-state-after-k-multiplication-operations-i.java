class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> {
                if (a[0] != b[0])
                    return a[0] - b[0];
                return a[1] - b[1];
        });

        for(int i=0;i<nums.length;i++)
            pq.add(new int[]{nums[i],i});

        while(k>0){
            int[] element=pq.poll();
            nums[element[1]]=nums[element[1]]*multiplier;
            pq.add(new int[]{nums[element[1]],element[1]});
            k--;
        }

        return nums;
    }
}