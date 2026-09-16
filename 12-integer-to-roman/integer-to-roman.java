class Solution {
    public String intToRoman(int num) {
        String value[]={"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        int arr[] = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
        StringBuilder ans = new StringBuilder();

        while (num > 0) {

            for (int i=0;i<arr.length;i++) {
                if (arr[i] > num)
                    continue;

                ans.append(value[i]);
                num -= arr[i];
                break;
            }
        }

        return ans.toString();
    }
}