class Solution {
    public String maxSumOfSquares(int num, int sum) {
        StringBuilder ans = new StringBuilder();
        int ansSum=0,checkSum=sum;

        while (ans.length() != num) {
            if (sum == 0) {
                ans.append(0);
            } else if (sum < 10) {
                ans.append(Integer.toString(sum));
                ansSum+=sum;
                sum = 0;
            } else {
                ans.append("9");
                ansSum+=9;
                sum -= 9;
            }
        }

        return ansSum==checkSum?ans.toString():"";
    }
}