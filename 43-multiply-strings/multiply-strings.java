class Solution {
    public String multiply(String num1, String num2) {
        if(num2.equals("0") || num1.equals("0"))
            return "0";
            
        int len1 = num1.length(), len2 = num2.length(), count = 0;
        ArrayDeque<String> queue = new ArrayDeque<>();

        for (int i = len2 - 1; i >= 0; i--) {
            int carry = 0;
            int number2 = num2.charAt(i) - '0';
            StringBuilder number = new StringBuilder();

            for (int j = len1 - 1; j >= 0; j--) {
                int number1 = num1.charAt(j) - '0';
                int toAdd = ((number1 * number2) + carry) % 10;
                carry = ((number1 * number2) + carry) / 10;
                number.insert(0, Integer.toString(toAdd));
            }

            if (carry != 0)
                number.insert(0, Integer.toString(carry));
            int temp = count;
            while (temp > 0) {
                number.append("0");
                temp--;
            }
            count++;
            queue.add(number.toString());
        }

        while (queue.size() != 1) {
            String number1 = queue.poll();
            String number2 = queue.poll();
            int length1 = number1.length(), length2 = number2.length(), idx1 = length1 - 1, idx2 = length2 - 1,
                    carry = 0;
            StringBuilder ans = new StringBuilder();
            char ch1, ch2;

            while (idx1 >= 0 || idx2 >= 0) {
                if (idx1 >= 0)
                    ch1 = number1.charAt(idx1--);
                else
                    ch1 = '0';

                if (idx2 >= 0)
                    ch2 = number2.charAt(idx2--);
                else
                    ch2 = '0';

                int digit1 = ch1 - '0';
                int digit2 = ch2 - '0';
                int sum = carry + digit1 + digit2;
                carry = sum / 10;
                ans.insert(0, sum % 10);
            }

            if (carry > 0)
                ans.insert(0, Integer.toString(carry));
            queue.add(ans.toString());
        }

        return queue.poll();
    }
}