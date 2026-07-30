class Solution {
    public int findShortestSubArray(int[] nums) {
        int max=0;
        HashMap<Integer,Integer> map = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();

        for(int i: nums){
            list.add(i);
            map.put(i,map.getOrDefault(i,0)+1);
            if((int)map.get(i)>max)
                max=map.get(i);
        }

        int min = Integer.MAX_VALUE;

        for(Map.Entry m: map.entrySet()){
            if((int)m.getValue()==max){
                int num = (int)m.getKey();
                int n1 = list.indexOf(num);
                int n2 = list.lastIndexOf(num);
                if(n2-n1+1<min)
                    min=n2-n1+1;
            }
        }
        
        return min;
    }
}