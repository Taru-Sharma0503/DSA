class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int n = people.length, i, ans = 0, s = 0, e = n - 1;

        while (s <= e) {
            if (people[e] == limit) {
                e--;
            } else {
                if (people[e] + people[s] <= limit) {
                    s++;
                    e--;
                } else
                    e--;
            }
            ans++;
        }

        return ans;
    }
}
