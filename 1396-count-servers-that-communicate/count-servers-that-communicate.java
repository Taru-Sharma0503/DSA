class Solution {
    public int countServers(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int[] rowCount = new int[row];
        int[] colCount = new int[col];


        for(int r =0 ; r<row ; r++){
            for(int c=0;c<col;c++){
                if(grid[r][c]==1){
                    rowCount[r]++;
                    colCount[c]++;
                }

            }
        }
        int result =0;
        for(int r =0 ; r<row ; r++){
            for(int c=0;c<col;c++){
                if(grid[r][c] ==1 && (rowCount[r]>1 || colCount[c]>1)){
                    result++;
                }

            }
        }
        return result;
        
    }
}