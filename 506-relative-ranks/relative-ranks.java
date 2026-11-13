class Solution {
    public String[] findRelativeRanks(int[] score) {
        int n=score.length;
        String[] result=new String[n];  
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->b[0]-a[0]);

        for(int i=0;i<n;i++){
            pq.add(new int[]{score[i],i});
        }

        int count=1;
        while(!pq.isEmpty()){
            int[] arr=pq.poll();
            int index=arr[1];

            if(count==1){
                result[index]="Gold Medal";
            }
            else if(count==2){
                result[index]="Silver Medal";
            }
            else if(count==3){
                result[index]="Bronze Medal";
            }
            else{
                result[index]=Integer.toString(count);
            }
            count++;
        }

        return result;
    }
}