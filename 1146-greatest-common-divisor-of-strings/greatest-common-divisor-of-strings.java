class Solution {
    public String gcdOfStrings(String str1, String str2) {
        int n=str1.length(),m=str2.length();

        if(!(str1+str2).equals(str2+str1))
            return "";

        return str1.substring(0,gcd(n,m));
    }

    public int gcd(int a,int b){
        if(b%a==0)
            return a;
        else 
            return gcd(b%a,a);
    }
}