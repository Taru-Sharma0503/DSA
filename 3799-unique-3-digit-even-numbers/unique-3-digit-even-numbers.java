class Solution {
    HashSet<Integer> set = new HashSet<>();

    public int totalNumbers(int[] digits) {

        for (int i = 0; i < digits.length; i++) {
            if (digits[i] % 2 == 0) {
                makeCombinations(digits, i, -1, 0, 0);
            }
        }

        return set.size();
    }

    public void makeCombinations(int[] digits, int last, int prev,
                                 int count, int num) {

        if (count == 2) {
            set.add(num * 10 + digits[last]);
            return;
        }

        for (int i = 0; i < digits.length; i++) {

            if (i == last || i == prev)
                continue;

            if (count == 0 && digits[i] == 0)
                continue;

            makeCombinations(
                digits,
                last,
                i,
                count + 1,
                num * 10 + digits[i]
            );
        }
    }
}