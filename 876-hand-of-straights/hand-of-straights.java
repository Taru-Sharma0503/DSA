class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0)
            return false;
        Arrays.sort(hand);
        int n = hand.length, i = 0, k = 1, j;
        boolean used[] = new boolean[n];

        while (i < n) {
            if (used[i]) {
                i++;
                continue;
            }

            j = i + 1;
            k = 1;
            int valNeeded = hand[i] + 1;
            used[i] = true;

            while (j < n && k < groupSize) {
                if (!used[j] && hand[j] == valNeeded) {
                    k++;
                    valNeeded += 1;
                    used[j] = true;
                }
                j++;
            }

            if (k != groupSize)
                return false;
            i++;
        }

        return true;
    }
}