class Solution {
    public int compress(char[] chars) {
        int n = chars.length, idx = 0,arrIdx=0;

        while (idx < n) {
            int grp = 1;
            idx += 1;

            while (idx > 0 && idx < n && chars[idx] == chars[idx - 1]) {
                idx++;
                grp++;
            }

            if (grp == 1){
                chars[arrIdx++]=chars[idx-1];
            }
            else{
                chars[arrIdx++]=chars[idx-1];
                String number=Integer.toString(grp);
                
                for(int i=0;i<number.length();i++)
                    chars[arrIdx++]=number.charAt(i);
            }
               
        }

        return arrIdx;
    }
}