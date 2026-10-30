class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n=grid.length;
        int freq[]=new int[n*n+1];
        int ans[]=new int[2];

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                freq[grid[i][j]]++;

                if(freq[grid[i][j]]==2)
                    ans[0]=grid[i][j];
            }
        }

        for(int i=1;i<=n*n;i++){
            if(freq[i]==0){
                ans[1]=i;
                break;
            }
        }

        return ans;
    }
}