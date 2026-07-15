class Solution {
    public String addStrings(String num1, String num2) {
        int len1=num1.length(),len2=num2.length(),idx1=len1-1,idx2=len2-1,carry=0;
        StringBuilder ans=new StringBuilder();
        char ch1,ch2;

        while(idx1>=0 || idx2>=0){
            if(idx1>=0)
                 ch1=num1.charAt(idx1--);
            else
                 ch1='0';

            if(idx2>=0)
                 ch2=num2.charAt(idx2--);
            else
                 ch2='0';

            int digit1=ch1-'0';
            int digit2=ch2-'0';
            int sum=carry+digit1+digit2;
            carry=sum/10;
            ans.insert(0,sum%10);
        }

        if(carry>0)
            ans.insert(0,Integer.toString(carry));
        return ans.toString();
    }
}