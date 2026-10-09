class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        boolean oddPlacement = false;
        int len = flowerbed.length, count = 0, i;
        if (len == 1) {
            if ((n == 1 && flowerbed[0] == 0) || (n == 0))
                return true;
            else
                return false;
        }

        i = 0;
        while (i < len) {
            if (count == n)
                break;

            if (flowerbed[i] == 0) {
                if ((i == 0 || flowerbed[i - 1] == 0) &&
                        (i == len - 1 || flowerbed[i + 1] == 0)) {
                    count++;
                    flowerbed[i] = 1;
                }
            }
            i++;
        }

        return count >= n;

    }
}