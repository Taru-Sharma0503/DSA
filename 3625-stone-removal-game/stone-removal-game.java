class Solution {
    public boolean canAliceWin(int n) {
        boolean aliceTurn = true;
        int stonesToRemove = 10;

        while (n > 0) {
            if (stonesToRemove > n) {
                if (aliceTurn)
                    return false;
                return true;
            }

            n -= stonesToRemove;
            stonesToRemove--;
            aliceTurn = !aliceTurn;
        }

        if (aliceTurn)
            return false;
        return true;
    }
}