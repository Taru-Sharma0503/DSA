class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int n = weights.length, minCapacity = 0, maxCapacity = 0, ans = Integer.MAX_VALUE, low = 0, high = n - 1;

        for (int weight : weights) {
            maxCapacity += weight;
            minCapacity = Math.max(weight, minCapacity);
        }

        low = minCapacity;
        high = maxCapacity;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            boolean isAllowed = valid(weights, days, mid);
            if (isAllowed) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }

    public boolean valid(int[] weights, int days, int capacity) {
        int day = 0, weight = 0;

        for (int i = 0; i < weights.length; i++) {
            if (weight + weights[i] <= capacity)
                weight += weights[i];
            else {
                day++;
                if(day>days)
                    return false;
                weight = weights[i];
            }
        }
        day++;

        return day <= days;
    }
}