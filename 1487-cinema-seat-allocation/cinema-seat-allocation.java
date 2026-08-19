class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        int count = 0, flag = 0;
        HashMap<Integer, List<Integer>> map = new HashMap<>();

        for (int[] seat : reservedSeats) {
            if (!map.containsKey(seat[0]))
                map.put(seat[0], new ArrayList<>());

            map.get(seat[0]).add(seat[1]);
        }

        for (int i : map.keySet()) {

            flag = 0;
            for (int seat : map.get(i)) {
                if (seat == 2 || seat == 3 || seat == 4 || seat == 5) {
                    flag = 1;
                    break;
                }
            }
            if (flag == 0) {
                map.get(i).add(2);
                map.get(i).add(3);
                map.get(i).add(4);
                map.get(i).add(5);
                count++;
            }

            flag = 0;
            for (int seat : map.get(i)) {
                if (seat == 4 || seat == 5 || seat == 6 || seat == 7) {
                    flag = 1;
                    break;
                }
            }
            if (flag == 0) {
                map.get(i).add(4);
                map.get(i).add(5);
                map.get(i).add(6);
                map.get(i).add(7);
                count++;
            }

            flag = 0;
            for (int seat : map.get(i)) {
                if (seat == 6 || seat == 7 || seat == 8 || seat == 9) {
                    flag = 1;
                    break;
                }
            }

            if (flag == 0) {
                map.get(i).add(6);
                map.get(i).add(7);
                map.get(i).add(8);
                map.get(i).add(9);
                count++;
            }
        }

        count += 2 * (n - map.size());
        return count;
    }
}