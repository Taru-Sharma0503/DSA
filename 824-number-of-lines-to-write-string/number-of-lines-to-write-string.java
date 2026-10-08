class Solution {
    public int[] numberOfLines(int[] widths, String s) {
        int lines=1,width=0;

        for(char ch:s.toCharArray()){
            int required=widths[ch-'a'];
            if(required+width<=100){
                width+=required;
            }
            else{
                width=required;
                lines++;
            }
        }

        return new int[]{lines,width};
    }
}