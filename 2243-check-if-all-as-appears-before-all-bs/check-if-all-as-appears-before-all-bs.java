class Solution {
    public boolean checkString(String s) {
        boolean bAppeared=false;

        for(char ch:s.toCharArray()){
            if(ch=='a' && bAppeared)
                return false;
            if(ch=='b') bAppeared=true;
        }

        return true;
    }
}