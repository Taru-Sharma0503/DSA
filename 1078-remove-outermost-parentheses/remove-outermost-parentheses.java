class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder ans= new StringBuilder();
        char c;
        int len=s.length(),i,count=0;
        for(i=0;i<len;i++){
            c=s.charAt(i);
            if(c=='('){
                if(count>0){
                    ans.append(c);
                }
                count++;
            }
            else{
                count--;
                if(count>0){
                    ans.append(c);
                }
            }
        }
        return ans.toString();
    }
}